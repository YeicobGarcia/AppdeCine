package com.example.imageslider;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class Estreno extends AppCompatActivity {

    private ImageButton btnacross;
    private ImageButton btnver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estreno1);

        this.btnacross = findViewById(R.id.btnacross);
        this.btnver = findViewById(R.id.btnverT1);


        btnver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent navegacion = new Intent(Estreno.this, trailer.class);
                startActivity(navegacion);
            }
        });

        btnacross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    mostrarPopUp(view, "“Miles Morales regresa para el próximo capítulo de la saga ganadora del Oscar, Spider-Verse. Una aventura épica que transportará al amigable vecino de Brooklyn, Spider-Man, a través del Multiverso para unir fuerzas con Gwen Stacy y un nuevo equipo de Spider-People, para enfrentarse a un villano más poderoso que cualquier otro que hayan conocido“");
                } catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });


    }
        /**
         * Metodo que crea el popUp
         * @param view
         */
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        public void mostrarPopUp(View view, String sinopsis){
            try{
                LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                View popupView = inflater.inflate(R.layout.popup, null);
                PopupWindow pw = new PopupWindow(popupView, 1500, 600, true);
                ((TextView)pw.getContentView().findViewById(R.id.lblSinopsis)).setText(sinopsis);

                pw.setElevation(10);
                pw.showAtLocation(view, Gravity.CENTER, 0, 1470);
            } catch(Exception ex){
                ex.printStackTrace();
            }
        }

}