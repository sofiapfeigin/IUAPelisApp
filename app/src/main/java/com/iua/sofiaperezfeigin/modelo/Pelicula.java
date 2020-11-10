package com.iua.sofiaperezfeigin.modelo;

public class Pelicula {

    private String nombre;
    private String foto;
    private String descr;

    public Pelicula(String nombre, String foto, String descr) {
        this.nombre = nombre;
        this.foto = foto;
        this.descr=descr;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }
}
