package com.james.codebinary.appcato.fragmentos;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.james.codebinary.appcato.R;
import com.james.codebinary.appcato.Util.Util;
import com.james.codebinary.appcato.adapters.PaisAdapter;
import com.james.codebinary.appcato.adapters.ProgramacionAdapter;
import com.james.codebinary.appcato.controllers.AppFestivalSingleton;
import com.james.codebinary.appcato.models.Pais;
import com.james.codebinary.appcato.models.Secciones;
import com.james.codebinary.appcato.view.ClickListener;
import com.james.codebinary.appcato.view.RecyclerTouchListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by James on 23/06/16.
 */
public class FragmentoProgramacion extends Fragment {

    private static final String URL_SECCIONES = "secciones";
    private List<Secciones> seccionesList = new ArrayList<>();

    private List<Secciones> seccionesSubList = new ArrayList<>();

    @BindView(R.id.listRecyclerProgramacion)
    RecyclerView recyclerView;

    private LinearLayoutManager linearLayoutManager;
    private ProgramacionAdapter adaptador;

    public FragmentoProgramacion(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragmento_programacion, container, false);

        ButterKnife.bind(this, view);

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());

        linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        adaptador = new ProgramacionAdapter(getActivity(), seccionesList);
        recyclerView.setAdapter(adaptador);

        if(seccionesList.isEmpty()){

            //Realizamos la peticion con volley
            JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,
                    Util.URL_BASE + Util.URL_LIST_TYPE + URL_SECCIONES,
                    null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            JSONArray jsonArray = null;
                            JSONObject objeto = null;
                            try {
                                jsonArray = response.getJSONArray("secciones");
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    Secciones objetoSecciones = new Secciones();
                                    try {
                                        objeto = jsonArray.getJSONObject(i);
                                        objetoSecciones.setSec_name(objeto.getString("sec_name"));
                                        seccionesList.add(objetoSecciones);
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }

                                    //Con este for recorredemos las sublistas de las secciones
                                    for (int j = 0; j < objeto.getJSONArray("sec_items").length(); j++){
                                        Secciones objetoSecciones2 = new Secciones();
                                        JSONObject objeto2 = objeto.getJSONArray("sec_items").getJSONObject(j);
                                        //System.out.println(objeto2);
                                        objetoSecciones2.setCategory_name(objeto2.getString("category_name"));
                                        objetoSecciones2.setCategory_id(objeto2.getInt("category_id"));

                                        seccionesList.add(objetoSecciones2);
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
                            Log.d("Pais: ", "Error Respuesta en JSON: " + error.getMessage());
                        }
                    });

            //Agregamos a la cola de peticiones con nuestro patron singleton de volley
            AppFestivalSingleton.getInstance(getActivity().getApplicationContext()).addToRequestQueue(request);
            //requestQueue.add(request);

        }

        return view;
    }


    @Override
    public void onResume() {
        super.onResume();

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity().getApplicationContext(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(getActivity().getApplicationContext(), "Holaaaa" + seccionesList.get(position).getCategory_id(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));


    }
}
