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
import android.widget.TextView;

import com.example.proyectoFinal.holidays.Model.VariablesGlobales;

public class DatosUsuario extends AppCompatActivity {

    ImageButton imgbtninfo;
    ImageButton imgbtnhome;
    ImageButton imgbtnsearch;
    ImageButton imgbtnuser;
    PersonaBD personaBD;
    VariablesGlobales va = VariablesGlobales.getInstance();
    Button editar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_usuario);

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
        final Cursor cursorusu = personaBD.login(va.getCorreousuario(), va.getPasusuario());
        String[] desde = new String[]{"usu_id", "usu_nombre", "usu_correo", "usu_password", "usu_fecha_nac", "usu_genero", "usu_telefono"};
        int[] hasta = new int[]{R.id.txtvwcodusu, R.id.txtvwnombre, R.id.txtvwcorreo, R.id.txtvwcontraseña,
                R.id.txtvwfechausu, R.id.txtvwgenero, R.id.txtvwtelefono};

        System.out.println("CURSOR: "+cursorusu);

        final CursorAdapter cursorAdapter = new SimpleCursorAdapter(getApplicationContext(),
                R.layout.lista_usuariologin, cursorusu, desde, hasta, 0);
        final ListView listView = (ListView)findViewById(R.id.list_datosusu);
        listView.setAdapter(cursorAdapter);

        editar = (Button)findViewById(R.id.btnEditarUsuario);
        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentlog = new Intent(getApplicationContext(), RegistrarUsuario.class);
                startActivity(intentlog);
            }
        });
    }
}