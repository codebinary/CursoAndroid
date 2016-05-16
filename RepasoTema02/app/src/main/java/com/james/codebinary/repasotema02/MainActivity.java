package com.james.codebinary.repasotema02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nombre;
    private Spinner estadoCivil;
    private RadioButton masculino, femenino;
    private Button btnProcesar, btnEnviar;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = (EditText) findViewById(R.id.txtNombre);
        estadoCivil = (Spinner) findViewById(R.id.spEstadoCivil);
        femenino = (RadioButton) findViewById(R.id.rbFemenino);
        masculino = (RadioButton) findViewById(R.id.rbMasculino);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);
        btnProcesar = (Button) findViewById(R.id.btnProcesar);
        resultado = (TextView) findViewById(R.id.lblMostrar);


        ArrayAdapter arrayAdapter = new ArrayAdapter(
                getApplicationContext(),
                R.layout.custom_spinner,
                getResources().getStringArray(R.array.estadoCivil)
        );

        estadoCivil.setAdapter(arrayAdapter);

    }

    @Override
    protected void onResume() {
        super.onResume();


        btnProcesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nom = nombre.getText().toString();
                String estado = estadoCivil.getSelectedItem().toString();
                String gen = (masculino.isChecked() ? masculino.getText().toString() : (femenino.isChecked() ? femenino.getText().toString() : ""));

                if(nom.length() > 0 && estado.length() > 0 && gen.length() > 0){
                    
                    resultado.setText(Html.fromHtml(nom) + " - " + estado + " - " + gen);

                }else{

                    Toast.makeText(MainActivity.this, getResources().getString(R.string.mensajeAlert), Toast.LENGTH_SHORT).show();
                    
                }

            }
        });

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nom = nombre.getText().toString();
                String esta = estadoCivil.getSelectedItem().toString();
                String gen = (masculino.isChecked() ? masculino.getText().toString() : (femenino.isChecked() ? femenino.getText().toString() : ""));

                Intent intent = new Intent(MainActivity.this, MostrarActivdad.class);



            }
        });

    }
}
