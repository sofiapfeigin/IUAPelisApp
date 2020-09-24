package com.iua.sofiaperezfeigin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class FavoritosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        ArrayList<Pelicula> pelicula = new ArrayList<>();
        pelicula=initPelicula();
        RecyclerView recyclerView= findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.setAdapter(new ListAdapter(pelicula, this.getApplicationContext()));

    }

    public void menuPrincipal(View view){
        Intent intent = new Intent(FavoritosActivity.this,  MenuPrincipalActivity.class);
        startActivity(intent);
    }

    public void enviarEmail(View view){
        Intent intent = new Intent(FavoritosActivity.this,  EnviarEmailActivity.class);
        startActivity(intent);
    }

    public void editarUsuario(View view){
        Intent intent = new Intent(FavoritosActivity.this,  EditarUsuarioActivity.class);
        startActivity(intent);
    }
    public void categorias(View view){
        Intent intent = new Intent(FavoritosActivity.this,  CategoriasActivity.class);
        startActivity(intent);
    }
    public void verPelicula(View view){
        Intent intent = new Intent(FavoritosActivity.this,  DetallePeliculaActivity.class);
        startActivity(intent);
    }

    private ArrayList<Pelicula> initPelicula() {
        ArrayList<Pelicula> peliculas = new ArrayList<>();

        peliculas.add(new Pelicula("Los Vengadores", "https://http2.mlstatic.com/posters-cine-avengers-endgame-marvel-peliculas-45x30-cm-D_NQ_NP_634696-MLA30089346405_042019-F.jpg"));
        peliculas.add(new Pelicula("Cisne Negro", "https://hips.hearstapps.com/es.h-cdn.co/fotoes/images/media/imagenes/reportajes/los-20-posters-de-peliculas-mas-creativos/cisne-negro/7055592-1-esl-ES/CISNE-NEGRO.jpg?resize=480:*"));
        peliculas.add(new Pelicula("Alien", "https://i.pinimg.com/originals/fd/82/c1/fd82c1116eb734b625552241e00e2a20.png"));

        return peliculas;
    }
}