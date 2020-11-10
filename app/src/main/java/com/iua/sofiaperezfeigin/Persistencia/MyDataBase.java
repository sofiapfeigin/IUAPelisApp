package com.iua.sofiaperezfeigin.Persistencia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.iua.sofiaperezfeigin.modelo.Pelicula;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MyDataBase extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "prueba.db";
    //Table Names
    private static final String TABLE_PELICULAS = "peliculas_table";
    //Mail Table Columns
    private static final String KEY_PELICULA_ID = "pelicula_id";
    private static final String KEY_PELICULA_NOMBRE = "pelicula_nombre";
    private static final String KEY_PELICULA_FOTO = "pelicula_foto";
    private static final String KEY_PELICULA_DESCR = "pelicula_descr";



    public MyDataBase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_PELICULA_TABLE = "CREATE TABLE " + TABLE_PELICULAS + "("
                + KEY_PELICULA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_PELICULA_NOMBRE + " TEXT,"
                + KEY_PELICULA_FOTO + " TEXT,"
                + KEY_PELICULA_DESCR + " TEXT)";
        db.execSQL(CREATE_PELICULA_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // SQL para actualizar las tablas
    }
    public void addPelicula(Pelicula pelicula) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_PELICULA_NOMBRE, pelicula.getNombre());
        values.put(KEY_PELICULA_FOTO, pelicula.getFoto());
        values.put(KEY_PELICULA_DESCR, pelicula.getDescr());
        database.insert(TABLE_PELICULAS, null, values);
    }

    public ArrayList<Pelicula> getPeliculas() {
        ArrayList<Pelicula> peliculas = null;
        SQLiteDatabase database = this.getReadableDatabase();
        String[] valores_recuperar = {"pelicula_nombre", "pelicula_foto", "pelicula_descr"};
        Cursor c = database.query(TABLE_PELICULAS, valores_recuperar, null, null, null, null, null, null);
        c.moveToFirst();
            do {

                peliculas.add(new Pelicula(c.getString(1),
                        c.getString(2),
                        c.getString(3)));
            }while (c.moveToNext());
            database.close();
            c.close();


        return peliculas;
    }



}
