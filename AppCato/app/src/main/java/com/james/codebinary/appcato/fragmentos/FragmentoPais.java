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
import com.james.codebinary.appcato.models.Pais;
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
public class FragmentoPais extends Fragment {

    private static final String URL_BASE_PAIS = "list_type/pais";
    private List<Pais> paisList = new ArrayList<>();

    @BindView(R.id.listRecyclerPaises)
    RecyclerView recyclerView;

    private LinearLayoutManager linearLayoutManager;
    private PaisAdapter adaptador;

    public FragmentoPais() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmento_paises, container, false);

        //Inicializamos ButterKnife
        ButterKnife.bind(this, view);
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        //Incializamos las variables
        linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        //Inicializamos el adaptador que recibe el contexto de la actividad y la lista
        adaptador = new PaisAdapter(getActivity(), paisList);
        //Le pasamos el adaptador al RecyclerView
        recyclerView.setAdapter(adaptador);

        //Comprobamos si la lista esta vacia, si lo está hace la petición, si no, no lo vuelve hacer
        if(paisList.isEmpty()){

            //Realizamos la peticion con volley
            JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,
                    Util.URL_BASE + URL_BASE_PAIS ,
                    null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            JSONArray jsonArray = null;
                            try {
                                jsonArray = response.getJSONArray("categories");

                                for (int i = 0; i < jsonArray.length(); i++) {
                                    try {
                                        JSONObject objeto = jsonArray.getJSONObject(i);
                                        Pais pais = new Pais(
                                                Integer.valueOf(objeto.getInt("category_id")),
                                                String.valueOf(objeto.getString("category_name")));
                                        paisList.add(pais);
                                        Log.d("Pais: ", paisList.toString());
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
                            Log.d("Pais: ", "Error Respuesta en JSON: " + error.getMessage());
                        }
                    });

            //Agregamos a la cola de peticiones con nuestro patron singleton de volley
            //AppFestivalSingleton.getInstance(getActivity().getApplicationContext()).addToRequestQueue(request);
            requestQueue.add(request);

        }
        
        //Retornamos la vista
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        //Obtenemos el id al dar click en cada item de la lista
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity().getApplicationContext(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                int id_pais = paisList.get(position).getPais_id();
                Bundle bundle = new Bundle();
                bundle.putInt("idPais", id_pais);
                FragmentoPaisDetalleLista fdl = new FragmentoPaisDetalleLista();
                fdl.setArguments(bundle);

                //fragmentoPaisDetalleLista.setArguments(bundle);

                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_content, fdl);

                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();
            }

            @Override
            public void onLongClick(View view, int position) {
                Toast.makeText(getActivity().getApplicationContext(), "largo click", Toast.LENGTH_SHORT).show();
            }
        }));

    }
}
