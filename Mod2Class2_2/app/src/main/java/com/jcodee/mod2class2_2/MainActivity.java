package com.jcodee.mod2class2_2;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import butterknife.BindView;

public class MainActivity extends BaseActivity {
    @BindView(R.id.txtTitulo)
    EditText txtTitulo;
    @BindView(R.id.spOpcion)
    Spinner spOpcion;
    @BindView(R.id.btnGrabar)
    Button btnGrabar;
    @BindView(R.id.btnObtener)
    Button btnObtener;
    @BindView(R.id.lblTitulo)
    TextView lblTitulo;
    @BindView(R.id.lblOpcion)
    TextView lblOpcion;
    @BindView(R.id.btnEliminar)
    Button btnEliminar;
    @BindView(R.id.btnEliminarOpcion)
    Button btnEliminarOpcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        btnEliminarOpcion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("Mod2Class2", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                //Eliminamos la variable de opcion de las preferencias
                editor.remove("opcion");
                //Guardamos los cambios realizados
                editor.commit();
            }
        });


        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("Mod2Class2", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                //Limpiamos todas las variables del sharedPreferences
                editor.clear();
                //Guardamos los cambios realizados
                editor.commit();
            }
        });

        btnGrabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Vamos a crear la configuracion en la aplicación para guardar la información
                SharedPreferences sharedPreferences = getSharedPreferences("Mod2Class2", MODE_PRIVATE);
                //Indicamos que realizaremos una edición en las preferencias o datos almacenados
                SharedPreferences.Editor editor = sharedPreferences.edit();
                //Obtenemos los datos que vamos a almacenar
                editor.putString("titulo", txtTitulo.getText().toString());
                editor.putString("opcion", spOpcion.getSelectedItem().toString());
                //Para almacenar la información
                editor.commit();
                //Mostramos mensaje para confirmar que los datos han sido almacenados
                Toast.makeText(
                        MainActivity.this,
                        "Datos almacenados.",
                        Toast.LENGTH_SHORT).show();
            }
        });

        btnObtener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Obtenemos el sharedPreferences que estamos empleando
                SharedPreferences sharedPreferences = getSharedPreferences("Mod2Class2", MODE_PRIVATE);
                //Obtenemos los datos que queremos
                String titulo = sharedPreferences.getString("titulo", "");
                String opcion = sharedPreferences.getString("opcion", "");

                //seteamos los datos para mostrarlos en los textView
                lblTitulo.setText(titulo);
                lblOpcion.setText(opcion);
            }
        });
    }
}
