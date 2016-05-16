package com.jcodee.tema02_2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.jcodee.tema02_2.models.Empresa;

/**
 * Author: johannfjs
 * Date: 7/5/16
 * Time: 14:52
 */
public class MostrarActivity extends AppCompatActivity {
    private TextView empresa, ruc, direccion;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);

        empresa = (TextView) findViewById(R.id.lblEmpresa);
        ruc = (TextView) findViewById(R.id.lblRuc);
        direccion = (TextView) findViewById(R.id.lblDireccion);

        if (getIntent().hasExtra("posicion")) {
            int posicion = getIntent().getIntExtra("posicion", -1);
            if (posicion > -1) {
                Empresa obj = MainActivity.lista.get(posicion);
                empresa.setText(obj.getEmpresa());
                ruc.setText(obj.getRuc());
                direccion.setText(obj.getDireccion());
            }
        }
    }
}
