package com.jcodee.tema03_1.adapters;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodee.tema03_1.R;
import com.jcodee.tema03_1.modelos.Elemento;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: johannfjs
 * Date: 14/5/16
 * Time: 13:38
 */
public class ElementoAdapter extends ArrayAdapter<Elemento> {
    private Context context;
    private ArrayList<Elemento> lista;

    public ElementoAdapter(Context context, ArrayList<Elemento> objects) {
        super(context, R.layout.item, objects);
        this.context = context;
        this.lista = objects;
    }

    static class ViewHolder {
        TextView lblDescripcion;
        SimpleDraweeView sdvImagen;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.lblDescripcion = (TextView) convertView.findViewById(R.id.lblDescripcion);
            viewHolder.sdvImagen = (SimpleDraweeView) convertView.findViewById(R.id.sdvImagen);
            convertView.setTag(viewHolder);
        }

        viewHolder = (ViewHolder) convertView.getTag();

        Elemento elemento = (Elemento) lista.get(position);

        viewHolder.lblDescripcion.setText(elemento.getDescripcion());
        viewHolder.sdvImagen.setImageURI(Uri.parse(elemento.getRutaImagen()));

        return convertView;
    }
}
