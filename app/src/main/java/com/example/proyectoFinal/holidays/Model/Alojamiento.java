package com.example.proyectoFinal.holidays.Model;

import android.database.sqlite.SQLiteDatabase;

public class Alojamiento {
    private int id;
    private String condiciones_uso;
    private String descripcion;
    private String disponibilidad;
    private int num_banos;
    private int num_camas;
    private int num_habitaciones;
    private int num_huespedes;
    private double precio_noche;
    private String servicios;
    private String ubicacion;
    private int id_ciudad;
    private int id_tipo;
    private int usu_is;

    public Alojamiento() {
    }

    public Alojamiento(String condiciones_uso, String descripcion, String disponibilidad,
                       int num_banos, int num_camas, int num_habitaciones, int num_huespedes,
                       double precio_noche, String servicios, String ubicacion, int id_ciudad, int id_tipo, int usu_is) {
        this.condiciones_uso = condiciones_uso;
        this.descripcion = descripcion;
        this.disponibilidad = disponibilidad;
        this.num_banos = num_banos;
        this.num_camas = num_camas;
        this.num_habitaciones = num_habitaciones;
        this.num_huespedes = num_huespedes;
        this.precio_noche = precio_noche;
        this.servicios = servicios;
        this.ubicacion = ubicacion;
        this.id_ciudad = id_ciudad;
        this.id_tipo = id_tipo;
        this.usu_is = usu_is;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCondiciones_uso() {
        return condiciones_uso;
    }

    public void setCondiciones_uso(String condiciones_uso) {
        this.condiciones_uso = condiciones_uso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public int getNum_banos() {
        return num_banos;
    }

    public void setNum_banos(int num_banos) {
        this.num_banos = num_banos;
    }

    public int getNum_camas() {
        return num_camas;
    }

    public void setNum_camas(int num_camas) {
        this.num_camas = num_camas;
    }

    public int getNum_habitaciones() {
        return num_habitaciones;
    }

    public void setNum_habitaciones(int num_habitaciones) {
        this.num_habitaciones = num_habitaciones;
    }

    public int getNum_huespedes() {
        return num_huespedes;
    }

    public void setNum_huespedes(int num_huespedes) {
        this.num_huespedes = num_huespedes;
    }

    public double getPrecio_noche() {
        return precio_noche;
    }

    public void setPrecio_noche(double precio_noche) {
        this.precio_noche = precio_noche;
    }

    public String getServicios() {
        return servicios;
    }

    public void setServicios(String servicios) {
        this.servicios = servicios;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getId_ciudad() {
        return id_ciudad;
    }

    public void setId_ciudad(int id_ciudad) {
        this.id_ciudad = id_ciudad;
    }

    public int getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }

    public int getUsu_is() {
        return usu_is;
    }

    public void setUsu_is(int usu_is) {
        this.usu_is = usu_is;
    }
}
