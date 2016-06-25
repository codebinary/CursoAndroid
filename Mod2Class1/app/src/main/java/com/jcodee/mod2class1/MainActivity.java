package com.jcodee.mod2class1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jcodee.mod2class1.sqlite.SentenciaSQL;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {
    @BindView(R.id.txtUsuario)
    EditText txtUsuario;
    @BindView(R.id.txtContrasenia)
    EditText txtContrasenia;
    @BindView(R.id.btnMostrarContrasenia)
    Button btnMostrarContrasenia;
    @BindView(R.id.btnIngresar)
    Button btnIngresar;
    @BindView(R.id.btnRegistrarAhora)
    Button btnRegistrarAhora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMostrarContrasenia.setTag(0);
    }

    @Override
    protected void onResume() {
        super.onResume();

        btnRegistrarAhora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Enviar al siguiente activity o pantalla
                Intent intent = new Intent(MainActivity.this, RegistroActivity.class);
                startActivity(intent);
            }
        });

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Obtenemos los textos ingresados en nuestros componentes
                String usuario = txtUsuario.getText().toString(),
                        contrasenia = txtContrasenia.getText().toString();

                //Realizamos la validación de los campos, que esten llenos
                if (usuario.trim().length() > 0 &&
                        contrasenia.trim().length() > 0) {
                    //Consultamos a la base de datos si es que los datos ingresados son correctos
                    int id = sentenciaSQL.validarUsuarioId(usuario, contrasenia);
                    //Si existe el usuario en base de datos
                    if (id > -1) {
                        //Llamar a nuestra pantalla de Bienvenida
                        Intent intent = new Intent(MainActivity.this, BienvenidoActivity.class);
                        intent.putExtra("id", id);
                        startActivity(intent);
                        Toast.makeText(MainActivity.this,
                                "Usuario existe",
                                Toast.LENGTH_SHORT).show();
                    } else {
                        //No existe el usuario en base de datos
                        Toast.makeText(MainActivity.this,
                                "Usuario no existe.",
                                Toast.LENGTH_SHORT).show();
                    }
                } else {
                    //Si no se han cargado todos los campos, se muestra un mensaje
                    Toast.makeText(MainActivity.this,
                            "Todos los campos son requeridos.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnMostrarContrasenia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Obtenemos el valor que se guardo en el boton de mostrar contraseña
                int mostrar = (int) btnMostrarContrasenia.getTag();
                //Si el valor es 0, significa que vamos a mostrar la contraseña
                if (mostrar == 0) {
                    //Cambiamos los datos del edittext para que se pueda mostrar la contraseña
                    txtContrasenia.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    txtContrasenia.setTransformationMethod(null);
                    //Setteamos el dato que guardamos en el boton de mostrar contraseña
                    btnMostrarContrasenia.setTag(1);
                } else {
                    //Cambiamos los datos del edittext para que se pueda mostrar la contraseña
                    txtContrasenia.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    txtContrasenia.setTransformationMethod(new PasswordTransformationMethod());
                    //Setteamos el dato que guardamos en el boton de mostrar contraseña
                    btnMostrarContrasenia.setTag(0);
                }
            }
        });
    }
}
