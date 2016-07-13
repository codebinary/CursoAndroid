package com.james.codebinary.appcato.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.james.codebinary.appcato.R;
import com.james.codebinary.appcato.models.Secciones;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by codebinary on 12/07/16.
 */
public class ProgramacionAdapter extends RecyclerView.Adapter<ProgramacionAdapter.ViewHolder> {

    private Context context;
    private List<Secciones> listaSecciones;

    public ProgramacionAdapter(Context context, List<Secciones> listaSecciones) {
        this.context = context;
        this.listaSecciones = listaSecciones;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fragmento_programacion, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProgramacionAdapter.ViewHolder holder, int position) {

        holder.sec_name.setText(listaSecciones.get(position).getSec_name());

    }

    @Override
    public int getItemCount() {
        return listaSecciones.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.sec_name)
        TextView sec_name;

        public ViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }
}
