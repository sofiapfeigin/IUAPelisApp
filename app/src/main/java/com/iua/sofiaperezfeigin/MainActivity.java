package com.iua.sofiaperezfeigin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void loguearse(View view){
        Intent intent = new Intent(MainActivity.this,  CrearCuentaActivity.class);
        startActivity(intent);
    }
    public void iniciarSesion(View view){
        Intent intent = new Intent(MainActivity.this,  IniciarSesionActivity.class);
        startActivity(intent);
    }
}