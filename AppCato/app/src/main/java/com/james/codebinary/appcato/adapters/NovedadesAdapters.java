package com.james.codebinary.appcato.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.james.codebinary.appcato.R;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by James on 28/06/16.
 */
public class NovedadesAdapters extends RecyclerView.Adapter<NovedadesAdapters.ViewHolderCustom>{


    @Override
    public NovedadesAdapters.ViewHolderCustom onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(NovedadesAdapters.ViewHolderCustom holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolderCustom extends RecyclerView.ViewHolder {

        @BindView(R.id.imagenNovedad)
        SimpleDraweeView imagenNovedad;
        @BindView(R.id.novedad_titulo)
        TextView novedadTitulo;
        @BindView(R.id.novedad_descripcion)
        TextView novedadDescripcion;

        public ViewHolderCustom(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
