package com.app.james.mysocialmediapotenciado;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;


public class PostAdapter extends ArrayAdapter {

    // Atributos
    private String URL_BASE = "http://servidorexterno.site90.com/datos";
    private static final String URL_JSON = "/social_media.json";
    private static final String TAG = "PostAdapter";
    ListaPost items;

    public PostAdapter(Context context) {
        super(context,0);

        // Añadir petición GSON a la cola
        MySocialMediaSingleton.getInstance(getContext()).addToRequestQueue(
                new GsonRequest<ListaPost>(
                        URL_BASE+URL_JSON,
                        ListaPost.class,
                        null,
                        new Response.Listener<ListaPost>(){
                            @Override
                            public void onResponse(ListaPost response) {
                                items = response;
                                notifyDataSetChanged();
                            }
                        },
                        new Response.ErrorListener(){
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.d(TAG, "Error Volley:"+ error.getMessage());
                            }
                        }
                )

        );
    }

    @Override
    public int getCount() {
        return items != null ? items.getItems().size() : 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        // View auxiliar
        View listItemView;

        //Comprobando si el View no existe
        if (null == convertView) {
            //Si no existe, entonces inflarlo
            listItemView = layoutInflater.inflate(
                    R.layout.post,
                    parent,
                    false);
        } else listItemView = convertView;


        // Obtener el item actual
        Post item = items.getItems().get(position);

        // Obtener Views
        TextView textoTitulo = (TextView) listItemView.
                findViewById(R.id.textoTitulo);
        TextView textoDescripcion = (TextView) listItemView.
                findViewById(R.id.textoDescripcion);
        NetworkImageView imagenPost = (NetworkImageView) listItemView.
                findViewById(R.id.imagenPost);

        // Actualizar los Views
        textoTitulo.setText(item.getTitulo());
        textoDescripcion.setText(item.getDescripcion());

        // Petición el image loader
        ImageLoader imageLoader= MySocialMediaSingleton.getInstance(getContext()).getImageLoader();
        // Petición
        imagenPost.setImageUrl(URL_BASE +item.getImagen(), imageLoader);

        return listItemView;
    }
}
