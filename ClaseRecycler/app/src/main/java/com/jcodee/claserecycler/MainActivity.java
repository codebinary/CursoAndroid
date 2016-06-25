package com.jcodee.claserecycler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.jcodee.claserecycler.adapters.DatosAdapter;
import com.jcodee.claserecycler.modelos.Datos;
import com.jcodee.claserecycler.view.ClickListener;
import com.jcodee.claserecycler.view.DividirItemDecoration;
import com.jcodee.claserecycler.view.RecyclerTouchListener;

import java.util.ArrayList;

import butterknife.BindView;

public class MainActivity extends BaseActivity {
    @BindView(R.id.btnMostrar)
    Button btnMostrar;
    @BindView(R.id.rcDatos)
    RecyclerView rvDatos;
    @BindView(R.id.txtNombre)
    EditText txtNombre;
    @BindView(R.id.txtApellido)
    EditText txtApellido;
    @BindView(R.id.spCarrera)
    Spinner spCarrera;

    private DatosAdapter adapter;
    private ArrayList<Datos> lista = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new DatosAdapter(lista);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rvDatos.setLayoutManager(layoutManager);
        //rvDatos.addItemDecoration(new DividirItemDecoration(this, LinearLayoutManager.VERTICAL));
        rvDatos.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = txtNombre.getText().toString();
                String apellido = txtApellido.getText().toString();
                String carrera = spCarrera.getSelectedItem().toString();

                if (nombre.trim().length() > 0 &&
                        apellido.trim().length() > 0 &&
                        carrera.trim().length() > 0) {
                    lista.add(new Datos(lista.size(), nombre, apellido, carrera, "http://i.utdstc.com/icons/256/uptodown-android-android.png"));
                    adapter.notifyDataSetChanged();
                }

                /*
                lista.add(new Datos(lista.size(), "Johann", "Jara", "Sistemas", "http://www.androidjefe.com/wp-content/uploads/2015/06/android-jefe-fondo-original.jpg"));
                lista.add(new Datos(lista.size(), "Johann1", "Jara1", "Sistemas1", "https://lh3.googleusercontent.com/00APBMVQh3yraN704gKCeM63KzeQ-zHUi5wK6E9TjRQ26McyqYBt-zy__4i8GXDAfeys=w300"));
                lista.add(new Datos(lista.size(), "Johann1", "Jara1", "Sistemas1", "http://i.utdstc.com/icons/256/uptodown-android-android.png"));
                adapter.notifyDataSetChanged();
                */
            }
        });

        rvDatos.addOnItemTouchListener(new RecyclerTouchListener(this, rvDatos, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(MainActivity.this, "Holaaaa", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {
                Toast.makeText(MainActivity.this, "Holaa Longgg", Toast.LENGTH_SHORT).show();
            }
        }));
    }
}
