package com.iua.sofiaperezfeigin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DetallePeliculaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_pelicula);
    }

    public void menuPrincipal(View view){
        Intent intent = new Intent(DetallePeliculaActivity.this,  MenuPrincipalActivity.class);
        startActivity(intent);
    }
    public void enviarEmail(View view){
        Intent intent = new Intent(DetallePeliculaActivity.this,  EnviarEmailActivity.class);
        startActivity(intent);
    }
    public void favoritos(View view){
        Intent intent = new Intent(DetallePeliculaActivity.this,  FavoritosActivity.class);
        startActivity(intent);
    }

    public void editarUsuario(View view){
        Intent intent = new Intent(DetallePeliculaActivity.this,  EditarUsuarioActivity.class);
        startActivity(intent);
    }

    public void categorias(View view){
        Intent intent = new Intent(DetallePeliculaActivity.this,  CategoriasActivity.class);
        startActivity(intent);
    }
}