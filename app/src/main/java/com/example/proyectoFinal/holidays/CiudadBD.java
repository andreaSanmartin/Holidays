package com.example.proyectoFinal.holidays;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CiudadBD extends SQLiteOpenHelper {

    private static final String DATABASE = "holy.db";

    Context miContext;

    public CiudadBD(@Nullable Context context) {
        super(context, DATABASE, null, 1);
        miContext = context;
        File miArchivo = miContext.getDatabasePath(DATABASE);

        /*verificara primero con ruta absoluta*/
        if (!verificaBD(miArchivo.getAbsolutePath())) {
            try {
                System.out.println("se realizo la copia");
                copiarBD(miArchivo);
            } catch (IOException e) {
                System.out.println(" no se realizo la copia");
                e.printStackTrace();
            }

        }
    }

    private boolean verificaBD(String ruta) {
        SQLiteDatabase miBase = null;

        try {
            System.out.println("Verificación Exitosa");
            miBase = SQLiteDatabase.openDatabase(ruta, null, SQLiteDatabase.OPEN_READONLY);
        } catch (Exception e) {
            System.out.println(" Falló la verificación");
            e.printStackTrace();
        }
        if (miBase != null) {
            miBase.close();
        }
        return miBase != null;
    }

    private void copiarBD(File archivoBD) throws IOException {
        InputStream inputStream = miContext.getAssets().open(DATABASE);
        OutputStream outputStream = new FileOutputStream(archivoBD);
        byte[] buffer = new byte[1024];
        int largo;
        while ((largo = inputStream.read(buffer)) > 0) {
            outputStream.write(buffer, 0, largo);
        }
        outputStream.flush();
        outputStream.close();
        inputStream.close();
    }

    /*listado de Ciudades*/
    public Cursor listarCiudades(){
        Cursor cursor;
        String sql= "SELECT  ROWID as _id,* FROM ciudades";
        cursor= this.getReadableDatabase().rawQuery(sql,null);
        return cursor;
    }

    public String buscar_reg(String buscar){
        String[] datos = new String[1];
        SQLiteDatabase database= this.getWritableDatabase();
        String sql = "SELECT ROWID as _id,* FROM ciudades WHERE ciu_nombre ='"+buscar+"'";
        Cursor reg = database.rawQuery(sql, null) ;
        if(reg.moveToFirst()){
            for(int i =0 ; i<1;i++){
                datos[i]= reg.getString(i);
            }
            datos[1]= "Encontrado";
        }else {
            datos[1] = "No se encontro a" +buscar;
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