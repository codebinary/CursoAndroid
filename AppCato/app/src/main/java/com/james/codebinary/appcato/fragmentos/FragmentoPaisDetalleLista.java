package com.james.codebinary.appcato.fragmentos;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.james.codebinary.appcato.R;
import com.james.codebinary.appcato.adapters.PaisAdapters;
import com.james.codebinary.appcato.adapters.PaisDetalleListaAdapters;
import com.james.codebinary.appcato.controllers.AppFestivalSingleton;
import com.james.codebinary.appcato.models.Pais;
import com.james.codebinary.appcato.models.Pelicula;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by James on 01/07/16.
 */
public class FragmentoPaisDetalleLista extends Fragment {

    private static final String URL_BASE_PELICULAS = "http://www.festivaldelima.com/2015/api/index.php/list_movies/null/null/9/null/null";
    private List<Pelicula> peliculaList = new ArrayList<>();

    @BindView(R.id.listRecyclerDetallePais)
    RecyclerView recyclerView;

    private LinearLayoutManager linearLayoutManager;
    private PaisDetalleListaAdapters adaptador;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmento_detalle_pais, container, false);

        //Inicializamos ButterKnife
        ButterKnife.bind(this, view);

        //Incializamos las variables
        linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        //Inicializamos el adaptador que recibe el contexto de la actividad y la lista
        adaptador = new PaisDetalleListaAdapters(getActivity(), peliculaList);
        //Le pasamos el adaptador al RecyclerView
        recyclerView.setAdapter(adaptador);

        if(peliculaList.isEmpty()){

            //Realizamos la peticion con volley
            JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,
                    URL_BASE_PELICULAS,
                    null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            JSONArray jsonArray = null;
                            try {
                                jsonArray = response.getJSONArray("posts");

                                for (int i = 0; i < jsonArray.length(); i++) {
                                    try {
                                        JSONObject objeto = jsonArray.getJSONObject(i);
                                        Pelicula pelicula = new Pelicula(
                                                objeto.getInt("post_id"),
                                                objeto.getString("post_title"),
                                                objeto.getString("post_thumbnail"),
                                                objeto.getString("director"),
                                                objeto.getString("post_excerpt"));
                                        peliculaList.add(pelicula);
                                        Log.d("Pelicula: ", peliculaList.toString());
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            adaptador.notifyDataSetChanged();
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            error.printStackTrace();
                            Log.d("Pelicula: ", "Error Respuesta en JSON: " + error.getMessage());
                        }
                    });

            //Agregamos a la cola de peticiones con nuestro patron singleton de volley
            AppFestivalSingleton.getInstance(getActivity().getApplicationContext()).addToRequestQueue(request);
            //requestQueue.add(request);

        }

        return view;
    }
}
