package com.jcodee.mod2class2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jcodee.mod2class2.modelos.Usuario;

import butterknife.BindView;
import io.realm.Realm;

public class RegistrarActivity extends BaseActivity {
    @BindView(R.id.txtUsuario)
    EditText txtUsuario;
    @BindView(R.id.txtNombre)
    EditText txtNombre;
    @BindView(R.id.txtCorreo)
    EditText txtCorreo;
    @BindView(R.id.txtContrasenia)
    EditText txtContrasenia;
    @BindView(R.id.txtRepContrasenia)
    EditText txtRepContrasenia;
    @BindView(R.id.btnRegistrar)
    Button btnRegistrar;

    private long id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        if (getIntent().hasExtra("id")) {
            id = getIntent().getLongExtra("id", -1);

            Realm realm = Realm.getDefaultInstance();
            Usuario usuario = realm.where(Usuario.class)
                    .equalTo(Usuario.C_ID, id)
                    .findFirst();

            txtUsuario.setText(usuario.getUsuario());
            txtCorreo.setText(usuario.getCorreo());
            txtNombre.setText(usuario.getNombre());
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (id == 0) {
                    //Obtenemos todos los datos de las cajas de texto
                    final String nombre = txtNombre.getText().toString();
                    final String correo = txtCorreo.getText().toString();
                    final String usuario = txtUsuario.getText().toString();
                    final String contrasenia = txtContrasenia.getText().toString();
                    String repContrasenia = txtRepContrasenia.getText().toString();

                    //Validamos que todos los campos hayan sido ingresados
                    if (nombre.trim().length() > 0 &&
                            correo.trim().length() > 0 &&
                            usuario.trim().length() > 0 &&
                            contrasenia.trim().length() > 0 &&
                            repContrasenia.trim().length() > 0) {
                        //Validamos que la contraseña ingresada sea igual al repetir contraseña
                        if (contrasenia.equals(repContrasenia)) {

                            //Registramos en nuestra base de datos
                            Realm realm = Realm.getDefaultInstance();
                            realm.executeTransactionAsync(
                                    new Realm.Transaction() {
                                        @Override
                                        public void execute(Realm realm) {
                                            //Registramos un usuario a nuestra base de datos
                                            Usuario obj = realm.createObject(Usuario.class);
                                            obj.setId(Usuario.getLastId());
                                            obj.setUsuario(usuario);
                                            obj.setCorreo(correo);
                                            obj.setNombre(nombre);
                                            obj.setContrasenia(contrasenia);
                                        }
                                    },
                                    new Realm.Transaction.OnSuccess() {
                                        @Override
                                        public void onSuccess() {
                                            //Si la transacción es correcta
                                            mostrarMensaje("Éxito", "Se registro correctamente.");
                                        }
                                    },
                                    new Realm.Transaction.OnError() {
                                        @Override
                                        public void onError(Throwable error) {
                                            //Si la transacción tiene un error
                                            mostrarMensaje("Error", "Ocurrio un error interno." + error.getMessage());
                                        }
                                    });

                        } else {
                            mostrarMensaje("Mensaje", "Contraseñas no coinciden.");
                        }
                    } else {
                        mostrarMensaje("Mensaje", "Todos los campos son requeridos.");
                    }
                } else {
                    //Iniciando la transacción
                    Realm realm = Realm.getDefaultInstance();
                    realm.beginTransaction();
                    //Obtenemos el objeto de tipo usuario
                    Usuario usuario = new Usuario();
                    usuario.setNombre(txtNombre.getText().toString());
                    usuario.setContrasenia(txtContrasenia.getText().toString());
                    usuario.setCorreo(txtCorreo.getText().toString());
                    usuario.setUsuario(txtUsuario.getText().toString());
                    usuario.setId(id);
                    //Indicamos que vamos a actualizar el dato
                    realm.copyToRealmOrUpdate(usuario);
                    //Guardamos los cambios realizados en la base de datos
                    realm.commitTransaction();

                    finish();
                }

            }
        });
    }
}
