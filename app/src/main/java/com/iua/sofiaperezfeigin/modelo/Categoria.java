package com.iua.sofiaperezfeigin.modelo;

import java.util.List;

public class Categoria {

    private String nombreCateg;
    private List<Pelicula> peliculas;

    public Categoria(String nombreCateg, List<Pelicula> peliculas) {
        this.nombreCateg = nombreCateg;
        this.peliculas = peliculas;
    }

    public String getNombreCateg() {
        return nombreCateg;
    }

    public void setNombreCateg(String nombreCateg) {
        this.nombreCateg = nombreCateg;
    }

    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(List<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }


}
