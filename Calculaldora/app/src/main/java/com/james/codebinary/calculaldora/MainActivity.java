package com.james.codebinary.calculaldora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Declaramos las variables
    private EditText numero1, numero2;
    private Button btnSumar, btnRestar, btnMulti, btnDividir;
    private TextView resultado;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Obtenemos los valores
        numero1 = (EditText) findViewById(R.id.txtNumero1);
        numero2 = (EditText) findViewById(R.id.txtNumero2);

        btnSumar = (Button) findViewById(R.id.btnSumar);
        btnRestar = (Button) findViewById(R.id.btnRestar);
        btnMulti = (Button) findViewById(R.id.btnMultiplicar);
        btnDividir = (Button) findViewById(R.id.btnDividir);

        resultado = (TextView) findViewById(R.id.lblResultado);
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Life", "onStart");
    }

    protected void onResume(){
        super.onResume();

        Log.d("Life", "onResume");


        btnSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                if(validarCampos()){

                    int num1 = Integer.parseInt(numero1.getText().toString());
                    int num2 = Integer.parseInt(numero2.getText().toString());

                    int suma = num1 + num2;

                    resultado.setText("Resultado es: " + suma);
                    resultado.setTextColor(getResources().getColor(android.R.color.black));

                    limpiar();

                }else{

                    Toast.makeText(MainActivity.this, getResources().getString(R.string.mensaje), Toast.LENGTH_SHORT).show();

                }

            }
        });

        btnRestar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(validarCampos()){

                    int num1 = Integer.parseInt(numero1.getText().toString());
                    int num2 = Integer.parseInt(numero2.getText().toString());

                    int resta = num1 - num2;

                    resultado.setText("La restaes: " +resta);
                    resultado.setTextColor(getResources().getColor(android.R.color.black));
                    limpiar();

                }else{

                    Toast.makeText(MainActivity.this, "Ingrese los dos numeros", Toast.LENGTH_SHORT).show();

                }

            }
        });

        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validarCampos()){
                    
                    int num1 = Integer.parseInt(numero1.getText().toString());
                    int num2 = Integer.parseInt(numero2.getText().toString());

                    int multiplicacion = num1 * num2;

                    resultado.setText("La Multiplicacion es:" + multiplicacion);
                    limpiar();

                }else{

                    Toast.makeText(MainActivity.this, "Ingrese los dos numeros", Toast.LENGTH_SHORT).show();

                }
            }
        });

        btnDividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validarCampos()){

                    int num1 = Integer.parseInt(numero1.getText().toString());
                    int num2 = Integer.parseInt(numero2.getText().toString());

                    if(num1 < num2){

                        Toast.makeText(MainActivity.this, "El dividendo debe ser mayor que el divisor", Toast.LENGTH_SHORT).show();

                    }else{

                        int division = num1 / num2;

                        resultado.setText("La division es: " + division);
                        limpiar();

                    }


                }else{

                    Toast.makeText(MainActivity.this, "Ingrese los dos numeros", Toast.LENGTH_SHORT).show();
                    
                }

            }
        });

    }

    public boolean validarCampos(){

        if(numero1.getText().toString().length() > 0 && numero2.getText().toString().length() > 0){
            return true;
        }else{
            return false;
        }

    }

    public void limpiar(){

        numero1.setText("");
        numero2.setText("");
        numero1.requestFocus();

    }

}
