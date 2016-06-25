package com.jcodee.mod2class1.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jcodee.mod2class1.R;
import com.jcodee.mod2class1.models.Usuario;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Author: johannfjs
 * Date: 28/5/16
 * Time: 13:08
 */
public class UsuarioAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Usuario> lista;

    public UsuarioAdapter(Context context, ArrayList<Usuario> lista) {
        this.context = context;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    static class ViewHolder {
        @BindView(R.id.lblNombreCompleto)
        TextView lblNombreCompleto;
        @BindView(R.id.lblCorreo)
        TextView lblCorreo;
        @BindView(R.id.lblUsuario)
        TextView lblUsuario;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) convertView.getTag();
        Usuario usuario = (Usuario) getItem(position);
        viewHolder.lblCorreo.setText(usuario.getCorreo());
        viewHolder.lblNombreCompleto.setText(usuario.getNombreCompleto());
        viewHolder.lblUsuario.setText(usuario.getUsuario());
        return convertView;
    }
}
