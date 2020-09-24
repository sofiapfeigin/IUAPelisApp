package com.iua.sofiaperezfeigin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CategoriasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias);
    }

    public void menuPrincipal(View view){
        Intent intent = new Intent(CategoriasActivity.this,  MenuPrincipalActivity.class);
        startActivity(intent);
    }
    public void enviarEmail(View view){
        Intent intent = new Intent(CategoriasActivity.this,  EnviarEmailActivity.class);
        startActivity(intent);
    }
    public void favoritos(View view){
        Intent intent = new Intent(CategoriasActivity.this,  FavoritosActivity.class);
        startActivity(intent);
    }

    public void editarUsuario(View view){
        Intent intent = new Intent(CategoriasActivity.this,  EditarUsuarioActivity.class);
        startActivity(intent);
    }
}