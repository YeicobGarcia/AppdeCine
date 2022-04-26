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

public class Estreno4 extends AppCompatActivity {

    private ImageButton btnverT4;
    private ImageButton btnLightyear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estreno4);

        this.btnLightyear = findViewById(R.id.btnLightyear);
        this.btnverT4 = findViewById(R.id.btnverT4);

        btnverT4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent navegacion = new Intent(Estreno4.this, trailer4.class);
                startActivity(navegacion);
            }
        });

        btnLightyear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    mostrarPopUp(view, "“Se trata de la historia de los orígenes de Buzz Lightyear y de cómo pasó de ser un piloto de pruebas al astronauta que inspirara el juguete Space Ranger de la franquicia.“");
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