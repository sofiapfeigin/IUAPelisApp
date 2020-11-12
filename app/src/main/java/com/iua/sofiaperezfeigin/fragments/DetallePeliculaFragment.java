package com.iua.sofiaperezfeigin.fragments;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.iua.sofiaperezfeigin.R;
import com.iua.sofiaperezfeigin.modelo.Pelicula;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetallePeliculaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetallePeliculaFragment extends Fragment {

    ImageView imageMovie;
    TextView textView;
    Pelicula pelicula;
    

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

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
        View vista = inflater.inflate(R.layout.fragment_detalle_pelicula, container, false);

        imageMovie = vista.findViewById(R.id.fotoPelicula);
        textView = vista.findViewById(R.id.descripcion);
        
        initValues();
        return vista;
    }

    private void initValues() {
        //imageMovie.setImageURI(Uri.parse(pelicula.getFoto()));

        textView.setText(pelicula.getDescr());
        Glide.with(getContext()).
                load(pelicula.getFoto()).
                fitCenter().into(imageMovie);




    }
    public void putExtra(Pelicula peli) {
        this.pelicula = peli;
    }

    public interface DetallePeliculaFragmentListener {
    }
}