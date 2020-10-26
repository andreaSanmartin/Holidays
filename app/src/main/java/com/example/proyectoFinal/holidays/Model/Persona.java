package com.example.proyectoFinal.holidays.Model;

import java.sql.Date;

public class Persona {

        private long usu_id;
        private String usu_nombre;
        private String usu_correo;
        private String usu_genero;
        private Date usu_fecha_nac;
        private String usu_telefono;
        private String password;
        private String estado;


        public Persona( String usu_nombre, String usu_correo, String password, String usu_genero, String usu_telefono, String estado) {
            this.usu_nombre = usu_nombre;
            this.usu_correo = usu_correo;
            this.usu_genero = usu_genero;
            /*this.usu_fecha_nac = usu_fecha_nac;*/
            this.usu_telefono = usu_telefono;
            this.password = password;
            this.estado = estado;
        }

        public long getUsu_id() {
            return usu_id;
        }

        public void setUsu_id(long usu_id) {
            this.usu_id = usu_id;
        }

        public String getUsu_nombre() {
            return usu_nombre;
        }

        public void setUsu_nombre(String usu_nombre) {
            this.usu_nombre = usu_nombre;
        }

        public String getUsu_correo() {
            return usu_correo;
        }

        public void setUsu_correo(String usu_correo) {
            this.usu_correo = usu_correo;
        }

        public String getUsu_genero() {
            return usu_genero;
        }

        public void setUsu_genero(String usu_genero) {
            this.usu_genero = usu_genero;
        }

        public Date getUsu_fecha_nac() {
            return usu_fecha_nac;
        }

        public void setUsu_fecha_nac(Date usu_fecha_nac) {
            this.usu_fecha_nac = usu_fecha_nac;
        }

        public String getUsu_telefono() {
            return usu_telefono;
        }

        public void setUsu_telefono(String usu_telefono) {
            this.usu_telefono = usu_telefono;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getEstado() {
            return estado;
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }
}
