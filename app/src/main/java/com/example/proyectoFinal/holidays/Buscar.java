package com.example.proyectoFinal.holidays;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class Buscar extends AppCompatActivity {
    ImageButton imgbtninfo;
    ImageButton imgbtnhome;
    ImageButton imgbtnsearch;
    ImageButton imgbtnuser;

    /*EditText txtBuscar = (EditText) findViewById(R.id.editTxtBuscar);
    TextView id = (TextView)findViewById(R.id.txtViewID);
    TextView ciu_nom = (TextView)findViewById(R.id.txtViewCiu_Nombre);*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);

        ///MENU DE BOTONES
        /*imgbtnhome = (ImageButton)findViewById(R.id.btnhome);
        imgbtnhome.setOnClickListener(new View.OnClickListener() {
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



        final CiudadBD ciudadBD = new CiudadBD(getApplicationContext());
        final Cursor cursorCiud = ciudadBD.listarCiudades();
        String[] desde = new String[]{"ciu_id" , "ciu_nombre"};
        int[] hasta = new int[]{R.id.txtViewID, R.id.txtViewCiu_Nombre};

        final CursorAdapter CiudadAdapter = new SimpleCursorAdapter(getApplicationContext(),
                R.layout.activity_lista_ciudad, cursorCiud, desde, hasta, 0);
        final ListView lista = (ListView)findViewById(R.id.listAlojamientoBuscar);
        lista.setAdapter(CiudadAdapter);


        /*Button btnbuscar = (Button)findViewById(R.id.btnBuscar);

        btnbuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CiudadBD cBD = new CiudadBD(getApplicationContext());
                String buscar = txtBuscar.getText().toString();
                String[] datos;
                //datos = cBD.buscar_reg(buscar);
                //id.setText(datos[0]);
                //ciu_nom.setText(datos[1]);
                //Toast.makeText(getApplicationContext(),datos[2],Toast.LENGTH_SHORT).show();
            }

        });*/

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), ListadoBuscar.class);
                startActivity(intent);
            }
        });

    }
}