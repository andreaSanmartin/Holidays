package com.example.proyectoFinal.holidays;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.proyectoFinal.holidays.Model.Alojamiento;
import com.example.proyectoFinal.holidays.Model.Persona;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class AlojamientoBd extends SQLiteOpenHelper  {
    private static final String DATABASE="holy.db";

    Context miContext;
    public AlojamientoBd(@Nullable Context context){
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
    /*listado de */
   /* public Cursor listarCiu(){
        Cursor cursor;
        String sql= "SELECT cui_nombre  FROM ciudades";
        cursor= this.getReadableDatabase().rawQuery(sql, null);
        return cursor;
    }

    /*listado de */
    /*public Cursor listartipo(){
        Cursor cursor;
        String sql= "SELECT tip_tipo FROM tipovivienda";
        cursor= this.getReadableDatabase().rawQuery(sql, null);
        return cursor;
    }*/

    /*listado de clientes*/
    public Cursor listar(){
        Cursor cursor;
        String sql= "SELECT ROWID as _id,* FROM alojamientos";
        cursor= this.getReadableDatabase().rawQuery(sql, null);
        return cursor;
    }

    public String ingreso(Alojamiento alojamiento){
        String sql = "INSERT INTO alojamientos ( alj_condiciones_uso, alj_descripcion, alj_disponibilidad, " +
                "alj_num_baños, alj_num_camas, alj_num_habitaciones, alj_num_huespedes, alj_precio_noche, " +
                "alj_servicios, alj_ubicacion, ciu_id, tip_id, usu_id)";
        sql+= "VALUES ('"+alojamiento.getCondiciones_uso()+"','"+alojamiento.getDescripcion()+"'," +
                " '"+alojamiento.getDisponibilidad()+"', '"+alojamiento.getNum_banos()+"'," +
                "'"+alojamiento.getNum_camas()+"','"+alojamiento.getNum_habitaciones()+"'," +
                "'"+alojamiento.getNum_huespedes()+"','"+alojamiento.getPrecio_noche()+"'," +
                "'"+alojamiento.getServicios()+"','"+alojamiento.getUbicacion()+"',"+
                "'"+alojamiento.getId_ciudad()+"','"+alojamiento.getId_tipo()+"',"+
                "'"+alojamiento.getUsu_is()+"');";
        try{
            this.getWritableDatabase().execSQL(sql);
        }catch (SQLException ex){
            return "Error al crear:"+ex.getMessage();
        }
        return null;
    }

    public  String eliminar(int id){
        String sql = "DELETE FROM alojamientos WHERE alj_id IN ('"+id+"');";
        try {
            this.getWritableDatabase().execSQL(sql);
        }catch (SQLException e){
            return "Error en la eliminación: "+ e.getMessage();
        }
        return null;
    }

    public String getIngredientes(Alojamiento p){
        String sql = "UPDATE alojamientos SET " +
                "alj_condiciones_uso = '"+p.getCondiciones_uso()+"', " +
                "alj_descripcion = '"+p.getDescripcion()+"', " +
                "alj_num_baños = '"+p.getNum_banos()+"', " +
                "alj_num_camas = '"+p.getNum_camas()+"', " +
                "alj_num_habitaciones = '"+p.getNum_habitaciones()+"', " +
                "alj_num_huespedes = '"+p.getNum_huespedes()+"', " +
                "alj_precio_noche = '"+p.getPrecio_noche()+"', " +
                "alj_servicios = '"+p.getServicios()+"', " +
                "alj_ubicaion = '"+p.getUbicacion()+"', " +
                "ciu_id = '"+p.getId_ciudad()+"', " +
                "tip_id = '"+p.getId_tipo()+"', " +
                "usu_id = '"+p.getUsu_is()+"', " +
                "WHERE alj_id= '"+p.getId()+"'";
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
