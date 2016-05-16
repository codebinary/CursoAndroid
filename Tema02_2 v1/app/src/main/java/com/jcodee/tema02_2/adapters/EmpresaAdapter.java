package com.jcodee.tema02_2.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jcodee.tema02_2.R;
import com.jcodee.tema02_2.models.Empresa;

import java.util.ArrayList;

/**
 * Author: johannfjs
 * Date: 7/5/16
 * Time: 12:42
 */
public class EmpresaAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Empresa> lista;

    public EmpresaAdapter(Context context, ArrayList<Empresa> lista) {
        this.context = context;
        this.lista = lista;
    }

    //Es la cantidad de elementos que tendrá nuestra lista
    @Override
    public int getCount() {
        return lista.size();
    }

    //Es el objeto que se obtiene de la lista según la posición
    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    //Es el identificador unico del objeto en la lista según la posición
    @Override
    public long getItemId(int position) {
        return 0;
    }

    //Es la parte visual que se crea
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        }
        TextView empresa = (TextView) convertView.findViewById(R.id.lblEmpresa);
        TextView ruc = (TextView) convertView.findViewById(R.id.lblRUC);
        TextView direccion = (TextView) convertView.findViewById(R.id.lblDireccion);
        LinearLayout contenedor = (LinearLayout) convertView.findViewById(R.id.llContenedor);

        Empresa obj = (Empresa) getItem(position);
        empresa.setText(obj.getEmpresa());
        ruc.setText(obj.getRuc());
        direccion.setText(obj.getDireccion());

        if (position % 2 == 0) {
            contenedor.setBackgroundColor(context.getResources().getColor(R.color.color1));
        } else {
            contenedor.setBackgroundColor(context.getResources().getColor(R.color.color2));
        }

        return convertView;
    }
}
