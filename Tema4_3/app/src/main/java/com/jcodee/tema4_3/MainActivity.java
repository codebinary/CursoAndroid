package com.jcodee.tema4_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.jcodee.tema4_3.adapters.ContactoAdapter;
import com.jcodee.tema4_3.modelos.Contacto;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.txtNombre)
    EditText txtNombre;

    @BindView(R.id.txtApellido)
    EditText txtApellido;

    @BindView(R.id.txtCelular)
    EditText txtCelular;

    @BindView(R.id.txtNumeroCasa)
    EditText txtNumeroCasa;

    @BindView(R.id.btnRegistrar)
    Button btnRegistrar;

    @BindView(R.id.spColor)
    Spinner spColor;

    @BindView(R.id.lvLista)
    ListView lvLista;

    ContactoAdapter adapter;
    ArrayList<Contacto> lista = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        adapter = new ContactoAdapter(this, lista);
        lvLista.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "Hola", Toast.LENGTH_SHORT).show();

                String nombre = txtNombre.getText().toString();
                String apellido = txtApellido.getText().toString();
                String celular = txtCelular.getText().toString();
                String telefono = txtNumeroCasa.getText().toString();
                int color = 0;
                switch (spColor.getSelectedItemPosition()) {
                    case 0:
                        color = getResources().getColor(android.R.color.holo_blue_light);
                        break;
                    case 1:
                        color = getResources().getColor(android.R.color.holo_red_light);
                        break;
                    case 2:
                        color = getResources().getColor(android.R.color.holo_green_light);
                        break;
                }

                if (nombre.length() > 0 &&
                        apellido.length() > 0 &&
                        celular.length() > 0 &&
                        telefono.length() > 0) {

                    Contacto contacto = new Contacto();
                    contacto.setNombre(nombre);
                    contacto.setApellido(apellido);
                    contacto.setCelular(celular);
                    contacto.setTelefono(telefono);
                    contacto.setColor(color);
                    lista.add(contacto);
                    adapter.notifyDataSetChanged();

                } else {
                    Toast.makeText(MainActivity.this, "Complete todos los datos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
