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

import com.example.proyectoFinal.holidays.Model.VariablesGlobales;

public class ListaAlojamientos extends AppCompatActivity {
    ImageButton imgbtninfo;
    ImageButton imgbtnhome;
    ImageButton imgbtnsearch;
    ImageButton imgbtnuser;
    AlojamientoBd personaBD;
    VariablesGlobales va = VariablesGlobales.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alojamientos);

        personaBD = new AlojamientoBd(getApplicationContext());
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
        final Cursor cursorusu = personaBD.listar();
        String[] desde = new String[]{"alj_descripcion", "alj_ubicacion","alj_condiciones_uso","alj_num_baños","alj_num_camas","alj_num_habitaciones",
                "alj_num_huespedes","alj_precio_noche","alj_servicios"};
        int[] hasta = new int[]{R.id.descripsion2, R.id.hubicacion2, R.id.condiciones2, R.id.banos2, R.id.camas2, R.id.habitaciones2
                , R.id.huespedes2, R.id.precio2, R.id.servicio2};

        final CursorAdapter cursorAdapter = new SimpleCursorAdapter(getApplicationContext(),
                R.layout.activity_campos, cursorusu, desde, hasta, 0);
        final ListView listView = (ListView)findViewById(R.id.list_alojamientoge);
        listView.setAdapter(cursorAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View acView, int position, long id) {
                Cursor pizzaitem=(Cursor)listView.getItemAtPosition(position);
                String descripcion = pizzaitem.getString(1);
                String hubicacion = pizzaitem.getString(2);
                String condiciones = pizzaitem.getString(3);
                String banos = pizzaitem.getString(4);
                String camas = pizzaitem.getString(5);
                String habitaciones = pizzaitem.getString(6);
                String huespedes = pizzaitem.getString(7);
                String precio = pizzaitem.getString(8);
                String servicio = pizzaitem.getString(9);
                Intent intent = new Intent(getApplicationContext(), DetalleAlojamiento.class);
                intent.putExtra("alj_descripcion",descripcion);
                intent.putExtra("alj_ubicacion",hubicacion);
                intent.putExtra("alj_condiciones_uso",condiciones);
                intent.putExtra("alj_num_baños",banos);
                intent.putExtra("alj_num_camas",camas);
                intent.putExtra("alj_num_habitaciones",habitaciones);
                intent.putExtra("alj_num_huespedes",huespedes);
                intent.putExtra("alj_precio_noche",precio);
                intent.putExtra("alj_servicios",servicio);
                startActivity(intent);
            }
        });

    }
}