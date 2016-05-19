package com.jcodee.tema02;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Author: johannfjs
 * Date: 7/5/16
 * Time: 11:21
 */
public class MostrarActivity extends AppCompatActivity {
    private TextView nombre, estadoCivil, genero;
    private Button atras;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);

        nombre = (TextView) findViewById(R.id.lblNombre);
        estadoCivil = (TextView) findViewById(R.id.lblEstadoCivil);
        genero = (TextView) findViewById(R.id.lblGenero);
        atras = (Button) findViewById(R.id.btnAtras);

        //Validamos si llego el dato enviado de la pantalla anterior
        if (getIntent().hasExtra("no    mbre")) {
            //Obtenemos los datos enviados desde la pantalla anterior
            String nom = getIntent().getStringExtra("nombre");
            //Toast.makeText(MostrarActivity.this, nom, Toast.LENGTH_SHORT).show();
            nombre.setText(nom);
        }
        if (getIntent().hasExtra("estadoCivil")) {
            String estCiv = getIntent().getStringExtra("estadoCivil");
            estadoCivil.setText(estCiv);
        }
        if (getIntent().hasExtra("genero")) {
            String gen = getIntent().getStringExtra("genero");
            genero.setText(gen);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
