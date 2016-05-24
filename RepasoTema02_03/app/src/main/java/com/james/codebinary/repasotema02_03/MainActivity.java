package com.james.codebinary.repasotema02_03;

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

    private EditText txtNombre;
    private Spinner paises;
    private RadioButton masculino;
    private RadioButton femenino;
    private Button procesar, enviar;
    private TextView resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNombre = (EditText) findViewById(R.id.txtNombre);
        paises = (Spinner) findViewById(R.id.spPaises);
        masculino = (RadioButton) findViewById(R.id.rbMasculino);
        femenino = (RadioButton) findViewById(R.id.rbFemenino);
        procesar = (Button) findViewById(R.id.btnProcesar);
        enviar = (Button) findViewById(R.id.btnEnviar);
        resultado = (TextView) findViewById(R.id.lblResultado);

        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(),
                R.layout.custom_spinner,
                getResources().getStringArray(R.array.paises));

        paises.setAdapter(arrayAdapter);


    }

    @Override
    protected void onResume() {
        super.onResume();

        procesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nom = txtNombre.getText().toString();
                String pais = paises.getSelectedItem().toString();
                String genero = (masculino.isChecked() ? masculino.getText().toString() :
                        (femenino.isChecked() ? femenino.getText().toString() : ""));

                if(nom.length() > 0 && pais.length() > 0 && genero.length() > 0){
                    resultado.setText(Html.fromHtml(nom) + " - " + pais + " - " + genero);
                }else{
                    Toast.makeText(MainActivity.this, "Ingrese todos los datos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nom = txtNombre.getText().toString();
                String pais = paises.getSelectedItem().toString();
                String genero = (masculino.isChecked() ? masculino.getText().toString() :
                        (femenino.isChecked() ? femenino.getText().toString() : ""));


                Intent intent = new Intent(MainActivity.this, MostrarDatos.class);

                intent.putExtra("nombre", nom);
                intent.putExtra("pais", pais);
                intent.putExtra("genero", genero);


            }
        });


    }


}
