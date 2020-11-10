package com.iua.sofiaperezfeigin.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
public class MenuPrincipalFragment extends Fragment {

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


    public MenuPrincipalFragment() {
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
    public static MenuPrincipalFragment newInstance(String param1, String param2) {
        MenuPrincipalFragment fragment = new MenuPrincipalFragment();
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
        View vista = inflater.inflate(R.layout.fragment_menu_principal, container, false);
        pelicula=new ArrayList<>();
        recyclerView= vista.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        db=new MyDataBase(getContext());

        cargarPeliculas();
        pelicula=db.getPeliculas();


        recyclerView.setAdapter(new ListAdapter(pelicula, getContext()));

        return vista;
    }

    private void cargarPeliculas () {

        db.addPelicula(new Pelicula("Los Vengadores", "https://http2.mlstatic.com/posters-cine-avengers-endgame-marvel-peliculas-45x30-cm-D_NQ_NP_634696-MLA30089346405_042019-F.jpg", "hola"));
        db.addPelicula(new Pelicula("Cisne Negro", "https://hips.hearstapps.com/es.h-cdn.co/fotoes/images/media/imagenes/reportajes/los-20-posters-de-peliculas-mas-creativos/cisne-negro/7055592-1-esl-ES/CISNE-NEGRO.jpg?resize=480:*",getString(R.string.descripcionCisne)));
        db.addPelicula(new Pelicula("Alien", "https://i.pinimg.com/originals/fd/82/c1/fd82c1116eb734b625552241e00e2a20.png",getString(R.string.descripcionAlien)));
        db.addPelicula(new Pelicula("Robin Hood", "https://i.blogs.es/873d60/espinof-peores-posters-de-cine-2018-robin-hood/450_1000.jpg", getString(R.string.descripcionRobin)));
        db.addPelicula(new Pelicula("Capitana Marvel", "https://i.pinimg.com/236x/0f/7f/68/0f7f68e4f067a45fa438290726c75c15.jpg",getString(R.string.descripcionCapitana) ));
        db.addPelicula(new Pelicula("1917", "https://www.mundopeliculas.tv/wp-content/uploads/2020/01/Poster-1917.jpg", getString(R.string.descripcion1917)));
        db.addPelicula(new Pelicula("El Guason", "https://cdn.shopify.com/s/files/1/0265/2769/4934/products/joker-2019-poster-4_195x195@2x.jpg?v=1570682268", getString(R.string.descripcionGuason)));
    }

    public interface MenuPrincipalFragmentListener {
    }


}