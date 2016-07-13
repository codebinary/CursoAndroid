package com.james.codebinary.appcato.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.james.codebinary.appcato.R;
import com.james.codebinary.appcato.models.Pelicula;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by James on 01/07/16.
 */
public class PaisDetalleListaAdapter extends RecyclerView.Adapter<PaisDetalleListaAdapter.ViewHolder> {

    private Context context;
    private List<Pelicula> listaPeliculas;

    public PaisDetalleListaAdapter(Context context, List<Pelicula> listaPeliculas) {
        this.context = context;
        this.listaPeliculas = listaPeliculas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fragmento_list_detalle_pais, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.pais_detalle_lista.setText(listaPeliculas.get(position).getPelicula_titulo());

    }

    @Override
    public int getItemCount() {
        return listaPeliculas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.pais_detalle_lista)
        TextView pais_detalle_lista;

        public ViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }
}
