package com.jcodee.tema4_3.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jcodee.tema4_3.R;
import com.jcodee.tema4_3.modelos.Contacto;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Author: johannfjs
 * Date: 21/5/16
 * Time: 13:46
 */
public class ContactoAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Contacto> lista;

    public ContactoAdapter(Context context, ArrayList<Contacto> lista) {
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
        @BindView(R.id.lblNombre)
        TextView lblNombre;

        @BindView(R.id.lblApellido)
        TextView lblApellido;

        @BindView(R.id.btnCelular)
        Button btnCelular;

        @BindView(R.id.btnTelCasa)
        Button btnTelCasa;

        @BindView(R.id.llContenedor)
        LinearLayout llContenedor;

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

            Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/PTN57F.ttf");
            viewHolder.lblNombre.setTypeface(typeface);

            typeface = Typeface.createFromAsset(context.getAssets(), "fonts/waltographUI.ttf");
            viewHolder.lblApellido.setTypeface(typeface);

            convertView.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) convertView.getTag();

        final Contacto contacto = (Contacto) getItem(position);
        viewHolder.lblNombre.setText(contacto.getNombre());
        viewHolder.lblApellido.setText(contacto.getApellido());
        viewHolder.llContenedor.setBackgroundColor(contacto.getColor());

        viewHolder.btnCelular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + contacto.getCelular()));
                context.startActivity(intent);
            }
        });

        viewHolder.btnTelCasa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + contacto.getTelefono()));
                context.startActivity(intent);
            }
        });

        return convertView;
    }
}
