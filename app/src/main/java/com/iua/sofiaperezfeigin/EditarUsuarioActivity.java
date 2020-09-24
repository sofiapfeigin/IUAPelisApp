package com.iua.sofiaperezfeigin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class EditarUsuarioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_usuario);
    }

    public void menuPrincipal(View view){
        Intent intent = new Intent(EditarUsuarioActivity.this,  MenuPrincipalActivity.class);
        startActivity(intent);
    }
    public void enviarEmail(View view){
        Intent intent = new Intent(EditarUsuarioActivity.this,  EnviarEmailActivity.class);
        startActivity(intent);
    }

    public void favoritos(View view){
        Intent intent = new Intent(EditarUsuarioActivity.this,  FavoritosActivity.class);
        startActivity(intent);
    }

    public void categorias(View view){
        Intent intent = new Intent(EditarUsuarioActivity.this,  CategoriasActivity.class);
        startActivity(intent);
    }


}