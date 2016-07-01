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
import com.james.codebinary.appcato.adapters.PaisAdapters;
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

    private static final String URL_BASE_PAIS = "http://www.festivaldelima.com/2015/api/index.php/list_type/pais";
    private List<Pais> paisList = new ArrayList<>();

    @BindView(R.id.listRecyclerPaises)
    RecyclerView recyclerView;

    private LinearLayoutManager linearLayoutManager;
    private PaisAdapters adaptador;

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
        adaptador = new PaisAdapters(getActivity(), paisList);
        //Le pasamos el adaptador al RecyclerView
        recyclerView.setAdapter(adaptador);

        //Comprobamos si la lista esta vacia, si lo está hace la petición, si no, no lo vuelve hacer
        if(paisList.isEmpty()){

            //Realizamos la peticion con volley
            JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,
                    URL_BASE_PAIS,
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
                                                objeto.getInt("category_id"),
                                                objeto.getString("category_name"));
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
                switch (id_pais){
                    case 9:case 11:case 432:case 433:case 434:case 435:case 436:case 438:case 439:case 440:
                    case 479:case 480:case 481:case 482:case 483:case 484:case 485:case 488:case 489:case 503:
                    case 504:case 505:case 506:case 507:case 508:case 509:case 510:case 511:case 512:case 513:
                    case 514:case 515:case 520:case 521:case 524:case 525:case 526:case 536:case 553:case 581:

                        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_content, new FragmentoPaisDetalleLista());

                        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                        fragmentTransaction.addToBackStack(null);

                        fragmentTransaction.commit();

                        break;
                }

                /*if(paisList.get(position).getPais_id() == 9){
                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.main_content, new FragmentoPaisDetalleLista());

                    fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                    fragmentTransaction.addToBackStack(null);

                    fragmentTransaction.commit();
                }*/
                //Toast.makeText(getActivity().getApplicationContext(), "Holaaaa" + paisList.get(position).getPais_id(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {
                Toast.makeText(getActivity().getApplicationContext(), "largo click", Toast.LENGTH_SHORT).show();
            }
        }));

    }
}
