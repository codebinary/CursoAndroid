package com.james.codebinary.appcato.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.james.codebinary.appcato.R;
import com.james.codebinary.appcato.models.Novedad;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by James on 28/06/16.
 */
public class NovedadAdapter extends RecyclerView.Adapter<NovedadAdapter.ViewHolder>{

    private Context context;
    private List<Novedad> listaNovedades;


    public NovedadAdapter(Context context, List<Novedad> listaNovedades) {

        this.context = context;
        this.listaNovedades = listaNovedades;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fragmento_novedades, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.novedad_titulo.setText(listaNovedades.get(position).getPost_title());
        holder.novedad_descripcion.setText(listaNovedades.get(position).getPost_excerpt());
        Glide.with(holder.itemView.getContext())
                .load(listaNovedades.get(position).getPost_thumbnail())
                .into(holder.novedad_imagen);

    }

    @Override
    public int getItemCount() {

        return listaNovedades.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.novedad_titulo)
        TextView novedad_titulo;

        @BindView(R.id.novedad_descripcion)
        TextView novedad_descripcion;

        @BindView(R.id.novedad_imagen)
        ImageView novedad_imagen;

        public ViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }
}
