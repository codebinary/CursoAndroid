package com.jcodee.tema03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.jcodee.tema03.adapters.ElementoAdapter;
import com.jcodee.tema03.modelos.Elemento;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button btnListado;
    private ListView lvLista;
    private ElementoAdapter adapter;
    private ArrayList<Elemento> lista = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnListado = (Button) findViewById(R.id.btnListado);
        lvLista = (ListView) findViewById(R.id.lvLista);

        adapter = new ElementoAdapter(getApplicationContext(), lista);
        lvLista.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        btnListado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lista.add(new Elemento(
                        lista.size(),
                        "http://core0.staticworld.net/images/article/2015/07/angry-android-100599030-primary.idge.jpg",
                        "Imagen Android Rojo"
                ));
                lista.add(new Elemento(
                        lista.size(),
                        "res:/" + R.drawable.imagen,
                        "Imagen Android Verde furioso"
                ));
                adapter.notifyDataSetChanged();
            }
        });
    }
}
