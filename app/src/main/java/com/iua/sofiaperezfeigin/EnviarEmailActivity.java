package com.iua.sofiaperezfeigin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EnviarEmailActivity extends AppCompatActivity {

    Button button;
    EditText mensaje;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enviar_email);

        mensaje=findViewById(R.id.mensaje);
        button= findViewById(R.id.enviarEmail);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enviarcorreo = "sofiapfeigin@gmail.com";
                String enviarasunto = "Reportar un problema";
                String enviarmensaje = mensaje.getText().toString();

                // Defino mi Intent y hago uso del objeto ACTION_SEND
                Intent intent = new Intent(Intent.ACTION_SEND);

                // Defino los Strings Email, Asunto y Mensaje con la función putExtra
                intent.putExtra(Intent.EXTRA_EMAIL,
                        new String[] { enviarcorreo });
                intent.putExtra(Intent.EXTRA_SUBJECT, enviarasunto);
                intent.putExtra(Intent.EXTRA_TEXT, enviarmensaje);

                // Establezco el tipo de Intent
                intent.setType("message/rfc822");

                // Lanzo el selector de cliente de Correo
                startActivity(Intent.createChooser(intent, "Elije un cliente de Correo:"));

            }
        });

    }

    public void menuPrincipal(View view){
        Intent intent = new Intent(EnviarEmailActivity.this,  MenuPrincipalActivity.class);
        startActivity(intent);
    }

    public void favoritos(View view){
        Intent intent = new Intent(EnviarEmailActivity.this,  FavoritosActivity.class);
        startActivity(intent);
    }

    public void editarUsuario(View view){
        Intent intent = new Intent(EnviarEmailActivity.this,  EditarUsuarioActivity.class);
        startActivity(intent);
    }
    public void categorias(View view){
        Intent intent = new Intent(EnviarEmailActivity.this,  CategoriasActivity.class);
        startActivity(intent);
    }
}