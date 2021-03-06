package com.iua.sofiaperezfeigin;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.iua.sofiaperezfeigin.fragments.DetallePeliculaFragment;
import com.iua.sofiaperezfeigin.modelo.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.PalleteViewHolder> {

    private List<Pelicula> data;
    private Context context;

    public ListAdapter(@NonNull ArrayList<Pelicula> data, Context context) {
        this.data = data;
        this.context=context;
    }

    @NonNull
    @Override
    public PalleteViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View row = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_peliculas_view, viewGroup, false);
        return new PalleteViewHolder(row);

    }

    @Override
    public void onBindViewHolder(@NonNull PalleteViewHolder palleteViewHolder,final int i) {
        Pelicula pelicula = data.get(i);
        palleteViewHolder.getTitleTextView().setText(pelicula.getNombre());

        Glide.with(context).
                load(pelicula.getFoto()).
                fitCenter().into(palleteViewHolder.getImageView());

        palleteViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                DetallePeliculaFragment detailFragment = new DetallePeliculaFragment();
                detailFragment.putExtra(data.get(i));
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.contenedorFragment,detailFragment).addToBackStack(null).commit();
            }
        });


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class PalleteViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView titleTextView;

        public PalleteViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.fotoPelicula);
            titleTextView = (TextView) itemView.findViewById(R.id.titleTextView);
              }

        public TextView getTitleTextView() {
            return titleTextView;
        }

        public ImageView getImageView() {
            return imageView;
        }
    }
}
