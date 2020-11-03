package com.iua.sofiaperezfeigin;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.iua.sofiaperezfeigin.modelo.Categoria;

import java.util.ArrayList;
import java.util.List;

public class ListAdapterCategoria extends RecyclerView.Adapter<ListAdapterCategoria.PalleteViewHolder> {

    private List<Categoria> data;
    private Context context;

    public ListAdapterCategoria(@NonNull ArrayList<Categoria> data, Context context) {
        this.data = data;
        this.context=context;
    }

    @NonNull
    @Override
    public PalleteViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View row = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_categorias_view, viewGroup, false);
        return new PalleteViewHolder(row);

    }

    @Override
    public void onBindViewHolder(@NonNull PalleteViewHolder palleteViewHolder, int i) {
        Categoria categoria = data.get(i);
        palleteViewHolder.getTitleTextView().setText(categoria.getNombreCateg());

        //Glide.with(context).
              //  load(pelicula.getFoto()).
              //  fitCenter().into(palleteViewHolder.getImageView());


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class PalleteViewHolder extends RecyclerView.ViewHolder {

        //private ImageView imageView;
        private TextView titleTextView;

        public PalleteViewHolder(View itemView) {
            super(itemView);
            //imageView = itemView.findViewById(R.id.fotoPelicula);
            titleTextView = (TextView) itemView.findViewById(R.id.titleTextView);
        }

        public TextView getTitleTextView() {
            return titleTextView;
        }

        //public ImageView getImageView() {
            //return imageView;
        //}
    }
}
