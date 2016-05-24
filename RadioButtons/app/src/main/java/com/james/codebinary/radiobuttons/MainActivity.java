package com.james.codebinary.radiobuttons;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private View contenedorParticular;
    private View contendorCorporativo;

    private RadioButton radioDeposito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioDeposito = (RadioButton) findViewById(R.id.radio_deposito);

        contendorCorporativo = findViewById(R.id.ll_contenedor_corporativo);
        contenedorParticular = findViewById(R.id.ll_contenedor_particular);

    }

    public void comprobarModoPago(View v){

        if(radioDeposito.isChecked()){
            final String text = "Comprobar ubicación del usuario";
            Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
        }

    }

    public void onRadioButtonClicked(View view) {

        boolean marcado = ((RadioButton) view).isChecked();

        switch (view.getId()){

            case R.id.rb_corporativo:
                if(marcado){
                    mostrarParticular(false);
                }
                break;
            case R.id.rb_particular:
                if(marcado){
                    mostrarParticular(true);
                }
                break;

        }

    }

    private void mostrarParticular(boolean b){

        contenedorParticular.setVisibility(b ? View.VISIBLE : View.GONE );
        contendorCorporativo.setVisibility(b ? View.GONE : View.VISIBLE);

    }
}
