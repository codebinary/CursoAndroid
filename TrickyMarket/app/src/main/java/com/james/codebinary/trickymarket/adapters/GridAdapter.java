package com.james.codebinary.trickymarket.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.james.codebinary.trickymarket.R;
import com.james.codebinary.trickymarket.modelos.Product;

/**
 * Created by codebinary on 12/06/16.
 */
public class GridAdapter extends BaseAdapter {

    private final Context context;
    private final Product[] items;

    public GridAdapter(Context context, Product[] items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.length - 1;
    }

    @Override
    public Object getItem(int position) {
        return items[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.grid_item, parent, false);
        }

        Product item = (Product) getItem(position);

        //Seteando imagen
        ImageView image = (ImageView) convertView.findViewById(R.id.imagen);
        Glide.with(image.getContext()).load(item.getIdThumbail()).into(image);

        //Seteando nombre
        TextView name = (TextView) convertView.findViewById(R.id.nombre);
        name.setText(item.getNombre());

        //Seteando Descripcion
        TextView descripcion = (TextView) convertView.findViewById(R.id.descripcion);
        descripcion.setText(item.getDescripcion());

        //Setenado Precio
        TextView precio = (TextView) convertView.findViewById(R.id.precio);
        precio.setText(item.getPrecio());

        //Seteando rating
        RatingBar ratingBar = (RatingBar) convertView.findViewById(R.id.rating);
        ratingBar.setRating(item.getRating());

        return convertView;
    }
}
