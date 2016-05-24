package com.james.codebinary.repasotema02_03;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by codebinary on 23/05/16.
 */
public class MostrarDatos  extends AppCompatActivity{

    private TextView lblNombre, lblPais, lblGenero;
    private Button regresar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mostrar_datos);

        lblNombre = (TextView) findViewById(R.id.lblNombre);
        lblPais = (TextView) findViewById(R.id.lblPais);
        lblGenero = (TextView) findViewById(R.id.lblGenero);


        if(getIntent().hasExtra("nombre")){

            String nom = getIntent().getStringExtra("nombre");
            lblNombre.setText(nom);

        }

        if(getIntent().hasExtra("pais")){

            String pai = getIntent().getStringExtra("pais");
            lblPais.setText(pai);
        }

        if(getIntent().hasExtra("genero")){

            String gen = getIntent().getStringExtra("genero");
            lblGenero.setText(gen);

        }

    }

    @Override
    protected void onResume() {
        super.onResume();

        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

            }
        });

    }
}
