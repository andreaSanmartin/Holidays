package com.example.proyectoFinal.holidays;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectoFinal.holidays.Model.Alojamiento;
import com.example.proyectoFinal.holidays.Model.Ciudades;
import com.example.proyectoFinal.holidays.Model.Persona;
import com.example.proyectoFinal.holidays.Model.TipoAlo;

import java.util.ArrayList;

public class RegistroAlojamiento extends AppCompatActivity {

    ImageButton imgbtninfo;
    ImageButton imgbtnhome;
    ImageButton imgbtnsearch;
    ImageButton imgbtnuser;

    EditText condiciones, descripcion, direccion, banos, camas, habitaciones, huspedes;
    TextView precio;
    CheckBox caliente, wifi, telefono;

    Button cargarIm, guardar;

    Spinner combo_provcincias, combo_tipo;

    ArrayList< String > provinciaslist;
    ArrayList< String > tiposlist;
    ArrayList< Ciudades > listaprovincias;
    ArrayList< TipoAlo > listatipos;
    AlojamientoBd alojamientoBd;

    String servicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_alojamiento);

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

        ///

        condiciones = (EditText) findViewById(R.id.txtcondiciones);
        descripcion = (EditText) findViewById(R.id.txtdescripcion);
        direccion = (EditText) findViewById(R.id.txtdireccion);
        banos =  (EditText) findViewById(R.id.txtbanos);
        camas = (EditText) findViewById(R.id.txtcamas);
        habitaciones = (EditText) findViewById(R.id.txthabitaciones);
        huspedes = (EditText) findViewById(R.id.txthuespedes);
        precio = (TextView) findViewById(R.id.txtprecio);

        caliente = (CheckBox) findViewById(R.id.checkBoxAC);
        wifi = (CheckBox) findViewById(R.id.checkBoxAC);
        telefono = (CheckBox) findViewById(R.id.checkBoxAC);

        guardar = (Button) findViewById(R.id.btnguardaralojamiento);
        cargarIm = (Button) findViewById(R.id.btnimagen);

        combo_tipo = (Spinner) findViewById(R.id.spinnertipo);
        combo_provcincias = (Spinner) findViewById(R.id.spinnerciud);

        alojamientoBd= new AlojamientoBd(getApplicationContext());

        String [] opciones = {"Seleccione", "Quito", "Cuenca", "El Oro","Paute","Azoges"};
        String [] opciones2 = {"Seleccione", "Departamento", "Casa", "Villa "};

        ArrayAdapter<String> arrayAdapter= new ArrayAdapter
                (this,android.R.layout.simple_spinner_item,opciones);
        //consultarListaCiudades();


        ArrayAdapter<String> arrayAdapter2= new ArrayAdapter
                (this,android.R.layout.simple_spinner_item,opciones2);
        //consultarListaTipo();

        Bundle datos = getIntent().getExtras();
        if (datos == null) {
            guardar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (condiciones.getText().toString().isEmpty()){
                        condiciones.setError("Ingrese las condiciones de usu");
                        condiciones.requestFocus();
                        return;
                    }
                    if (descripcion.getText().toString().isEmpty()){
                        descripcion.setError("Ingrese la descrpcion");
                        descripcion.requestFocus();
                        return;
                    }
                    if (direccion.getText().toString().isEmpty()){
                        direccion.setError("Ingrese el password");
                        direccion.requestFocus();
                        return;
                    }
                    if (banos.getText().toString().isEmpty()){
                        banos.setError("Ingrese numero de banos");
                        banos.requestFocus();
                        return;
                    }
                    if (camas.getText().toString().isEmpty()){
                        camas.setError("Ingrese numero de camas");
                        camas.requestFocus();
                        return;
                    }
                    validarcheck();

                    //casteo
                    //double nprecio = Double.parseDouble(precio.getText().toString());
                    int nbanos = Integer.parseInt(banos.getText().toString());
                    int ncamas = Integer.parseInt(banos.getText().toString());
                    int nhabitaciones = Integer.parseInt(banos.getText().toString());
                    int nhuespedes = Integer.parseInt(banos.getText().toString());
                    Alojamiento alojamiento= new Alojamiento(condiciones.getText().toString(), descripcion.getText().toString(), "True",
                            nbanos,ncamas,nhabitaciones,nhuespedes,120,
                            servicio, direccion.getText().toString(), 1,1,1);

                    String mensaje = alojamientoBd.ingreso(alojamiento);
                    if (mensaje == null) {
                        Toast.makeText(getApplicationContext(), "Alojamiento Creado", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_SHORT).show();
                    }

                    Intent intentlog = new Intent(getApplicationContext(), DatosAlojamiento.class);
                    startActivity(intentlog);

                }
            });
        }
    }

    public void Check(View view){
        if(view.getId() == R.id.checkBoxAC){
            validarcheck();
        }
    }


    public void validarcheck(){
        Alojamiento alo= new Alojamiento();
        if (caliente.isChecked()==true){
            servicio="Agua Caliente";
        }
        if (wifi.isChecked()==true){
            servicio="Wifi";
        }
        if (telefono.isChecked()==true){
            servicio="telefono";
        }
    }

    /*private void consultarListaCiudades(){

        Ciudades ciudades= null;
        listaprovincias = new ArrayList<>();
        final Cursor cursor= alojamientoBd.listarCiu();

        while (cursor.moveToNext()){
            ciudades= new Ciudades();
            ciudades.setCui_nombre(cursor.getString(1));

            listaprovincias.add(ciudades);

        }
        obtenerLista();
    }

    private void obtenerLista(){
        provinciaslist= new ArrayList<>();
        provinciaslist.add("Seleccione");

        for(int i=0; i<listaprovincias.size();i++){
         provinciaslist.add(listaprovincias.get(i).getCui_nombre());
        }
    }

    private void consultarListaTipo(){

        TipoAlo tipoAlo= null;
        listatipos = new ArrayList<>();
        final Cursor cursor= alojamientoBd.listartipo();

        while (cursor.moveToNext()){
            tipoAlo= new TipoAlo();
            tipoAlo.setTip_tipo(cursor.getString(1));

            listatipos.add(tipoAlo);

        }
        obtenerLista2();
    }

    private void obtenerLista2(){
        tiposlist= new ArrayList<>();
        tiposlist.add("Seleccione");

        for(int i=0; i<listatipos.size();i++){
            tiposlist.add(listatipos.get(i).getTip_tipo());
        }
    }*/



}