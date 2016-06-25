package com.jcodee.mod2class1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jcodee.mod2class1.models.Usuario;

import butterknife.BindView;

public class RegistroActivity extends BaseActivity {
    @BindView(R.id.txtUsuario)
    EditText txtUsuario;
    @BindView(R.id.txtNombreCompleto)
    EditText txtNombreCompleto;
    @BindView(R.id.txtCorreo)
    EditText txtCorreo;
    @BindView(R.id.txtContrasenia)
    EditText txtContrasenia;
    @BindView(R.id.txtRepContrasenia)
    EditText txtRepContrasenia;
    @BindView(R.id.btnRegistrar)
    Button btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        btnRegistrar.setTag(-1);

        if (getIntent().hasExtra("posicion")) {
            int posicion = getIntent().getIntExtra("posicion", -1);
            Usuario usuario = BienvenidoActivity.lista.get(posicion);

            txtUsuario.setText(usuario.getUsuario());
            txtCorreo.setText(usuario.getCorreo());
            txtNombreCompleto.setText(usuario.getNombreCompleto());
            btnRegistrar.setTag(usuario.getId());
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int codigo = (int) btnRegistrar.getTag();
                //Obtener los datos de los componentes
                String usuario = txtUsuario.getText().toString(),
                        nombreCompleto = txtNombreCompleto.getText().toString(),
                        correo = txtCorreo.getText().toString(),
                        contrasenia = txtContrasenia.getText().toString(),
                        repContrasenia = txtRepContrasenia.getText().toString();

                //Realizar las validaciones
                if (usuario.trim().length() > 0 &&
                        nombreCompleto.trim().length() > 0 &&
                        correo.trim().length() > 0 &&
                        contrasenia.trim().length() > 0 &&
                        repContrasenia.trim().length() > 0) {
                    //Realizamos la validación si es que contraseñas son iguales
                    if (contrasenia.equals(repContrasenia)) {
                        //Creamos un objeto de tipo usuario
                        Usuario obj = new Usuario();
                        obj.setUsuario(usuario);
                        obj.setNombreCompleto(nombreCompleto);
                        obj.setCorreo(correo);
                        obj.setContrasenia(contrasenia);
                        if (codigo == -1) {
                            //Enviamos los datos a la base de datos para que registre
                            boolean registro = sentenciaSQL.registrarUsuario(obj);
                            //Si es registro es exitoso
                            if (registro) {
                                finish();
                                Toast.makeText(RegistroActivity.this,
                                        "Registro correcto.",
                                        Toast.LENGTH_SHORT).show();
                            } else {
                                //Si el registro es fallido
                                Toast.makeText(RegistroActivity.this,
                                        "Registro invalido.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            obj.setId(codigo);
                            boolean actualizo = sentenciaSQL.actualizarUsuario(obj);
                            if (actualizo) {
                                finish();
                                Toast.makeText(RegistroActivity.this,
                                        "Actualización exitosa.",
                                        Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(RegistroActivity.this,
                                        "No se actualizo.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    } else {
                        //Si las contraseñas no coinciden se mostrara un mensaje
                        Toast.makeText(RegistroActivity.this,
                                "Contraseñas no coinciden.",
                                Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(RegistroActivity.this,
                            "Todos los campos son requeridos.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
