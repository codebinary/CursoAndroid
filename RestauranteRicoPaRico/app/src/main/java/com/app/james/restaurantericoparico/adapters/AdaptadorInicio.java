package com.app.james.restaurantericoparico.adapters;

/**
 * Created by James on 13/06/16.
 */


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.james.restaurantericoparico.R;
import com.app.james.restaurantericoparico.models.Comida;
import com.bumptech.glide.Glide;

/**
 * Adaptador para mostrar las comidas más pedidas en la sección "Inicio"
 */
public class AdaptadorInicio extends RecyclerView.Adapter<AdaptadorInicio.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder{

        //Campos respectivos de un item
        public TextView nombre;
        public TextView precio;
        public ImageView imagen;

        public ViewHolder(View itemView) {
            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.nombre_comida);
            precio = (TextView) itemView.findViewById(R.id.precio_comida);
            imagen = (ImageView) itemView.findViewById(R.id.miniatura_comida);
        }
    }

    //Contructor defecto
    public AdaptadorInicio(){

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista_incio, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Comida item = Comida.COMIDAS_POPULARES.get(position);

        Glide.with(holder.itemView.getContext()).load(item.getIdDrawable()).centerCrop().into(holder.imagen);

        holder.nombre.setText(item.getNombre());
        holder.precio.setText("$" + item.getPrecio());
    }


    @Override
    public int getItemCount() {
        return Comida.COMIDAS_POPULARES.size();
    }
}
