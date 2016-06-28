package com.app.james.consumirapi.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.Image;
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
import com.app.james.consumirapi.R;
import com.app.james.consumirapi.models.Post;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by James on 27/06/16.
 */
public class PostAdapter extends ArrayAdapter {

    //Atributos
    private String URL_BASE = "http://www.festivaldelima.com/2015/api/index.php/novedades";
    private static final String TAG = "PostAdapter";
    List<Post> items;

    //Atributos volley
    private RequestQueue requestQueue;
    JsonObjectRequest jsonObjectRequest;

    public PostAdapter(Context context) {
        super(context,0);

        // Crear nueva cola de peticiones
        requestQueue= Volley.newRequestQueue(context);

        // Nueva petición JSONObject
        jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,

                URL_BASE,
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
                        Log.d(TAG, "Error Respuesta en JSON: " + error.getMessage());

                    }
                }
        );

        // Añadir petición a la cola
        requestQueue.add(jsonObjectRequest);
    }

    @Override
    public int getCount() {
        return items != null ? items.size() : 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        //Salvando la referencia del view de la fial
        View listView = convertView;

        //Comprobando si el view no existe
        listView = null == convertView ? layoutInflater.inflate(R.layout.post, parent, false) : convertView;

        //Obtener el item actual

        Post item = items.get(position);

        //Obtener Views
        TextView textoTitulo = (TextView) listView.findViewById(R.id.textoTitulo);
        TextView textoDescripcion = (TextView) listView.findViewById(R.id.textoDescripcion);
        final ImageView imagePost = (ImageView) listView.findViewById(R.id.imagenPost);

        //Actualizar los views
        textoTitulo.setText(item.getTitulo());
        textoDescripcion.setText(item.getDescripcion());

        //Petición para obtener la imagen
        ImageRequest request = new ImageRequest(
                item.getImagen(),
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap bitmap) {
                        imagePost.setImageBitmap(bitmap);
                    }
                }, 0, 0, null, null,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        imagePost.setImageResource(R.drawable.error);
                        Log.d(TAG, "Error en respuesta Bitmap: " + error.getMessage());
                    }
                }
        );

        //Añadir peticion a la cola
        requestQueue.add(request);

        return listView;
    }

    public List<Post> parseJson(JSONObject jsonObject){
        //Variables locales
        List<Post> posts = new ArrayList<>();
        JSONArray jsonArray = null;
        try {
            //Obtener el array del objeto
            jsonArray = jsonObject.getJSONArray("items");

            for (int i = 0; i < jsonArray.length(); i++){
                try {
                    JSONObject objeto = jsonArray.getJSONObject(i);

                    Post post = new Post(
                            objeto.getString("titulo"),
                            objeto.getString("descripcion"),
                            objeto.getString("imagen"));

                    posts.add(post);

                }catch (JSONException e){
                    Log.e(TAG, "Error de parsing: " + e.getMessage());
                }
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
        return posts;
    }
}
