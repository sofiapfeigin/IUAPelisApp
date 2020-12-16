package com.iua.sofiaperezfeigin.fragments;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.iua.sofiaperezfeigin.Persistencia.MyDataBase;
import com.iua.sofiaperezfeigin.R;
import com.iua.sofiaperezfeigin.modelo.Pelicula;

import java.io.File;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetallePeliculaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetallePeliculaFragment extends Fragment {

    ImageView imageMovie;
    TextView textView;
    ImageButton favorito;
    ImageButton compartir;
    Pelicula pelicula;
    Intent comp;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    MyDataBase db;

    public DetallePeliculaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetallePeliculaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetallePeliculaFragment newInstance(String param1, String param2) {
        DetallePeliculaFragment fragment = new DetallePeliculaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View vista = inflater.inflate(R.layout.fragment_detalle_pelicula, container, false);

        imageMovie = vista.findViewById(R.id.fotoPelicula);
        textView = vista.findViewById(R.id.descripcion);
        favorito = vista.findViewById(R.id.fav);
        compartir = vista.findViewById(R.id.compartir);

        db = new MyDataBase(getContext());

        favorito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (pelicula.getFav().equals("false")) {
                    pelicula.setFav("true");
                    db.setPelicula("true", pelicula.getNombre());
                    favorito.setColorFilter(Color.parseColor("#D69C09"));

                } else {
                    pelicula.setFav("false");
                    db.setPelicula("false", pelicula.getNombre());
                    favorito.setColorFilter(Color.parseColor("#D60909"));
                }
            }
        });

        compartir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                comp = new Intent(android.content.Intent.ACTION_SEND);
                comp.setType("text/plain");
                String mensaje = "ENCONTRA LAS MEJORES PELICULAS EN MOVIE DB - https://www.themoviedb.org/";
                comp.putExtra(android.content.Intent.EXTRA_SUBJECT, "Wikipelis");
                comp.putExtra(android.content.Intent.EXTRA_TEXT, mensaje);
                startActivity(Intent.createChooser(comp, "Compartir vía"));

            }
        });


        initValues();
        return vista;
    }

    private void initValues() {

        textView.setText(pelicula.getDescr());
        Glide.with(getContext()).
                load(pelicula.getFoto()).
                fitCenter().into(imageMovie);


        if (pelicula.getFav().equals("false"))
            favorito.setColorFilter(Color.parseColor("#D60909"));
        else
            favorito.setColorFilter(Color.parseColor("#D69C09"));


    }

    public void putExtra(Pelicula peli) {
        this.pelicula = peli;
    }

    public interface DetallePeliculaFragmentListener {
    }
}