package com.james.codebinary.repasotema01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText nombre, apellido;
    private Spinner genero;
    private Button btnProcesar;
    private TextView resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = (EditText) findViewById(R.id.txtNombre);
        apellido = (EditText) findViewById(R.id.txtApellido);
        genero = (Spinner) findViewById(R.id.spGenero);
        resultado = (TextView) findViewById(R.id.lblResultado);
        btnProcesar = (Button) findViewById(R.id.btnProcesar);


        //Los parametros que recibe son el contexto de la aplicacion, el diseño que se va ultizar
        //y una lista de obejetos o listView
        ArrayAdapter arrayAdapter = new ArrayAdapter(
                getApplicationContext(),
                R.layout.custom_spinner,
                getResources().getStringArray(R.array.genero));

        genero.setAdapter(arrayAdapter);

    }


    @Override
    protected void onResume() {
        super.onResume();


        btnProcesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nom = nombre.getText().toString();
                String ape = apellido.getText().toString();
                String gen = (String) genero.getSelectedItem();

                resultado.setText(nom + " - " + ape + " - " + gen);
                resultado.setTextSize(24);
                resultado.setTextColor(getResources().getColor(android.R.color.white));


            }
        });


    }
}
