package com.jcodee.tema03_1;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodee.tema03_1.modelos.Elemento;

/**
 * Author: johannfjs
 * Date: 14/5/16
 * Time: 14:43
 */
public class MostrarActivity extends AppCompatActivity {
    private SimpleDraweeView sdvImagen;
    private TextView lblDescripcion;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);

        sdvImagen = (SimpleDraweeView) findViewById(R.id.sdvImagen);
        lblDescripcion = (TextView) findViewById(R.id.lblDescripcion);

        //Verificamos si existe la key de posicion
        if (getIntent().hasExtra("posicion")) {
            //Obtenemos la posición enviada
            int posicion = getIntent().getIntExtra("posicion", -1);
            //Con la posición obtenemos el elemento de la lista
            Elemento elemento = SiguienteActivity.lista.get(posicion);

            //Setteamos los datos con lo obtenido
            lblDescripcion.setText(elemento.getDescripcion());
            sdvImagen.setImageURI(Uri.parse(elemento.getRutaImagen()));
        }
    }
}
