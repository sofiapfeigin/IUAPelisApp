package com.iua.sofiaperezfeigin.modelo;

public class Pelicula {

    private String nombre;
    private String foto;
    private String descr;
    private String fav;
    private String cat;


    public Pelicula(String nombre, String foto, String descr, String fav, String cat) {
        this.nombre = nombre;
        this.foto = foto;
        this.descr = descr;
        this.fav = fav;
        this.cat=cat;

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

    public String getFav() {
        return fav;
    }

    public void setFav(String fav) {
        this.fav = fav;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }
}
