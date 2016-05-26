package com.james.codebinary.repastotema02_v102.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.james.codebinary.repastotema02_v102.R;
import com.james.codebinary.repastotema02_v102.models.Empresa;

import java.util.ArrayList;

/**
 * Created by codebinary on 24/05/16.
 */
public class EmpresaAdapter extends BaseAdapter {

    private Context context;
    public ArrayList<Empresa> lista;

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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //Comprobamos si la vista existe o no
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        }

        //Obtenemos los valores
        TextView empresa = (TextView) convertView.findViewById(R.id.txtEmpresa);
        TextView ruc = (TextView) convertView.findViewById(R.id.txtRuc);
        TextView direccion = (TextView) convertView.findViewById(R.id.txtDireccion);

        //Obtenemos el id del conteneodor de la lista
        LinearLayout contenedor = (LinearLayout) convertView.findViewById(R.id.llContenedor);

        //Obtenemos la posicion de la empresa
        Empresa emp = (Empresa) getItem(position);

        empresa.setText(emp.getNombre());
        empresa.setText(emp.getRuc());
        empresa.setText(emp.getDireccion());

        if(position % 2 == 0){
            contenedor.setBackgroundColor(context.getResources().getColor(R.color.color1));
        }else{
            contenedor.setBackgroundColor(context.getResources().getColor(R.color.color2));
        }


        return convertView;
    }
}
