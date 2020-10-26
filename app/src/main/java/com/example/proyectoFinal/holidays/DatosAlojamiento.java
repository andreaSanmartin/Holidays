package com.example.proyectoFinal.holidays;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.proyectoFinal.holidays.Model.VariablesGlobales;

public class DatosAlojamiento extends AppCompatActivity {
    ImageButton imgbtninfo;
    ImageButton imgbtnhome;
    ImageButton imgbtnsearch;
    ImageButton imgbtnuser;
    PersonaBD personaBD;
    VariablesGlobales va = VariablesGlobales.getInstance();
    Button nuevoalo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_alojamiento);

        personaBD = new PersonaBD(getApplicationContext());
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


        ///////////////LISTAR
        final Cursor cursorusu = personaBD.alojamientousuario();
        String[] desde = new String[]{"alj_descripcion", "alj_num_habitaciones", "alj_precio_noche"};
        int[] hasta = new int[]{R.id.txtvwdesc, R.id.txtvwnohabita, R.id.txtvwprecio};

        final CursorAdapter cursorAdapter = new SimpleCursorAdapter(getApplicationContext(),
                R.layout.lista_alojamientousuario, cursorusu, desde, hasta, 0);
        final ListView listView = (ListView)findViewById(R.id.list_alojamientoge);
        listView.setAdapter(cursorAdapter);

        nuevoalo = (Button)findViewById(R.id.btnAgregarAlojamiento);
        nuevoalo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentlog = new Intent(getApplicationContext(), RegistroAlojamiento.class);
                startActivity(intentlog);
            }
        });
    }
}