package com.james.codebinary.ejerciciotema01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText nombre, edad;
    private Spinner genero;
    private Button btnProcesar;
    private TextView respuesta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = (EditText) findViewById(R.id.txtNombre);
        edad = (EditText) findViewById(R.id.txtEdad);
        genero = (Spinner) findViewById(R.id.spGenero);
        btnProcesar = (Button) findViewById(R.id.btnProcesar);
        respuesta = (TextView) findViewById(R.id.lblResultado);


        //Declaramos nuestro array adapter
        ArrayAdapter arrayAdapter = new ArrayAdapter(
                getApplicationContext(),
                R.layout.custom_spinner,
                getResources().getStringArray(R.array.genero));

        genero.setAdapter(arrayAdapter);

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();

        btnProcesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nom = nombre.getText().toString();
                String eda = edad.getText().toString();
                String gen = genero.getAdapter().toString();


                if(nom.length() > 0 && eda.length() > 0){

                    respuesta.setText(nom + " - " + eda + " - "  + gen);
                    respuesta.setTextSize(24);
                    respuesta.setTextColor(getResources().getColor(android.R.color.white));

                }

            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }



}
