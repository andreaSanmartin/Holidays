package com.example.proyectoFinal.holidays;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.proyectoFinal.holidays.Model.Persona;

public class RegistrarUsuario extends AppCompatActivity {

    ImageButton imgbtninfo;
    ImageButton imgbtnhome;
    ImageButton imgbtnsearch;
    ImageButton imgbtnuser;

    Button buttonGuardar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_usuario);

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



        //Casting componentes
        final EditText editTextNombre = (EditText) findViewById(R.id.txtnombreus);
        final EditText editTextCorreo = (EditText) findViewById(R.id.txtemailus);
        final EditText editTextPassword = (EditText) findViewById(R.id.txtpasswordus);
        final EditText editTextGenero =  (EditText) findViewById(R.id.txtgenerous);
        final EditText editTextTelefono = (EditText) findViewById(R.id.txttelefonous);

        final  PersonaBD personaBd= new PersonaBD(getApplicationContext());
        buttonGuardar= (Button) findViewById(R.id.btnGardar);


        Bundle datos = getIntent().getExtras();
        if (datos == null) {
            buttonGuardar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (editTextNombre.getText().toString().isEmpty()){
                        editTextNombre.setError("Ingrese el nombre");
                        editTextNombre.requestFocus();
                        return;
                    }
                    if (editTextCorreo.getText().toString().isEmpty()){
                        editTextCorreo.setError("Ingrese el correo");
                        editTextCorreo.requestFocus();
                        return;
                    }
                    if (editTextPassword.getText().toString().isEmpty()){
                        editTextPassword.setError("Ingrese el password");
                        editTextPassword.requestFocus();
                        return;
                    }
                    if (editTextGenero.getText().toString().isEmpty()){
                        editTextGenero.setError("Ingrese el genero");
                        editTextGenero.requestFocus();
                        return;
                    }
                    if (editTextTelefono.getText().toString().isEmpty()){
                        editTextTelefono.setError("Ingrese el telefono");
                        editTextTelefono.requestFocus();
                        return;
                    }
                    Persona persona = new Persona(editTextNombre.getText().toString(), editTextCorreo.getText().toString(),
                            editTextPassword.getText().toString(), editTextGenero.getText().toString(), editTextTelefono.getText().toString(), "true");

                    String mensaje = personaBd.ingreso(persona);
                    if (mensaje == null) {
                        Toast.makeText(getApplicationContext(), "Usuario Creado", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_SHORT).show();
                    }
                    Intent intentlog = new Intent(getApplicationContext(), Login.class);
                    startActivity(intentlog);

                }
            });
        }/*else {
            /*buttonGuardar.setText("Actualizar");
            String id = datos.getString("codigo");
            String nom = datos.getString("nombre");
            String tam = datos.getString("tamano");
            String ing = datos.getString("ingredientes");
            /*Double cos = datos.getDouble("costo");
            Double pvp = datos.getDouble("pvp");*/
            /*String cos = datos.getString("costo");
            String pvp = datos.getString("pvp");
            String com = datos.getString("promocion");

            editTextCodigo.setText(id);
            editTextCodigo.setEnabled(false);
            editTextNombre.setText(nom);
            editTextTamano.setText(tam);
            editTextIngredientes.setText(ing);
            editTextCosto.setText(cos);
            editTextPvp.setText(pvp);
            editTextPomocion.setText(com);

            buttonGuardar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Pizzeria pizzeria = new Pizzeria(editTextCodigo.getText().toString(), editTextNombre.getText().toString(),
                            editTextTamano.getText().toString(), editTextIngredientes.getText().toString(), editTextCosto.getText().toString(),
                            editTextPvp.getText().toString(),editTextPomocion.getText().toString());
                    if (pizzeriaBD.editarPizza(pizzeria) == null) {
                        Toast.makeText(getApplicationContext(), "Pizza Modificada", Toast.LENGTH_SHORT).show();
                        finish();
                        return;
                    } else {
                        Toast.makeText(getApplicationContext(), "Error " + pizzeriaBD.editarPizza(pizzeria), Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }*/
    }
}