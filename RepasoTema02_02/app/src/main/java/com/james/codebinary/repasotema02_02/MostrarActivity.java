package com.james.codebinary.repasotema02_02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MostrarActivity extends AppCompatActivity {

    private TextView nombre, genero, pais;
    private Button btnRegresar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_mostrar);

        nombre = (TextView) findViewById(R.id.lblNombre);
        genero = (TextView) findViewById(R.id.lblGenero);
        pais = (TextView) findViewById(R.id.lblPais);
        btnRegresar = (Button) findViewById(R.id.btnRegresar);

        //VAlidamos los datos
        if(getIntent().hasExtra("nombre")){

            //Obtenemos los datos enviados desde la pantalla anterior
            String nom = getIntent().getStringExtra("nombre");
            nombre.setText(nom);

        }

        if(getIntent().hasExtra("genero")){

            String gen = getIntent().getStringExtra("genero");
            genero.setText(gen);

        }

        if(getIntent().hasExtra("pais")){

            String pai = getIntent().getStringExtra("pais");
            pais.setText(pai);

        }

    }


    @Override
    protected void onResume() {
        super.onResume();


        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

            }
        });

    }
}
