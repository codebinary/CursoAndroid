package com.james.codebinary.appcato.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.james.codebinary.appcato.R;
import com.james.codebinary.appcato.models.Pais;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by James on 30/06/16.
 */
public class PaisAdapters extends RecyclerView.Adapter<PaisAdapters.ViewHolder> {

    private Context context;
    private List<Pais> listaPaises;

    public PaisAdapters(Context context, List<Pais> listaPaises) {
        this.context = context;
        this.listaPaises = listaPaises;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fragmento_paises, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.pais_nombre.setText(listaPaises.get(position).getPais_nombre());

    }

    @Override
    public int getItemCount() {
        return listaPaises.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.pais_nombre)
        TextView pais_nombre;

        public ViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }
}
