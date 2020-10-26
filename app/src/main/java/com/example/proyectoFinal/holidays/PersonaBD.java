package com.example.proyectoFinal.holidays;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.proyectoFinal.holidays.Model.Persona;
import com.example.proyectoFinal.holidays.Model.VariablesGlobales;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class PersonaBD extends SQLiteOpenHelper {

    private static final String DATABASE="holy.db";

    VariablesGlobales va = VariablesGlobales.getInstance();
    Context miContext;
    public PersonaBD(@Nullable Context context){
        super(context, DATABASE, null,1);
        miContext=context;
        File miArchivo=miContext.getDatabasePath(DATABASE);

        /*verificara primero con ruta absoluta*/
        if (!verificaBD(miArchivo.getAbsolutePath())){
            try {
                System.out.println("se realizo la copia");
                copiarBD(miArchivo);
            }catch (IOException e){
                System.out.println(" no se realizo la copia");
                e.printStackTrace();
            }

        }
    }

    private boolean verificaBD(String ruta){
        SQLiteDatabase miBase=null;

        try {
            System.out.println("se realizo la verificacion");
            miBase = SQLiteDatabase.openDatabase(ruta, null, SQLiteDatabase.OPEN_READONLY);
        }catch (Exception e) {
            System.out.println("no se realizo la verificacion");
            e.printStackTrace();
        }
        if (miBase != null) {
            miBase.close();
        }
        return miBase != null;
    }

    private void copiarBD(File archivoBD) throws IOException {
        InputStream inputStream=miContext.getAssets().open(DATABASE);
        OutputStream outputStream= new FileOutputStream(archivoBD);
        byte[] buffer= new byte[1024];
        int largo;
        while ((largo=inputStream.read(buffer))>0){
            outputStream.write(buffer, 0, largo);
        }
        outputStream.flush();
        outputStream.close();
        inputStream.close();
    }

    public Cursor login(String usu_correo, String usu_password){
        Cursor cursor;
        String sql = "SELECT ROWID as _id,* FROM usuarios WHERE usu_correo IN ('"+usu_correo+"') AND usu_password IN ('"+usu_password+"');";
        cursor= this.getReadableDatabase().rawQuery(sql, null);
        return cursor;
    }

    public Cursor alojamientousuario(){
        Cursor cursor;
        String sql = "SELECT ROWID as _id,* FROM alojamientos WHERE usu_id = '1';";
        cursor= this.getReadableDatabase().rawQuery(sql, null);
        return cursor;
    }

    /*listado de clientes*/
    public Cursor listar(){
        Cursor cursor;
        String sql= "SELECT ROWID as _id,* FROM usuarios";
        cursor= this.getReadableDatabase().rawQuery(sql, null);
        return cursor;
    }


    public String ingreso(Persona persona){
        String sql = "INSERT INTO usuarios ( usu_nombre, usu_correo, usu_password, usu_genero, usu_telefono, usu_estado)";
        sql+= "VALUES ('"+persona.getUsu_nombre()+"','"+persona.getUsu_correo()+"', '"+persona.getPassword()+"', '"+persona.getUsu_genero()+"','"+persona.getUsu_telefono()+"','"+persona.getEstado()+"');";
        try{
            this.getWritableDatabase().execSQL(sql);
        }catch (SQLException ex){
            return "Error al crear:"+ex.getMessage();
        }
        return null;
    }

    public  String eliminar(String correo){
        String sql = "DELETE FROM usuarios WHERE usu_correo IN ('"+correo+"');";
        try {
            this.getWritableDatabase().execSQL(sql);
        }catch (SQLException e){
            return "Error en la eliminación: "+ e.getMessage();
        }
        return null;
    }

    public String getIngredientes(Persona p){
        String sql = "UPDATE usuarios SET " +
                "usu_nombre = '"+p.getUsu_nombre()+"', " +
                "usu_correo = '"+p.getUsu_correo()+"', " +
                "usu_password = '"+p.getPassword()+"', " +
                "usu_genero = '"+p.getUsu_genero()+"', " +
                "usu_telefono = '"+p.getUsu_telefono()+"', " +
                "WHERE usu_correo= '"+p.getUsu_correo()+"'";
        try {
            this.getWritableDatabase().execSQL(sql);
        }catch (SQLException e){
            return "Error en la modificación: "+ e.getMessage();
        }
        return null;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
