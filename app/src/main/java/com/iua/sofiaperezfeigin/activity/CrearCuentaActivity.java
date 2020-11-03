package com.iua.sofiaperezfeigin.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.iua.sofiaperezfeigin.R;

public class CrearCuentaActivity extends AppCompatActivity {

    EditText email;
    EditText nombreUsuario;
    EditText passwd1;
    EditText passwd2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cuenta);

        email=findViewById(R.id.editTextTextEmailAddress4);
        nombreUsuario=findViewById(R.id.editTextUser);
        passwd1=findViewById(R.id.editTextTextPassword);
        passwd2=findViewById(R.id.editTextTextPassword2);

        findViewById(R.id.crearCuenta).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(passwd1.getText().toString().equals(passwd2.getText().toString())){
                    SharedPreferences prefs =getSharedPreferences("PreferenciasUsuario", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("email", email.getText().toString());
                    editor.putString("usuario", nombreUsuario.getText().toString());
                    editor.putString("contrasena", passwd1.getText().toString());

                    editor.commit();

                    mostrarDialogoConfir();
                }
                else
                {
                    mostrarDialogoError();
                }


            }
        });
    }


    private void mostrarDialogoConfir() {
        AlertDialog.Builder builder = new AlertDialog.Builder(CrearCuentaActivity.this);

        builder.setTitle("Crear cuenta")
                .setMessage("¿Deseas registrarte con los datos ingresados?")
                .setPositiveButton("Registrarme",
                        new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                Intent intent = new Intent(CrearCuentaActivity.this,  MainActivity.class);
                                startActivity(intent);

                            }
                        })
                .setNegativeButton("Cancelar",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).show();
    }

    private void mostrarDialogoError() {
        AlertDialog.Builder builder = new AlertDialog.Builder(CrearCuentaActivity.this);

        builder.setTitle("Error")
                .setMessage("Las contraseñas ingresadas no coinciden")
                .setPositiveButton("Aceptar",
                        new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                dialog.dismiss();

                            }
                        }).show();
    }


}