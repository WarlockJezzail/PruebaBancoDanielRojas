package com.example.pruebabanco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class HOME_ACT extends AppCompatActivity {

    private ViewFlipper vf;
    //
    private int[] images={R.drawable.a,R.drawable.b,R.drawable.c};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h_o_m_e__a_c_t);

        vf= (ViewFlipper)findViewById(R.id.slider);

        for (int i=0;i<images.length; i++)
        {
            flip_image(images[i]);
        }
    }
    public void flip_image(int i)
    {
        ImageView view =new ImageView(this);
        view.setBackgroundResource(i);

        vf.addView(view);
        vf.setAutoStart(true);
        vf.setFlipInterval(5000);

        vf.setInAnimation(this, android.R.anim.slide_in_left);
        vf.setOutAnimation(this, android.R.anim.slide_out_right);
    }

    public void Cliente (View view){
        Intent i = new Intent(this, CLIENTE_ACT.class);
        startActivity(i);
    }
    public void Info (View view){
        Intent i = new Intent(this, INFO_ACT.class);
        startActivity(i);
    }
    public void Seguridad (View view){
        Intent i = new Intent(this, SEGURIDAD_ACT.class);
        startActivity(i);
    }
    public void Prestamoas (View view){
        Intent i = new Intent(this, PRESTAMOS_ACT.class);
        startActivity(i);
    }
}