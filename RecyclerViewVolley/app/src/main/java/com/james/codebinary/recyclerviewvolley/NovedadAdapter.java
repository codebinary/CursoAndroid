package com.james.codebinary.recyclerviewvolley;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by codebinary on 29/06/16.
 */
public class NovedadAdapter extends RecyclerView.Adapter<NovedadAdapter.MyViewHolder> {

    private Context context;
    private List<Novedad> novedades;

    public NovedadAdapter(Context context, List<Novedad> novedades) {
        this.context = context;
        this.novedades = novedades;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
         View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.novedad_titulo.setText(novedades.get(position).getPost_title());
        holder.novedad_descripcion.setText(novedades.get(position).getPost_excerpt());
        holder.novedad_fecha.setText(novedades.get(position).getPost_date());
        Glide.with(context).load(novedades.get(position).getPost_thumbnail()).into(holder.novedad_imagen);

    }

    @Override
    public int getItemCount() {
        return novedades.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.novedad_imagen)
        ImageView novedad_imagen;

        @BindView(R.id.novedad_titulo)
        TextView novedad_titulo;

        @BindView(R.id.novedad_descripcion)
        TextView novedad_descripcion;

        @BindView(R.id.novedad_fecha)
        TextView novedad_fecha;

        public MyViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }
}
