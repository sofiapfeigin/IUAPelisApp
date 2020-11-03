package com.iua.sofiaperezfeigin.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.iua.sofiaperezfeigin.R;

public class IniciarSesionActivity extends AppCompatActivity {

    EditText usuario;
    EditText passwd;
    Button iniciarSesion;
    String user;
    String contra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);
        usuario=findViewById(R.id.email);
        passwd=findViewById(R.id.editTextTextPassword);

        SharedPreferences prefs = getSharedPreferences("PreferenciasUsuario", Context.MODE_PRIVATE);

        user = prefs.getString("usuario", "0");
        contra = prefs.getString("contrasena", "0");

        findViewById(R.id.iniciarSesion).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(user=="0"){
                    mostrarDialogoError();
                }
                else {
                    if(passwd.getText().toString().equals(contra))
                        splashActivity();
                    else
                        mostrarDialogoError2();
                }

            }
        });


    }

    private void mostrarDialogoError() {
        AlertDialog.Builder builder = new AlertDialog.Builder(IniciarSesionActivity.this);

        builder.setTitle("Error")
                .setMessage("El usuario ingresado no se encuentra registrado")
                .setPositiveButton("Aceptar",
                        new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                dialog.dismiss();

                            }
                        }).show();
    }

    private void mostrarDialogoError2() {
        AlertDialog.Builder builder = new AlertDialog.Builder(IniciarSesionActivity.this);

        builder.setTitle("Error")
                .setMessage("Contraseña incorrecta")
                .setPositiveButton("Aceptar",
                        new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                dialog.dismiss();

                            }
                        }).show();
    }

    public void splashActivity(){
        Intent intent = new Intent(IniciarSesionActivity.this,  SplashActivity.class);
        intent.putExtra("usuario", usuario.getText().toString());
        startActivity(intent);
    }
}