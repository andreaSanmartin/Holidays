package com.example.proyectoFinal.holidays.Model;

public class TipoAlo {
    int tip_id;
    String tip_tipo;

    public TipoAlo(int tip_id, String tip_tipo) {
        this.tip_id = tip_id;
        this.tip_tipo = tip_tipo;
    }

    public TipoAlo() {
    }

    public int getTip_id() {
        return tip_id;
    }

    public void setTip_id(int tip_id) {
        this.tip_id = tip_id;
    }

    public String getTip_tipo() {
        return tip_tipo;
    }

    public void setTip_tipo(String tip_tipo) {
        this.tip_tipo = tip_tipo;
    }


}
