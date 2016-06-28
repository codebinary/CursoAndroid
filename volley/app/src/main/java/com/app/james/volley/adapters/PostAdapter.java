package com.app.james.volley.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.app.james.volley.R;
import com.app.james.volley.models.Post;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by James on 28/06/16.
 */
public class PostAdapter extends ArrayAdapter {

    // Atributos
    private RequestQueue requestQueue;
    JsonObjectRequest jsArrayRequest;

    private static final String URL_BASE = "http://servidorexterno.site90.com/datos";
    private static final String URL_JSON = "/social_media.json";
    private static final String TAG = "PostAdapter";
    List<Post> items;


    public PostAdapter(Context context) {
        super(context, 0);

        //Crear nuevo cola de peticiones
        requestQueue = Volley.newRequestQueue(context);

        //Nuevo peticion JSONObject
        jsArrayRequest = new JsonObjectRequest(
                Request.Method.GET,
                URL_BASE + URL_JSON,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        items = parseJson(response);
                        notifyDataSetChanged();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d(TAG, "Error respuesta json" + error.getMessage());
                    }
                }
        );

        //Añadir petición a la cola
        requestQueue.add(jsArrayRequest);
    }

    @Override
    public int getCount() {
        return items != null ? items.size() : 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        //Referencia del view procesado
        View listItemView;

        //Comprobando si el view no existe
        listItemView = null == convertView ? layoutInflater.inflate(R.layout.post, parent, false) : convertView;

        // Obtener el item actual
        Post item = items.get(position);

        // Obtener Views
        TextView textoTitulo = (TextView) listItemView.
                findViewById(R.id.textoTitulo);
        TextView textoDescripcion = (TextView) listItemView.
                findViewById(R.id.textoDescripcion);
        final ImageView imagenPost = (ImageView) listItemView.
                findViewById(R.id.imagenPost);

        // Actualizar los Views
        textoTitulo.setText(item.getTitulo());
        textoDescripcion.setText(item.getDescripcion());


        // Petición para obtener la imagen
        ImageRequest request = new ImageRequest(
                URL_BASE + item.getImagen(),
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap bitmap) {
                        imagenPost.setImageBitmap(bitmap);
                    }
                }, 0, 0, null,null,
                new Response.ErrorListener() {
                    public void onErrorResponse(VolleyError error) {
                        imagenPost.setImageResource(R.drawable.error);
                        Log.d(TAG, "Error en respuesta Bitmap: "+ error.getMessage());
                    }
                });

        // Añadir petición a la cola
        requestQueue.add(request);

        return listItemView;
    }

    public List<Post> parseJson(JSONObject jsonObject){
        // Variables locales
        List<Post> posts = new ArrayList();
        JSONArray jsonArray= null;

        try {
            // Obtener el array del objeto
            jsonArray = jsonObject.getJSONArray("items");

            for(int i=0; i<jsonArray.length(); i++){

                try {
                    JSONObject objeto= jsonArray.getJSONObject(i);

                    Post post = new Post(
                            objeto.getString("titulo"),
                            objeto.getString("descripcion"),
                            objeto.getString("imagen"));


                    posts.add(post);

                } catch (JSONException e) {
                    Log.e(TAG, "Error de parsing: "+ e.getMessage());
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


        return posts;
    }
}

