package com.james.codebinary.appcato;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.bumptech.glide.Glide;
import com.james.codebinary.appcato.Util.Util;
import com.james.codebinary.appcato.controllers.AppFestivalSingleton;
import com.james.codebinary.appcato.models.Pelicula;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import butterknife.BindView;

/**
 * Created by codebinary on 27/07/16.
 */
public class DetailPeliActivity extends BaseActivity {

    private final int PARAMETER_DEFAULT = 0;
    private final String URL_MOVIE = "movie/";

    Pelicula pelicula;

    public List<Pelicula> listaMovie = new ArrayList<>();

    @BindView(R.id.toolbar2)
    Toolbar toolbar2;


    @BindView(R.id.title_pe)
    TextView title_pe;
    @BindView(R.id.img_pe)
    ImageView img_pe;
    @BindView(R.id.descrip_pe)
    TextView descrip_pe;
    @BindView(R.id.director_pe)
    TextView director_pe;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pelicula);

        agregarToolbar();

        //Obtenemos el valor del post_id
        if(getIntent().hasExtra("post_id")){
            System.out.println("Existe la variable");
            int id = getIntent().getIntExtra("post_id", PARAMETER_DEFAULT);
            System.out.println("Parametro de la actividad " + id);

            //Realizamos la peticion con volley
            final JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,
                    Util.URL_BASE + URL_MOVIE + id,
                    null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            JSONArray jsonArray = null;
                            try {
                                if(response.has("post") && response.get("post") instanceof JSONObject){
                                    JSONObject post = response.getJSONObject("post");
                                    Log.d("post", post.toString());
                                    String titulo = post.getString("title");
                                    pelicula = new Pelicula();

                                    pelicula.setPelicula_titulo(post.getString("title"));
                                    pelicula.setPelicula_excerpt(post.getString("content"));
                                    pelicula.setPelicula_thumbnail(post.getString("thumbnail"));
                                    pelicula.setPelicula_director(post.getString("director"));

                                    title_pe.setText(pelicula.getPelicula_titulo());
                                    Glide.with(DetailPeliActivity.this).load(pelicula.getPelicula_thumbnail()).into(img_pe);
                                    descrip_pe.setText(pelicula.getPelicula_excerpt());
                                    director_pe.setText(pelicula.getPelicula_director());

                                }



                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            error.printStackTrace();
                            Log.d("Pelicula: ", "Error Respuesta en JSON: " + error.getMessage());
                        }
                    });

            AppFestivalSingleton.getInstance(this).addToRequestQueue(request);
        }

    }



    //Método que agrega el toolbar, con nombre de la aplicacion
    public void agregarToolbar(){
        setSupportActionBar(toolbar2);
        final ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            //Poner icono de drawer toggle
            //actionBar.setHomeAsUpIndicator(R.drawable.drawer_toggle);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                Log.i("ActionBar" , "Atrás");
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
