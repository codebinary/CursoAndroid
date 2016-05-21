package com.jcodee.tema03.adapters;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodee.tema03.R;
import com.jcodee.tema03.modelos.Elemento;

import java.util.ArrayList;

/**
 * Author: johannfjs
 * Date: 14/5/16
 * Time: 10:13
 */
public class ElementoAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Elemento> lista;

    public ElementoAdapter(Context context, ArrayList<Elemento> lista) {
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
        return lista.get(position).getId();
    }

    static class ViewHolder {
        //Solo declaramos las variables que tengamos en nuestro item
        SimpleDraweeView sdvImagen;
        TextView lblDescripcion;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Declaramos objeto de tipo ViewHolder
        ViewHolder viewHolder = null;
        //Validamos que la vista no esté cargada
        if (convertView == null) {
            //Añadimos la vista
            convertView = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
            //Inicializamos el ViewHolder
            viewHolder = new ViewHolder();
            //Hacemos la referencia de nuestras variables a nuestros componentes
            viewHolder.sdvImagen = (SimpleDraweeView) convertView.findViewById(R.id.sdvImagen);
            viewHolder.lblDescripcion = (TextView) convertView.findViewById(R.id.lblDescripcion);
            //Almacenamos la variable en memoría
            convertView.setTag(viewHolder);
        }
        //Obtenemos la variable de tipo ViewHolder de la memoría
        viewHolder = (ViewHolder) convertView.getTag();

        //Obtenemos el elemento de la lista según la posición
        Elemento elemento = (Elemento) getItem(position);
        //Setteamos los datos de los componentes
        viewHolder.lblDescripcion.setText(elemento.getDescripcion());
        viewHolder.sdvImagen.setImageURI(Uri.parse(elemento.getRutaImagen()));

        //Retornamos el diseño
        return convertView;
    }
}
