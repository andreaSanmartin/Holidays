package com.example.proyectoFinal.holidays;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class ListadoBuscar extends AppCompatActivity {
    Button reservar;

    ImageButton imgbtninfo;
    ImageButton imgbtnhome;
    ImageButton imgbtnsearch;
    ImageButton imgbtnuser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_buscar);

        /*//MENU DE BOTONES
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
        });*/

        final ReservarAlojamientoBD raBD = new ReservarAlojamientoBD(getApplicationContext());
        final Cursor cursorRA = raBD.listarAlojamiento();
        String[] desde = new String[]{"res_id","res_fecha_fin" , "res_fecha_inicio", "res_num_dias", "res_total"};
        int[] hasta = new int[]{R.id.txtVID, R.id.txtVFFin, R.id.txtVFInicio, R.id.txtNDias, R.id.txtVTotal};

        final CursorAdapter ralAdapter = new SimpleCursorAdapter(getApplicationContext(),
                R.layout.activity_datos_reserva, cursorRA, desde, hasta, 0);
        final ListView lista = (ListView)findViewById(R.id.ListarAlojamiento);
        lista.setAdapter(ralAdapter);

        /*reservar = (Button)findViewById(R.id.btnReservar);
        reservar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent(ListadoBuscar.this, ReservarAlojamiento.class));
            }
        });*/


    }
}