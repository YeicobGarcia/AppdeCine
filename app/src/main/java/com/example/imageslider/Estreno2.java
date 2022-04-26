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

public class Estreno2 extends AppCompatActivity {

    private ImageButton btnBatman;
    private ImageButton btnver2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.estreno2);

        this.btnBatman = findViewById(R.id.btnBatman);
        this.btnver2 = findViewById(R.id.btnverT2);

        btnver2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent navegacion = new Intent(Estreno2.this, trailer2.class);
                startActivity(navegacion);
            }
        });

        btnBatman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    mostrarPopUp(view, "En su segundo año luchando contra el crimen, Batman explora la corrupción existente en la ciudad de Gotham y el vínculo de esta con su propia familia. Además, entrará en conflicto con un asesino en serie conocido como (el Acertijo)");
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
            PopupWindow pw = new PopupWindow(popupView, 1500, 550, true);
            ((TextView)pw.getContentView().findViewById(R.id.lblSinopsis)).setText(sinopsis);

            pw.setElevation(10);
            pw.showAtLocation(view, Gravity.CENTER, 0, 1470);
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }
}