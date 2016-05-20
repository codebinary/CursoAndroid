package com.james.codebinary.repasotema02_2v1.adapters;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.james.codebinary.repasotema02_2v1.R;
import com.james.codebinary.repasotema02_2v1.models.Empresa;

import java.util.ArrayList;

/**
 * Created by codebinary on 18/05/16.
 */
public class EmpresaAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Empresa> lista;

    public EmpresaAdapter(Context context, ArrayList<Empresa> lista) {
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


    //Esta es la parte visual que se crea
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        }

        TextView empresa = (TextView) convertView.findViewById(R.id.lblEmpresa);
        TextView ruc = (TextView) convertView.findViewById(R.id.lblRuc);
        TextView direccion = (TextView) convertView.findViewById(R.id.lblDireccion);

        LinearLayout contenedor = (LinearLayout) convertView.findViewById(R.id.llContenedor);

        Empresa obj = (Empresa) getItem(position);
        empresa.setText(obj.getEmpresa());
        ruc.setText(obj.getRuc());
        direccion.setText(obj.getDireccion());

        if(position % 2 == 0){
            contenedor.setBackgroundColor(contenedor.getResources().getColor(R.color.color1));
        }else{
            contenedor.setBackgroundColor(contenedor.getResources().getColor(R.color.color2));
        }

        return convertView;
    }
}
