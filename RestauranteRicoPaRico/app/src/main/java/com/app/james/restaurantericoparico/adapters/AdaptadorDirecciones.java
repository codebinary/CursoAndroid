package com.app.james.restaurantericoparico.adapters;

/**
 * Created by codebinary on 13/06/16.
 */

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.james.restaurantericoparico.R;

/**
 * Adaptador para poblar la lista de direcciones de la sección "Mi Cuenta"
 */
public class AdaptadorDirecciones extends RecyclerView.Adapter<AdaptadorDirecciones.ViewHolder> {

    @Override
    public AdaptadorDirecciones.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return null;
    }

    @Override
    public void onBindViewHolder(AdaptadorDirecciones.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView direccion;
        public TextView departamento;
        public TextView ciudad;
        public TextView telefono;

        public ViewHolder(View itemView) {
            super(itemView);

            direccion = (TextView) itemView.findViewById(R.id.texto_direccion);
            departamento = (TextView) itemView.findViewById(R.id.texto_departamento);
        }

    }
}
