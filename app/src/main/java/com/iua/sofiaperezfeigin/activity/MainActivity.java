package com.iua.sofiaperezfeigin.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;

import com.iua.sofiaperezfeigin.R;


public class MainActivity extends AppCompatActivity {

    NotificationCompat.Builder mBuilder;
    int notificationId=1232425;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBuilder= new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.w)
                .setContentTitle("Wikipelis")
                .setContentText("Mira la nueva pelicula que tenemos para vos!!! No te la pierdas");

        Intent resultIntent=new Intent(this, MainActivity.class);
        PendingIntent resultPendingIntent=PendingIntent.getActivity(this, 0, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager notifyMgr= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notifyMgr.notify(notificationId,mBuilder.build());


        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            // Si hay conexión a Internet en este momento
        } else {
            mostrarDialogo();
        }
    }

    private void mostrarDialogo() {

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        builder.setTitle("Conexion a internet")
                .setMessage("No es posible conectarse a la red")
                .setPositiveButton("Aceptar",
                        new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                Intent intent = new Intent(MainActivity.this,  MainActivity.class);
                                startActivity(intent);

                            }
                        }).show();
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