package com.jcodee.tema02;

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
    private Button mostrar, enviar;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = (EditText) findViewById(R.id.txtNombre);
        estadoCivil = (Spinner) findViewById(R.id.spEstadoCivil);
        masculino = (RadioButton) findViewById(R.id.rbMasculino);
        femenino = (RadioButton) findViewById(R.id.rbFemenino);
        mostrar = (Button) findViewById(R.id.btnMostrar);
        resultado = (TextView) findViewById(R.id.lblResultado);
        enviar = (Button) findViewById(R.id.btnEnviar);

        ArrayAdapter arrayAdapter = new ArrayAdapter(
                MainActivity.this,
                android.R.layout.simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.estado_civil)
        );
        estadoCivil.setAdapter(arrayAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String v_nombre = nombre.getText().toString(),
                        v_estadoCivil = estadoCivil.getSelectedItem().toString(),
                        v_genero = (masculino.isChecked() ?
                                masculino.getText().toString() :
                                (femenino.isChecked() ?
                                        femenino.getText().toString() : ""));

                if (v_nombre.length() > 0 &&
                        v_estadoCivil.length() > 0 &&
                        v_genero.length() > 0) {
                    resultado.setText(
                            Html.fromHtml(v_nombre) + " - " + v_estadoCivil + " - " + v_genero
                    );
                } else {
                    Toast.makeText(MainActivity.this,
                            getResources().getString(R.string.mensaje),
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String v_nombre = nombre.getText().toString(),
                        v_estadoCivil = estadoCivil.getSelectedItem().toString(),
                        v_genero = (masculino.isChecked() ?
                                masculino.getText().toString() :
                                (femenino.isChecked() ?
                                        femenino.getText().toString() : ""));

                //Creando la sentencia de envio o cambio de pantalla
                Intent intent = new Intent(MainActivity.this, MostrarActivity.class);

                intent.putExtra("nombre", v_nombre);
                intent.putExtra("estadoCivil", v_estadoCivil);
                intent.putExtra("genero", v_genero);

                //Ejecutamos la linea del intent
                startActivity(intent);
            }
        });
    }
}
