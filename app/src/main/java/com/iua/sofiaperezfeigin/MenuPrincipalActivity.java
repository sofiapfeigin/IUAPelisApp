package com.iua.sofiaperezfeigin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MenuPrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        ArrayList<Pelicula> pelicula = new ArrayList<>();
        pelicula=initPelicula();
        RecyclerView recyclerView= findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.setAdapter(new ListAdapter(pelicula, this.getApplicationContext()));
    }

    public void verPelicula(View view){
        Intent intent = new Intent(MenuPrincipalActivity.this,  DetallePeliculaActivity.class);
        startActivity(intent);
    }
    public void enviarEmail(View view){
        Intent intent = new Intent(MenuPrincipalActivity.this,  EnviarEmailActivity.class);
        startActivity(intent);
    }
    public void favoritos(View view){
        Intent intent = new Intent(MenuPrincipalActivity.this,  FavoritosActivity.class);
        startActivity(intent);
    }

    public void editarUsuario(View view){
        Intent intent = new Intent(MenuPrincipalActivity.this,  EditarUsuarioActivity.class);
        startActivity(intent);
    }
    public void categorias(View view){
        Intent intent = new Intent(MenuPrincipalActivity.this,  CategoriasActivity.class);
        startActivity(intent);
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