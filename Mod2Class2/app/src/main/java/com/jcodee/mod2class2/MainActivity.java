package com.jcodee.mod2class2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jcodee.mod2class2.modelos.Usuario;

import butterknife.BindView;
import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends BaseActivity {
    @BindView(R.id.txtUsuario)
    EditText txtUsuario;
    @BindView(R.id.txtContrasenia)
    EditText txtContrasenia;
    @BindView(R.id.btnIngresar)
    Button btnIngresar;
    @BindView(R.id.btnRegistrar)
    Button btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Obtenemos todos los datos
                String usuario = txtUsuario.getText().toString();
                String contrasenia = txtContrasenia.getText().toString();

                //Validamos que todos los datos esten cargados
                if (usuario.trim().length() > 0 &&
                        contrasenia.trim().length() > 0) {

                    //Verificamos si el usuario ingresado existe en la base de datos
                    Realm realm = Realm.getDefaultInstance();

                    //Realizamos la consulta a la base de datos
                    //Enviamos los dos datos, de usuario y contraseña para verificar
                    Usuario result = realm.where(Usuario.class)
                            .equalTo(Usuario.C_USUARIO, usuario)
                            .equalTo(Usuario.C_CONTRASENIA, contrasenia)
                            .findFirst();

                    if (result != null) {
                        mostrarMensaje("Mensaje", "Usuario -> " + result.getNombre() + " existe.");
                        Intent intent = new Intent(MainActivity.this, ListadoActivity.class);
                        startActivity(intent);
                    } else {
                        mostrarMensaje("Mensaje", "Usuario no existe.");
                    }

                } else {
                    mostrarMensaje("Mensaje", "Todos los campos son requeridos.");
                }

            }
        });

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegistrarActivity.class);
                startActivity(intent);
            }
        });
    }
}
