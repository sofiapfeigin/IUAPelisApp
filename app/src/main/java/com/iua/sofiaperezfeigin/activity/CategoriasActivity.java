package com.iua.sofiaperezfeigin.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.iua.sofiaperezfeigin.ListAdapterCategoria;
import com.iua.sofiaperezfeigin.ListAdapterPeliculaCat;
import com.iua.sofiaperezfeigin.R;
import com.iua.sofiaperezfeigin.modelo.Categoria;
import com.iua.sofiaperezfeigin.modelo.Pelicula;

import java.util.ArrayList;

public class CategoriasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cuenta);

        ArrayList<Categoria> categoria = new ArrayList<>();
        categoria=initCategoria();
        RecyclerView recyclerView= findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ListAdapterCategoria(categoria, this.getApplicationContext()));

        ArrayList<Pelicula> pelicula = new ArrayList<>();
        pelicula=initPelicula();
        RecyclerView recyclerView2= findViewById(R.id.recyclerView2);

        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        recyclerView2.setAdapter(new ListAdapterPeliculaCat(pelicula, this.getApplicationContext()));

    }





    private ArrayList<Categoria> initCategoria() {
        ArrayList<Categoria> categorias = new ArrayList<>();
        ArrayList<Pelicula> peliculasAccion = new ArrayList<>();
        ArrayList<Pelicula> peliculasDrama = new ArrayList<>();
        ArrayList<Pelicula> peliculasGuerra = new ArrayList<>();

        peliculasAccion.add(new Pelicula("Los Vengadores", "https://http2.mlstatic.com/posters-cine-avengers-endgame-marvel-peliculas-45x30-cm-D_NQ_NP_634696-MLA30089346405_042019-F.jpg"));
        peliculasDrama.add(new Pelicula("Cisne Negro", "https://hips.hearstapps.com/es.h-cdn.co/fotoes/images/media/imagenes/reportajes/los-20-posters-de-peliculas-mas-creativos/cisne-negro/7055592-1-esl-ES/CISNE-NEGRO.jpg?resize=480:*"));
        peliculasAccion.add(new Pelicula("Alien", "https://i.pinimg.com/originals/fd/82/c1/fd82c1116eb734b625552241e00e2a20.png"));
        peliculasAccion.add(new Pelicula("Robin Hood", "https://i.blogs.es/873d60/espinof-peores-posters-de-cine-2018-robin-hood/450_1000.jpg"));
        peliculasGuerra.add(new Pelicula("Capitana Marvel", "https://i.pinimg.com/236x/0f/7f/68/0f7f68e4f067a45fa438290726c75c15.jpg"));
        peliculasGuerra.add(new Pelicula("1917", "https://www.mundopeliculas.tv/wp-content/uploads/2020/01/Poster-1917.jpg"));
        peliculasGuerra.add(new Pelicula("El Guason", "https://cdn.shopify.com/s/files/1/0265/2769/4934/products/joker-2019-poster-4_195x195@2x.jpg?v=1570682268"));

        categorias.add(new Categoria("Accion", peliculasAccion));
        categorias.add(new Categoria("Drama", peliculasDrama));
        categorias.add(new Categoria("Guerra", peliculasGuerra));
        categorias.add(new Categoria("Comedia", peliculasAccion));
        categorias.add(new Categoria("Documentales", peliculasDrama));
        categorias.add(new Categoria("Series", peliculasGuerra));

        return categorias;
    }
    private ArrayList<Pelicula> initPelicula() {
        ArrayList<Pelicula> peliculas = new ArrayList<>();

        peliculas.add(new Pelicula("Los Vengadores", "https://http2.mlstatic.com/posters-cine-avengers-endgame-marvel-peliculas-45x30-cm-D_NQ_NP_634696-MLA30089346405_042019-F.jpg"));
        peliculas.add(new Pelicula("Cisne Negro", "https://hips.hearstapps.com/es.h-cdn.co/fotoes/images/media/imagenes/reportajes/los-20-posters-de-peliculas-mas-creativos/cisne-negro/7055592-1-esl-ES/CISNE-NEGRO.jpg?resize=480:*"));
        peliculas.add(new Pelicula("Alien", "https://i.pinimg.com/originals/fd/82/c1/fd82c1116eb734b625552241e00e2a20.png"));
        peliculas.add(new Pelicula("Robin Hood", "https://i.blogs.es/873d60/espinof-peores-posters-de-cine-2018-robin-hood/450_1000.jpg"));
        peliculas.add(new Pelicula("Capitana Marvel", "https://i.pinimg.com/236x/0f/7f/68/0f7f68e4f067a45fa438290726c75c15.jpg"));
        peliculas.add(new Pelicula("1917", "https://www.mundopeliculas.tv/wp-content/uploads/2020/01/Poster-1917.jpg"));
        peliculas.add(new Pelicula("El Guason", "https://cdn.shopify.com/s/files/1/0265/2769/4934/products/joker-2019-poster-4_195x195@2x.jpg?v=1570682268"));

        return peliculas;
    }
}