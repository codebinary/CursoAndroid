package com.james.codebinary.recyclerviewvolley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private static final String URL_BASE = "http://festivaldelima.com/2015/api/index.php/novedades";

    @BindView(R.id.rcListado)
    RecyclerView recyclerView;

    private NovedadAdapter novedadAdapter;
    private List<Novedad> novedades = new ArrayList<>();

    RequestQueue requestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        requestQueue = Volley.newRequestQueue(getApplicationContext());


        mostrarInfo();
    }

    private void mostrarInfo() {

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        novedadAdapter = new NovedadAdapter(this, novedades);
        recyclerView.setAdapter(novedadAdapter);


        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,
                URL_BASE,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        JSONArray jsonArray = null;

                        try {
                            jsonArray = response.getJSONArray("posts");

                            for (int i = 0; i < jsonArray.length(); i++){

                                try {
                                    JSONObject objeto = jsonArray.getJSONObject(i);

                                    Novedad novedad = new Novedad(
                                            objeto.getLong("post_id"),
                                            objeto.getString("post_title"),
                                            objeto.getString("post_thumbnail"),
                                            objeto.getString("post_excerpt"),
                                            objeto.getString("post_date"));

                                    novedades.add(novedad);

                                } catch (JSONException e){
                                    e.printStackTrace();
                                }

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        novedadAdapter.notifyDataSetChanged();

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
        });

        requestQueue.add(request);


    }


}
