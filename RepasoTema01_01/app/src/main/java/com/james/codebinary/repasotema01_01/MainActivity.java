package com.james.codebinary.repasotema01_01;

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
    private Spinner estadoCivil;
    private Button btnProcesar;
    private TextView resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        nombre = (EditText) findViewById(R.id.txtNombre);
        edad = (EditText) findViewById(R.id.txtEdad);
        estadoCivil = (Spinner) findViewById(R.id.spEstadoCivil);
        btnProcesar = (Button) findViewById(R.id.btnProcesar);
        resultado = (TextView) findViewById(R.id.lblResultado);

        //Creamos el adaptadpr para el spinner
        ArrayAdapter arrayAdapter = new ArrayAdapter(
                getApplicationContext(),
                R.layout.custom_spinner,
                getResources().getStringArray(R.array.estadoCivil));

        estadoCivil.setAdapter(arrayAdapter);

    }


    @Override
    protected void onResume() {
        super.onResume();


        btnProcesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nom = nombre.getText().toString();
                String ed = edad.getText().toString();
                String estado = estadoCivil.getSelectedItem().toString();

                resultado.setText(nom + " - " + ed + " - " + estado);
                resultado.setTextColor(getResources().getColor(R.color.white));

            }
        });


    }
}
