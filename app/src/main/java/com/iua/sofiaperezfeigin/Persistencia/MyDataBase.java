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
    private static MyDataBase databaseInstance;

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Wikipelis.db";
    //Table Names
    private static final String TABLE_PELICULAS = "peliculas";
    //Mail Table Columns
    private static final String KEY_PELICULA_ID = "pelicula_id";
    private static final String KEY_PELICULA_NOMBRE = "pelicula_nombre";
    private static final String KEY_PELICULA_FOTO = "pelicula_foto";
    private static final String KEY_PELICULA_DESCR = "pelicula_descr";
    private static final String KEY_PELICULA_FAV = "pelicula_fav";
    private static final String KEY_PELICULA_CAT = "pelicula_cat";


    public static synchronized MyDataBase getInstance(Context context) {
        if (databaseInstance == null) {
            databaseInstance = new MyDataBase(context);
        }
        return databaseInstance;
    }



    public MyDataBase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_PELICULA_TABLE = "CREATE TABLE " + TABLE_PELICULAS + "("
                + KEY_PELICULA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_PELICULA_NOMBRE + " TEXT,"
                + KEY_PELICULA_FOTO + " TEXT,"
                + KEY_PELICULA_DESCR + " TEXT,"
                + KEY_PELICULA_FAV + " TEXT,"
                + KEY_PELICULA_CAT + " TEXT)";
        System.out.println(CREATE_PELICULA_TABLE);
        db.execSQL(CREATE_PELICULA_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PELICULAS);
        onCreate(db);
    }
    public void addPelicula(Pelicula pelicula) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_PELICULA_NOMBRE, pelicula.getNombre());
        values.put(KEY_PELICULA_FOTO, pelicula.getFoto());
        values.put(KEY_PELICULA_DESCR, pelicula.getDescr());
        values.put(KEY_PELICULA_FAV, pelicula.getFav());
        values.put(KEY_PELICULA_CAT, pelicula.getCat());
        database.insert(TABLE_PELICULAS, null, values);
    }

    public ArrayList<Pelicula> getPeliculas() {
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        SQLiteDatabase database = this.getReadableDatabase();
        String[] valores_recuperar = {KEY_PELICULA_NOMBRE, KEY_PELICULA_FOTO, KEY_PELICULA_DESCR, KEY_PELICULA_FAV, KEY_PELICULA_CAT};
        Cursor c = database.query(TABLE_PELICULAS, valores_recuperar, null, null, null, null, null, null);
        c.moveToFirst();
        do {

                peliculas.add(new Pelicula(c.getString(0),
                        c.getString(1),
                        c.getString(2),
                        c.getString(3),
                        c.getString(4)));
            }while (c.moveToNext());
            database.close();
            c.close();

        return peliculas;
    }

    public ArrayList<Pelicula> getPeliculasCat(String cat) {
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        SQLiteDatabase database = this.getReadableDatabase();
        String[] valores_recuperar = {KEY_PELICULA_NOMBRE, KEY_PELICULA_FOTO, KEY_PELICULA_DESCR, KEY_PELICULA_FAV, KEY_PELICULA_CAT};
        String[] selectionArgs = new String[]{ cat};
        Cursor c = database.query(TABLE_PELICULAS, valores_recuperar, KEY_PELICULA_CAT+"=?", selectionArgs, null, null, null, null);
        c.moveToFirst();
        do {

            peliculas.add(new Pelicula(c.getString(0),
                    c.getString(1),
                    c.getString(2),
                    c.getString(3),
                    c.getString(4)));
        }while (c.moveToNext());
        database.close();
        c.close();

        return peliculas;
    }

    public boolean getPelicula(String titulo) {
        SQLiteDatabase database = this.getReadableDatabase();
        String[] valores_recuperar = {KEY_PELICULA_NOMBRE, KEY_PELICULA_FOTO, KEY_PELICULA_DESCR};
        String[] selectionArgs = new String[]{ titulo};
        Cursor c = database.query(TABLE_PELICULAS, valores_recuperar, KEY_PELICULA_NOMBRE+"=?", selectionArgs, null, null, null, null);

        if(c.moveToFirst()==false)
            return false;
        else
            return true;
    }

    public void setPelicula(String fav, String titulo) {

        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues valoresParaActualizar = new ContentValues();
        valoresParaActualizar.put(KEY_PELICULA_FAV, fav);
        String campoParaActualizar = KEY_PELICULA_NOMBRE+" = ?";
        String[] argumentosParaActualizar = {titulo};
        database.update(TABLE_PELICULAS, valoresParaActualizar, campoParaActualizar, argumentosParaActualizar);

    }


    public ArrayList<Pelicula> getPeliculasFav() {
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        SQLiteDatabase database = this.getReadableDatabase();
        String[] valores_recuperar = {KEY_PELICULA_NOMBRE, KEY_PELICULA_FOTO, KEY_PELICULA_DESCR, KEY_PELICULA_FAV, KEY_PELICULA_CAT};
        String[] selectionArgs = new String[]{ "true"};
        Cursor c = database.query(TABLE_PELICULAS, valores_recuperar, KEY_PELICULA_FAV+"=?", selectionArgs, null, null, null, null);

        if(c.moveToFirst()!=false)
        {
            c.moveToFirst();
            do {

                peliculas.add(new Pelicula(c.getString(0),
                        c.getString(1),
                        c.getString(2),
                        c.getString(3),
                        c.getString(4)));
            }while (c.moveToNext());
            database.close();
            c.close();

            return peliculas;
        }
       return null;

    }



}
