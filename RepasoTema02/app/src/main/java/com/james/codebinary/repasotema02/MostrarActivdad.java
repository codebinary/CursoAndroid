package com.james.codebinary.repasotema02;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by codebinary on 15/05/16.
 */
public class MostrarActivdad extends AppCompatActivity {

    private TextView nombre, genero, estadoCivil;
    private Button btnRegresar;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_mostrar);

        nombre = (TextView) findViewById(R.id.lblNombre);
        genero = (TextView) findViewById(R.id.lblGenero);
        estadoCivil = (TextView) findViewById(R.id.lblEstadoCivil);
        btnRegresar = (Button) findViewById(R.id.btnRegresar);


        //Validamos si llego el dato eniado de la pantalla anterior
        if(getIntent().hasExtra("nombre")){

            //Obtenemos los datos enviados desde la pantalla anterior
            String nom = getIntent().getStringExtra("nombre");
            nombre.setText(nom);

        }

        if(getIntent().hasExtra("estado")){

            String esta = getIntent().getStringExtra("estado");
            estadoCivil.setText(esta);

        }

        if(getIntent().hasExtra("genero")){

            String gen = getIntent().getStringExtra("genero");
            genero.setText(gen);

        }

    }

    @Override
    protected void onResume() {
        super.onResume();

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Esto lo que haces es regresar al inicio de la pantalla
                finish();

            }
        });

    }
}
