package com.iua.sofiaperezfeigin.fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.iua.sofiaperezfeigin.R;
import com.iua.sofiaperezfeigin.activity.MenuPrincipalActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EditarUsuarioFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EditarUsuarioFragment extends Fragment {

    SharedPreferences prefs;
    EditText email;
    EditText usuario;
    EditText passwd1;
    EditText passwd2;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public EditarUsuarioFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EditarUsuarioFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EditarUsuarioFragment newInstance(String param1, String param2) {
        EditarUsuarioFragment fragment = new EditarUsuarioFragment();
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
        View vista = inflater.inflate(R.layout.fragment_editar_usuario, container, false);

        email=vista.findViewById(R.id.editTextTextEmailAddress4);
        usuario=vista.findViewById(R.id.editTextUser);
        passwd1=vista.findViewById(R.id.editTextTextPassword);
        passwd2=vista.findViewById(R.id.editTextTextPassword2);

        prefs=this.getActivity().getSharedPreferences("PreferenciasUsuario", Context.MODE_PRIVATE);
        String user = prefs.getString("usuario", "0");
        String contra = prefs.getString("contrasena", "0");
        String email2 = prefs.getString("email", "0");

        email.setText(email2);
        usuario.setText(user);
        passwd1.setText(contra);
        passwd2.setText(contra);

        vista.findViewById(R.id.guardar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(passwd1.getText().toString().equals(passwd2.getText().toString()))
                    mostrarDialogo();
                else
                    mostrarDialogoError();
            }
        });
        return vista;
    }

    private void mostrarDialogo() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        builder.setTitle("Guardar cambios")
                .setMessage("¿Deseas guardar los cambios realizados?")
                .setPositiveButton("Guardar",
                        new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                SharedPreferences.Editor editor = prefs.edit();
                                editor.putString("email", email.getText().toString());
                                editor.putString("usuario", usuario.getText().toString());
                                editor.putString("contrasena", passwd1.getText().toString());

                                editor.commit();

                                Intent intent = new Intent(getContext(),  MenuPrincipalActivity.class);
                                startActivity(intent);
                            }
                        })
                .setNegativeButton("Cancelar",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).show();
    }

    private void mostrarDialogoError() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        builder.setTitle("Error")
                .setMessage("Las contraseñas ingresadas no coinciden")
                .setPositiveButton("Aceptar",
                        new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                dialog.dismiss();

                            }
                        }).show();
    }

    public interface EditarUsuarioFragmentListener {
    }
}