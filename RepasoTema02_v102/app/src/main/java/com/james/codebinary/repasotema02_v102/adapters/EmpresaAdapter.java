package com.james.codebinary.repasotema02_v102.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.james.codebinary.repasotema02_v102.R;
import com.james.codebinary.repasotema02_v102.models.Empresa;

import java.util.ArrayList;

/**
 * Created by codebinary on 23/05/16.
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

    static class viewHolder{


    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        }

        

        return null;
    }
}
