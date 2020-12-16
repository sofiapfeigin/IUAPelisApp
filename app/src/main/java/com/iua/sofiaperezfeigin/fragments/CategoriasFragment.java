package com.iua.sofiaperezfeigin.fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.iua.sofiaperezfeigin.ListAdapter;
import com.iua.sofiaperezfeigin.Persistencia.MyDataBase;
import com.iua.sofiaperezfeigin.R;
import com.iua.sofiaperezfeigin.modelo.Pelicula;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MenuPrincipalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CategoriasFragment extends Fragment implements DetallePeliculaFragment.DetallePeliculaFragmentListener {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView recyclerView;
    ArrayList<Pelicula> pelicula = new ArrayList<>();
    MyDataBase db;
    ImageView cat;
    TextView titulo;

    String eleccion="ACCION";
    private String[] categorias;


    public CategoriasFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MenuPrincipalFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CategoriasFragment newInstance(String param1, String param2) {
        CategoriasFragment fragment = new CategoriasFragment();
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
        // Inflate the layout for this fragment

        View vista = inflater.inflate(R.layout.fragment_categorias, container, false);

        pelicula = new ArrayList<>();
        recyclerView = vista.findViewById(R.id.recyclerViewCat);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        categorias = getResources().getStringArray(R.array.categorias);
        cat = vista.findViewById(R.id.imageView4);
        titulo = vista.findViewById(R.id.titulo);

        titulo.setText(eleccion);
        db = new MyDataBase(getContext());

        pelicula = db.getPeliculasCat(eleccion);
        recyclerView.setAdapter(new ListAdapter(pelicula, getContext()));

        cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());


                builder.setTitle("Categorias");
                builder.setItems(R.array.categorias, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        eleccion = categorias[i];
                        pelicula = db.getPeliculasCat(eleccion);
                        recyclerView.setAdapter(new ListAdapter(pelicula, getContext()));
                        titulo.setText(eleccion);

                    }
                });

                Dialog dialog=builder.create();
                dialog.show();


            }
        });

        return vista;
    }


    public interface CategoriasFragmentListener {
    }

}