package com.example.imageslider;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.TextView;

public class Estreno5 extends AppCompatActivity {

    private ImageButton btnverT5;
    private ImageButton btnDominion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estreno5);

        this.btnDominion = findViewById(R.id.btnDominion);
        this.btnverT5 = findViewById(R.id.btnverT5);

        btnverT5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent navegacion = new Intent(Estreno5.this, trailer5.class);
                startActivity(navegacion);
            }
        });

        btnDominion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    mostrarPopUp(view, "“La trama seguirá el dramático final de 'Jurassic World: El reino caído', en el que Isla Nublar es destruida y los dinosaurios liberados dispersados por todo el mundo..“");
                } catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void mostrarPopUp(View view, String sinopsis2){
        try{
            LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
            View popupView = inflater.inflate(R.layout.popup, null);
            PopupWindow pw = new PopupWindow(popupView, 1500, 600, true);
            ((TextView)pw.getContentView().findViewById(R.id.lblSinopsis2)).setText(sinopsis2);

            pw.setElevation(10);
            pw.showAtLocation(view, Gravity.CENTER, 0, 1450);
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }

}