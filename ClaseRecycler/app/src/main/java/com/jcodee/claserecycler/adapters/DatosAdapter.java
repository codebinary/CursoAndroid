package com.jcodee.claserecycler.adapters;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodee.claserecycler.R;
import com.jcodee.claserecycler.modelos.Datos;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Author: johannfjs
 * Date: 11/6/16
 * Time: 10:19
 */
public class DatosAdapter extends RecyclerView.Adapter<DatosAdapter.ViewHolderCustom> {
    private ArrayList<Datos> lista;
    private int posicion = 0;

    public DatosAdapter(ArrayList<Datos> lista) {
        this.lista = lista;
    }

    @Override
    public ViewHolderCustom onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        int layout = 0;

        if (posicion % 2 == 0)
            layout = R.layout.item_left;
        else
            layout = R.layout.item_rigth;

        view = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        posicion++;
        return new ViewHolderCustom(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderCustom holder, int position) {
        Datos datos = lista.get(position);
        holder.tvNombre.setText(datos.getNombre());
        holder.tvApellido.setText(datos.getApellido());
        holder.tvCarrera.setText(datos.getCarrera());
        holder.sdvImagen.setImageURI(Uri.parse(datos.getRutaImagen()));
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class ViewHolderCustom extends RecyclerView.ViewHolder {
        @BindView(R.id.sdvImagen)
        SimpleDraweeView sdvImagen;
        @BindView(R.id.tvNombre)
        TextView tvNombre;
        @BindView(R.id.tvApellido)
        TextView tvApellido;
        @BindView(R.id.tvCarrera)
        TextView tvCarrera;

        public ViewHolderCustom(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
