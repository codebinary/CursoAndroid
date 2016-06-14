package com.app.james.restaurantericoparico.adapters;

/**
 * Created by codebinary on 13/06/16.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.james.restaurantericoparico.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Adaptador para poblar la lista de direcciones de la sección "Mi Cuenta"
 */
public class AdaptadorDirecciones extends RecyclerView.Adapter<AdaptadorDirecciones.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView direccion;
        public TextView departamento;
        public TextView ciudad;
        public TextView telefono;

        public ViewHolder(View itemView) {
            super(itemView);

            direccion = (TextView) itemView.findViewById(R.id.texto_direccion);
            departamento = (TextView) itemView.findViewById(R.id.texto_departamento);
            ciudad = (TextView) itemView.findViewById(R.id.texto_ciudad);
            telefono = (TextView) itemView.findViewById(R.id.texto_telefono);
        }
    }

    public AdaptadorDirecciones(){
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lista_direcciones, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Direccion item = Direccion.DIRECCIONES.get(position);
        holder.direccion.setText(item.numeroDireccion);
        holder.departamento.setText(item.departamento);
        holder.ciudad.setText(item.ciudad);
        holder.telefono.setText(item.telefono);
    }

    @Override
    public int getItemCount() {
        return Direccion.DIRECCIONES.size();
    }

    /**
     * Modelo de datos para probar el adaptador
     * */
    public static class Direccion{
        public String numeroDireccion;
        public String departamento;
        public String ciudad;
        public String telefono;

        public Direccion(String numeroDireccion, String departament, String ciudad, String telefono) {
            this.numeroDireccion = numeroDireccion;
            this.departamento = departament;
            this.ciudad = ciudad;
            this.telefono = telefono;
        }

        public final static List<Direccion> DIRECCIONES = new ArrayList<Direccion>();

        static{
            DIRECCIONES.add(new Direccion("Cra 24 #2C-50", "Valle", "Cali", "3459821"));
            DIRECCIONES.add(new Direccion("Calle 100 Trans. 23", "Valle", "Cali", "4992600"));
            DIRECCIONES.add(new Direccion("Ave. 3ra N. #20-10", "Valle", "Cali", "4400725"));
        }
    }






}
