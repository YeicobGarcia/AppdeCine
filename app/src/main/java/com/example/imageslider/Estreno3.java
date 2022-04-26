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

public class Estreno3 extends AppCompatActivity {

    private ImageButton btnverT3;
    private ImageButton btnDrStrange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estreno3);

        this.btnDrStrange = findViewById(R.id.btnDrStrange);
        this.btnverT3 = findViewById(R.id.btnverT3);

        btnverT3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent navegacion = new Intent(Estreno3.this, trailer3.class);
                startActivity(navegacion);
            }
        });

        btnDrStrange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    mostrarPopUp(view, "“Viaja a lo desconocido con el Doctor Strange, quien, con la ayuda de aliados místicos tanto antiguos como nuevos, atraviesa las alucinantes y peligrosas realidades alternativas del Multiverso para enfrentarse a un nuevo y misterioso adversario“");
                } catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void mostrarPopUp(View view, String sinopsis){
        try{
            LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
            View popupView = inflater.inflate(R.layout.popup, null);
            PopupWindow pw = new PopupWindow(popupView, 1500, 500, true);
            ((TextView)pw.getContentView().findViewById(R.id.lblSinopsis)).setText(sinopsis);

            pw.setElevation(10);
            pw.showAtLocation(view, Gravity.CENTER, 0, 1470);
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }
}