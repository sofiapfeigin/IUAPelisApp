package com.iua.sofiaperezfeigin.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iua.sofiaperezfeigin.ClassConnection;
import com.iua.sofiaperezfeigin.ListAdapter;
import com.iua.sofiaperezfeigin.Persistencia.MyDataBase;
import com.iua.sofiaperezfeigin.R;
import com.iua.sofiaperezfeigin.modelo.Pelicula;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MenuPrincipalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MenuPrincipalFragment extends Fragment implements DetallePeliculaFragment.DetallePeliculaFragmentListener {


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

    JSONObject jsonObject;
    JSONArray jsonArray;
    String titulo, descripcion, path;
    String uribase = "https://image.tmdb.org/t/p/original";
    String uriCompleta;
    ClassConnection connection = new ClassConnection();
    String response=connection.execute("https://api.themoviedb.org/3/discover/movie?api_key=51627c98c07cad465df4ee480dfaf95e").get();


    public MenuPrincipalFragment() throws ExecutionException, InterruptedException {
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
    public static MenuPrincipalFragment newInstance(String param1, String param2) throws ExecutionException, InterruptedException {
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

        try {
            jsonObject = new JSONObject(response);
            jsonArray = jsonObject.getJSONArray("results");

        } catch (JSONException e) {
            e.printStackTrace();

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



        try {
            llenarlista();
        } catch (JSONException e) {
            e.printStackTrace();
        }


        pelicula=db.getPeliculas();
        recyclerView.setAdapter(new ListAdapter(pelicula, getContext()));

        return vista;
    }

    private void llenarlista() throws JSONException {

        for (int i=0;i<20;i++)
        {
            titulo = jsonArray.getJSONObject(i).getString("title");
            descripcion = jsonArray.getJSONObject(i).getString("overview");
            path = jsonArray.getJSONObject(i).getString("poster_path");
            uriCompleta = uribase + path;

            if(db.getPelicula(titulo)==false){
                if(i>=0&&i<10)
                    db.addPelicula(new Pelicula(titulo, uriCompleta, descripcion, "false", "ACCION"));
                if(i>=10&&i<15)
                    db.addPelicula(new Pelicula(titulo, uriCompleta, descripcion, "true", "DRAMA"));
                if(i>=15&&i<21)
                    db.addPelicula(new Pelicula(titulo, uriCompleta, descripcion, "false", "SUSPENSO"));

            }

        }


    }

    public interface MenuPrincipalFragmentListener {
    }




}