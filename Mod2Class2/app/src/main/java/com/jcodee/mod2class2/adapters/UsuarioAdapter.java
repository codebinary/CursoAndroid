package com.jcodee.mod2class2.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jcodee.mod2class2.R;
import com.jcodee.mod2class2.modelos.Usuario;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.RealmResults;

/**
 * Author: johannfjs
 * Date: 4/6/16
 * Time: 11:45
 */
public class UsuarioAdapter extends BaseAdapter {
    private Context context;
    private RealmResults<Usuario> lista;

    public UsuarioAdapter(Context context, RealmResults<Usuario> lista) {
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
        @BindView(R.id.lblCorreo)
        TextView lblCorreo;
        @BindView(R.id.lblNombre)
        TextView lblNombre;
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
        viewHolder.lblNombre.setText(usuario.getNombre());
        viewHolder.lblUsuario.setText(usuario.getUsuario());

        return convertView;
    }
}
