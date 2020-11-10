package com.iua.sofiaperezfeigin.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.iua.sofiaperezfeigin.R;
import com.iua.sofiaperezfeigin.fragments.CategoriasFragment;
import com.iua.sofiaperezfeigin.fragments.DetallePeliculaFragment;
import com.iua.sofiaperezfeigin.fragments.EditarUsuarioFragment;
import com.iua.sofiaperezfeigin.fragments.EnviarEmailFragment;
import com.iua.sofiaperezfeigin.fragments.FavoritosFragment;
import com.iua.sofiaperezfeigin.fragments.MenuPrincipalFragment;

public class MenuPrincipalActivity extends AppCompatActivity
        implements MenuPrincipalFragment.MenuPrincipalFragmentListener, FavoritosFragment.FavoritosFragmentListener,
        EditarUsuarioFragment.EditarUsuarioFragmentListener, EnviarEmailFragment.EnviarEmailFragmentListener,
        DetallePeliculaFragment.DetallePeliculaFragmentListener, CategoriasFragment.CategoriasFragmentListener {

    MenuPrincipalFragment fragmentPrincipal;
    FavoritosFragment fragmentFavoritos;
    EditarUsuarioFragment fragmentEditarUsuario;
    EnviarEmailFragment fragmentEnviarEmail;
    DetallePeliculaFragment fragmentDetallePelicula;
    CategoriasFragment fragmentCategorias;
    FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        fragmentPrincipal=new MenuPrincipalFragment();
        fragmentEditarUsuario=new EditarUsuarioFragment();
        fragmentPrincipal=new MenuPrincipalFragment();
        fragmentFavoritos= new FavoritosFragment();
        fragmentEnviarEmail= new EnviarEmailFragment();
        fragmentDetallePelicula= new DetallePeliculaFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.contenedorFragment, fragmentPrincipal).commit();
        transaction = getSupportFragmentManager().beginTransaction();
        findViewById(R.id.editarUsuario).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.contenedorFragment,fragmentEditarUsuario);
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });

        findViewById(R.id.home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.contenedorFragment, fragmentPrincipal);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        findViewById(R.id.fav).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.contenedorFragment,fragmentFavoritos);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        findViewById(R.id.email).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.contenedorFragment,fragmentEnviarEmail);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        findViewById(R.id.email).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.contenedorFragment,fragmentEnviarEmail);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });


    }
}