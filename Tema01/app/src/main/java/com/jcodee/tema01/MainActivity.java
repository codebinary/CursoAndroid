package com.jcodee.tema01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText nombre, edad;
    private Button procesar;
    private TextView resultado;
    private Spinner genero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Life", "onCreate");

        nombre = (EditText) findViewById(R.id.txtNombre);
        edad = (EditText) findViewById(R.id.txtEdad);
        procesar = (Button) findViewById(R.id.btnProcesar);
        resultado = (TextView) findViewById(R.id.lblResultado);
        genero = (Spinner) findViewById(R.id.spGenero);

        //MainActivity.this
        ArrayAdapter arrayAdapter = new ArrayAdapter(
                getApplicationContext(),
                R.layout.custom_spinner,
                getResources().getStringArray(R.array.genero));
        genero.setAdapter(arrayAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Life", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Life", "onResume");

        procesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String vNombre = nombre.getText().toString();
                String vEdad = edad.getText().toString();
                resultado.setText(vNombre + " - " + vEdad);
                resultado.setTextSize(24);
                resultado.setTextColor(getResources().getColor(android.R.color.white));
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Life", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Life", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Life", "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Life", "onRestart");
    }

    
}
