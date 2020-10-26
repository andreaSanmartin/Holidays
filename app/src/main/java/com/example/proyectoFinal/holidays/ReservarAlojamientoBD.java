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

public class ReservarAlojamientoBD extends SQLiteOpenHelper {

    private static final String DATABASE = "holy.db";

    Context miContext;

    public ReservarAlojamientoBD(@Nullable Context context) {
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

    /*listado de alojamiento*/
    public Cursor listarAlojamiento(){
        Cursor cursor;
        String sql= "SELECT  ROWID as _id,* FROM reservaralojamiento";
        cursor= this.getReadableDatabase().rawQuery(sql,null);
        return cursor;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
