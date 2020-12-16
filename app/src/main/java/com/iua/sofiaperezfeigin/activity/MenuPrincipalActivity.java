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

import java.util.concurrent.ExecutionException;

public class MenuPrincipalActivity extends AppCompatActivity
        implements MenuPrincipalFragment.MenuPrincipalFragmentListener, FavoritosFragment.FavoritosFragmentListener,
        EditarUsuarioFragment.EditarUsuarioFragmentListener, EnviarEmailFragment.EnviarEmailFragmentListener,
         CategoriasFragment.CategoriasFragmentListener {

    MenuPrincipalFragment fragmentPrincipal;
    FavoritosFragment fragmentFavoritos;
    EditarUsuarioFragment fragmentEditarUsuario;
    EnviarEmailFragment fragmentEnviarEmail;
    CategoriasFragment fragmentCategorias;
    FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        try {
            fragmentPrincipal=new MenuPrincipalFragment();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        fragmentEditarUsuario=new EditarUsuarioFragment();
        fragmentFavoritos= new FavoritosFragment();
        fragmentEnviarEmail= new EnviarEmailFragment();
        fragmentCategorias= new CategoriasFragment();


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

        findViewById(R.id.categorias).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.contenedorFragment,fragmentCategorias);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });




    }
}