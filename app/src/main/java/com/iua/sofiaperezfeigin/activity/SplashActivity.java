package com.iua.sofiaperezfeigin.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;

import android.content.Intent;
import android.os.Handler;
import android.widget.TextView;

import com.iua.sofiaperezfeigin.R;

public class SplashActivity extends AppCompatActivity {
    public MediaPlayer ring;

    TextView label;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        label=findViewById(R.id.usuario);
        String user=getIntent().getStringExtra("usuario");
        ring=MediaPlayer.create(this, R.raw.intro);
        ring.start();

        label.setText("¡Bienvenido/a "+user+"!");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent( SplashActivity.this,MenuPrincipalActivity.class));
                finish();
            }
        },2000);
    }
}


