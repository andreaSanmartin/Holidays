package com.example.proyectoFinal.holidays.Model;

import java.sql.Date;

public class VariablesGlobales {
    private static VariablesGlobales instance;
    public static int codusuario;
    public static String nomusuario;
    public static String correousuario;
    public static String genusuario;
    public static Date naciusuario;
    public static String telusuario;
    public static String pasusuario;
    public static boolean estusuario;
    public static String idalj;
    public static String condicionalj;
    public static String descalj;
    public static boolean disponibilidadalj;
    public static int banosalj;
    public static int camasalj;
    public static int habitacionesalj;
    public static int huespedesalj;
    public static double precioalj;
    public static String serviciosalj;
    public static String ubicacionalj;

    public VariablesGlobales() {
    }

    public void setCodusuario(int codusuario) {
        VariablesGlobales.codusuario = codusuario;
    }

    public int getCodusuario() {
        return codusuario;
    }

    public void setInstance(VariablesGlobales instance) {
        VariablesGlobales.instance = instance;
    }

    public String getNomusuario() {
        return nomusuario;
    }

    public void setNomusuario(String nomusuario) {
        VariablesGlobales.nomusuario = nomusuario;
    }

    public String getCorreousuario() {
        return correousuario;
    }

    public void setCorreousuario(String correousuario) {
        VariablesGlobales.correousuario = correousuario;
    }

    public String getGenusuario() {
        return genusuario;
    }

    public void setGenusuario(String genusuario) {
        VariablesGlobales.genusuario = genusuario;
    }

    public Date getNaciusuario() {
        return naciusuario;
    }

    public void setNaciusuario(Date naciusuario) {
        VariablesGlobales.naciusuario = naciusuario;
    }

    public String getTelusuario() {
        return telusuario;
    }

    public void setTelusuario(String telusuario) {
        VariablesGlobales.telusuario = telusuario;
    }

    public String getPasusuario() {
        return pasusuario;
    }

    public void setPasusuario(String pasusuario) {
        VariablesGlobales.pasusuario = pasusuario;
    }

    public boolean getEstusuario() {
        return estusuario;
    }

    public void setEstusuario(boolean estusuario) {
        VariablesGlobales.estusuario = estusuario;
    }

    public String getIdalj() {
        return idalj;
    }

    public void setIdalj(String idalj) {
        VariablesGlobales.idalj = idalj;
    }

    public String getCondicionalj() {
        return condicionalj;
    }

    public void setCondicionalj(String condicionalj) {
        VariablesGlobales.condicionalj = condicionalj;
    }

    public String getDescalj() {
        return descalj;
    }

    public void setDescalj(String descalj) {
        VariablesGlobales.descalj = descalj;
    }

    public boolean getDisponibilidadalj() {
        return disponibilidadalj;
    }

    public void setDisponibilidadalj(boolean disponibilidadalj) {
        VariablesGlobales.disponibilidadalj = disponibilidadalj;
    }

    public int getBanosalj() {
        return banosalj;
    }

    public void setBanosalj(int banosalj) {
        VariablesGlobales.banosalj = banosalj;
    }

    public int getCamasalj() {
        return camasalj;
    }

    public void setCamasalj(int camasalj) {
        VariablesGlobales.camasalj = camasalj;
    }

    public int getHabitacionesalj() {
        return habitacionesalj;
    }

    public void setHabitacionesalj(int habitacionesalj) {
        VariablesGlobales.habitacionesalj = habitacionesalj;
    }

    public int getHuespedesalj() {
        return huespedesalj;
    }

    public void setHuespedesalj(int huespedesalj) {
        VariablesGlobales.huespedesalj = huespedesalj;
    }

    public double getPrecioalj() {
        return precioalj;
    }

    public void setPrecioalj(double precioalj) {
        VariablesGlobales.precioalj = precioalj;
    }

    public String getServiciosalj() {
        return serviciosalj;
    }

    public void setServiciosalj(String serviciosalj) {
        VariablesGlobales.serviciosalj = serviciosalj;
    }

    public String getUbicacionalj() {
        return ubicacionalj;
    }

    public void setUbicacionalj(String ubicacionalj) {
        VariablesGlobales.ubicacionalj = ubicacionalj;
    }

    public static synchronized VariablesGlobales getInstance() {
        if (instance == null) {
            instance = new VariablesGlobales();
        }
        return instance;
    }
}
