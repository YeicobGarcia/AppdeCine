package com.example.imageslider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

public class MainActivity extends AppCompatActivity {

    SliderView sliderView;
    int[] images = {R.drawable.one,
    R.drawable.two,
    R.drawable.three,
    R.drawable.four,
    R.drawable.five,
    R.drawable.six};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);


        sliderView = findViewById(R.id.image_slider);

        SliderAdapter sliderAdapter = new SliderAdapter(images);

        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.startAutoCycle();

    }

    /**
     * Metodo que realiza la navegacion entre activitys
     */

    public void irCarter1 (View view){
        Intent i = new Intent(this, Estreno.class);
        startActivity(i);
    }

    public void irCarter2 (View view){
        Intent i = new Intent(this, Estreno2.class);
        startActivity(i);
    }

    public void irCarter3 (View view){
        Intent i = new Intent(this, Estreno3.class);
        startActivity(i);
    }

    public void irCarter4 (View view){
        Intent i = new Intent(this, Estreno4.class);
        startActivity(i);
    }

    public void irCarter5 (View view){
        Intent i = new Intent(this, Estreno5.class);
        startActivity(i);
    }

}