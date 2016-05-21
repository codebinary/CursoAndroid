package com.jcodee.tema03_1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.TextView;

import com.jcodee.tema03_1.adapters.ElementoAdapter;
import com.jcodee.tema03_1.modelos.Elemento;

import java.util.ArrayList;

/**
 * Author: johannfjs
 * Date: 14/5/16
 * Time: 12:40
 */
public class SiguienteActivity extends AppCompatActivity {
    private TextView lblUsuario;
    private Spinner spImagen;
    private EditText txtDescripcion;
    private Button btnGuardar;
    private GridView gvDatos;

    private ElementoAdapter adapter;
    private ArrayList<Elemento> lista = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_siguiente);

        lblUsuario = (TextView) findViewById(R.id.lblUsuario);
        spImagen = (Spinner) findViewById(R.id.spImagen);
        txtDescripcion = (EditText) findViewById(R.id.txtDescripcion);
        gvDatos = (GridView) findViewById(R.id.gvGrilla);
        btnGuardar = (Button) findViewById(R.id.btnGuardar);

        adapter = new ElementoAdapter(getApplicationContext(), lista);
        gvDatos.setAdapter(adapter);

        //Validamos que tenga datos
        if (getIntent().getExtras() != null) {
            //Validamos si existe la key de usuario
            if (getIntent().getExtras().containsKey("usuario")) {
                //Si es que existe vamos a obtenerlo
                String usuario = getIntent().getExtras().getString("usuario");
                //Setteamos el valor en nuestro TextView
                lblUsuario.setText(usuario);
            }
        }
    }

    private String rutaImagen = "";

    @Override
    protected void onResume() {
        super.onResume();

        spImagen.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        rutaImagen = "http://hothardware.com/ContentImages/NewsItem/35422/content/google_android.jpg";
                        break;
                    case 1:
                        rutaImagen = "http://static2.businessinsider.com/image/4e2845b94bd7c86f4d030000/theres-an-android-virus-that-records-all-your-phone-calls-without-you-knowing-about-it.jpg";
                        break;
                    case 2:
                        rutaImagen = "http://cdn1.tnwcdn.com/wp-content/blogs.dir/1/files/2015/02/android-loves-apple.jpeg";
                        break;
                    case 3:
                        rutaImagen = "http://cdn2.pcadvisor.co.uk/cmsdata/features/3584168/android_6_0_marshmallow.png";
                        break;
                    case 4:
                        rutaImagen = "res:/" + R.drawable.imagen;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String descripcion = txtDescripcion.getText().toString();

                lista.add(new Elemento(lista.size(), rutaImagen, descripcion));
                adapter.notifyDataSetChanged();
            }
        });
    }
}
