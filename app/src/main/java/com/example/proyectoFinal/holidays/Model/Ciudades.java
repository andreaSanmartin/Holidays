package com.example.proyectoFinal.holidays.Model;

public class Ciudades {
    int ciu_id;
    String cui_nombre;
    int pro_id;

    public Ciudades() {

    }

    public Ciudades(int ciu_id, String cui_nombre, int pro_id) {
        this.ciu_id = ciu_id;
        this.cui_nombre = cui_nombre;
        this.pro_id = pro_id;
    }

    public int getCiu_id() {
        return ciu_id;
    }

    public void setCiu_id(int ciu_id) {
        this.ciu_id = ciu_id;
    }

    public String getCui_nombre() {
        return cui_nombre;
    }

    public void setCui_nombre(String cui_nombre) {
        this.cui_nombre = cui_nombre;
    }

    public int getPro_id() {
        return pro_id;
    }

    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }
}
