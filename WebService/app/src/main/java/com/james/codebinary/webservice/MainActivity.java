package com.james.codebinary.webservice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.james.codebinary.webservice.models.Secciones;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public View root;
    ListAdapter adapter;
    ArrayList<Secciones> listaSecciones;
    ListView lvLista;
    String tag_json_arry = "jarray req";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        root = findViewById(android.R.id.content).getRootView();
        InitViews.whichClass(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        listaSecciones = new ArrayList<>();
        JsonArrayRequest request = new JsonArrayRequest(Constant.URL_LISTAR_SECCIONES,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        try {
                            if (response.length() > 0){
                                for (int i = 0; i < response.length(); i++){
                                    JSONObject jsonObject = response.getJSONObject(i);
                                    listaSecciones.add(new Secciones(listaSecciones.size(),
                                            jsonObject.getString("sec_nombre"),
                                            jsonObject.getString("sec_items")));

                                }
                                adapter = new ListAdapter(getApplicationContext(), listaSecciones);

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                });

    }
}
