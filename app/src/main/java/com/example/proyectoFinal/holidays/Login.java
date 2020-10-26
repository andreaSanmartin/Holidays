package com.example.proyectoFinal.holidays;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.proyectoFinal.holidays.Model.VariablesGlobales;

public class Login extends AppCompatActivity {
    ImageButton imgbtninfo;
    ImageButton imgbtnhome;
    ImageButton imgbtnsearch;
    ImageButton imgbtnuser;

    PersonaBD personaBD;
    Button login;
    EditText usuario, password;
    VariablesGlobales va = VariablesGlobales.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

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
                //Intent intentlog = new Intent(getApplicationContext(), Login.class);
                //startActivity(intentlog);
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


        login= (Button)findViewById(R.id.btniniciar);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usuario= (EditText) findViewById(R.id.txtusuario);
                password= (EditText) findViewById(R.id.txtclave);
                Cursor cursor =  personaBD.login(usuario.getText().toString(), password.getText().toString());
                String corre12 = usuario.getText().toString();
                va.setCorreousuario(corre12);
                String pass12 =password.getText().toString();
                va.setPasusuario(pass12);
                if( cursor != null){
                    Toast.makeText(Login.this, "Inicio Correcto", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Login.this, BtnUsuarioAlojamiento.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(Login.this, "Usuario/Contraseña Incorrecto", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}