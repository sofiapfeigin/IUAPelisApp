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
import android.widget.CheckBox;
import android.widget.EditText;

import com.iua.sofiaperezfeigin.R;

public class IniciarSesionActivity extends AppCompatActivity {

    EditText usuario;
    EditText passwd;
    String user;
    String contra;
    String rec;
    CheckBox recordar;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);
        usuario = findViewById(R.id.email);
        passwd = findViewById(R.id.editTextTextPassword);
        recordar = findViewById(R.id.checkBox);
        prefs = getSharedPreferences("PreferenciasUsuario", Context.MODE_PRIVATE);

        user = prefs.getString("usuario", "0");
        contra = prefs.getString("contrasena", "0");
        rec = prefs.getString("recordar", "0");


        if (rec.equals("true")) {
            System.out.println("entro");
            usuario.setText(prefs.getString("usuario", "0"));
            passwd.setText(prefs.getString("contrasena", "0"));
            recordar.setChecked(true);

        }


        findViewById(R.id.iniciarSesion).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (user == "0") {
                    mostrarDialogoError();
                } else {
                    if (passwd.getText().toString().equals(contra)) {
                        if (recordar.isChecked() == true) {
                            SharedPreferences.Editor editor = prefs.edit();
                            editor.putString("recordar", "true");

                            editor.commit();

                        }
                        else{
                            SharedPreferences.Editor editor = prefs.edit();
                            editor.putString("recordar", "false");

                            editor.commit();
                        }
                        splashActivity();
                    } else
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
                        new DialogInterface.OnClickListener() {
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
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                dialog.dismiss();

                            }
                        }).show();
    }

    public void splashActivity() {
        Intent intent = new Intent(IniciarSesionActivity.this, SplashActivity.class);
        intent.putExtra("usuario", usuario.getText().toString());
        startActivity(intent);
    }
}