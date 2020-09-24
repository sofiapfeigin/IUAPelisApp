package com.iua.sofiaperezfeigin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class IniciarSesionActivity extends AppCompatActivity {

    TextView user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);
        user=findViewById(R.id.email);
    }

    public void splashActivity(View view){
        Intent intent = new Intent(IniciarSesionActivity.this,  SplashActivity.class);
        intent.putExtra("usuario", user.getText().toString());
        startActivity(intent);
    }
}