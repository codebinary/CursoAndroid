package com.james.codebinary.appcato.fragmentos;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.james.codebinary.appcato.R;
import com.james.codebinary.appcato.adapters.NovedadAdapter;
import com.james.codebinary.appcato.controllers.AppFestivalSingleton;
import com.james.codebinary.appcato.models.Novedad;

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
public class FragmentoNovedad extends Fragment {

    private static final String URL_BASE = "http://festivaldelima.com/2015/api/index.php/novedades";


    private List<Novedad> novedadList = new ArrayList<>();

    @BindView(R.id.listRecyclerNovedades)
    RecyclerView recyclerView;

    private LinearLayoutManager linearLayoutManager;
    private NovedadAdapter adaptador;

    public FragmentoNovedad() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmento_novedades, container, false);

        ButterKnife.bind(this, view);

        //RequestQueue requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());

        linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        adaptador = new NovedadAdapter(getActivity(), novedadList);
        recyclerView.setAdapter(adaptador);

        //Realizamos la peticion con volley
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,
                URL_BASE,
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
                                    Novedad novedad = new Novedad(
                                            objeto.getInt("post_id"),
                                            objeto.getString("post_title"),
                                            objeto.getString("post_thumbnail"),
                                            objeto.getString("post_excerpt"),
                                            objeto.getString("post_date"));
                                    novedadList.add(novedad);
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

                    }
                });

        //requestQueue.add(request);
        AppFestivalSingleton.getInstance(getActivity().getApplicationContext()).addToRequestQueue(request);

        return view;
    }

}
