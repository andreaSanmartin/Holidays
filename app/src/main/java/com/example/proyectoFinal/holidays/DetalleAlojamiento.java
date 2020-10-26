package com.example.proyectoFinal.holidays;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class DetalleAlojamiento extends AppCompatActivity {

    ImageButton imgbtninfo;
    ImageButton imgbtnhome;
    ImageButton imgbtnsearch;
    ImageButton imgbtnuser;
    ViewFlipper v_flipper;
    Button reservar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_alojamiento);

        ///MENU DE BOTONES
        imgbtninfo = (ImageButton)findViewById(R.id.btninfo);
        imgbtninfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentlog = new Intent(getApplicationContext(), Informacion.class);
                startActivity(intentlog);
            }
        });

        imgbtnhome = (ImageButton)findViewById(R.id.btnhome);
        imgbtnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentlog = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intentlog);
            }
        });

        imgbtnsearch = (ImageButton)findViewById(R.id.btnsearch);
        imgbtnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentlog = new Intent(getApplicationContext(), Buscar.class);
                startActivity(intentlog);
            }
        });

        imgbtnuser = (ImageButton)findViewById(R.id.btnuser);
        imgbtnuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentlog = new Intent(getApplicationContext(), InicioRegistro.class);
                startActivity(intentlog);
            }
        });

        ///CARRUSEL DE IMAGENES
        int images[]= {R.drawable.casa, R.drawable.casa2, R.drawable.casa3, R.drawable.casa4, R.drawable.casa5, R.drawable.casa6, R.drawable.casa7, R.drawable.casa8};
        v_flipper = findViewById(R.id.v_flipper);

        //validacion
        for(int image: images){
            flipper(image);
        }

        reservar = (Button)findViewById(R.id.btnreservar);
        reservar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentlog = new Intent(getApplicationContext(), ReservarAlojamiento.class);
                startActivity(intentlog);
            }
        });


    }

    ///METODO PARA VISUALIZAR LAS IMAGENES
    public void flipper(int image){
        ImageView view = new ImageView(this);
        view.setBackgroundResource(image);

        v_flipper.addView(view);
        v_flipper.setFlipInterval(2000);//duracion
        v_flipper.setAutoStart(true);
        v_flipper.setInAnimation(this, android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }
}