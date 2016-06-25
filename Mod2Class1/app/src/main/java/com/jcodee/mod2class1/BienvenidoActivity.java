package com.jcodee.mod2class1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.jcodee.mod2class1.adapters.UsuarioAdapter;
import com.jcodee.mod2class1.models.Usuario;

import org.w3c.dom.Text;

import java.util.ArrayList;

import butterknife.BindView;

public class BienvenidoActivity extends BaseActivity {
    @BindView(R.id.lblNombreCompleto)
    TextView lblNombreCompleto;
    @BindView(R.id.btnCerrarSesion)
    Button btnCerrarSesion;
    @BindView(R.id.lvLista)
    ListView lvLista;
    @BindView(R.id.txtNombreCompleto)
    EditText txtNombreCompleto;
    @BindView(R.id.btnBuscar)
    Button btnBuscar;

    private UsuarioAdapter adapter;
    public static ArrayList<Usuario> lista = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenido);

        //Verificamos si el dato id ha sido enviado
        if (getIntent().hasExtra("id")) {
            //Obtenemos el dato enviado de id
            int id = getIntent().getIntExtra("id", -1);
            //Consultamos en la base de datos el id para obtener un usuario
            Usuario usuario = sentenciaSQL.obtenerUsuarioPorId(id);
            //Setteamos el valor que se encuentra en nuestro textview
            lblNombreCompleto.setText(usuario.getNombreCompleto());
        }

        lista = sentenciaSQL.obtenerUsuarios();
        adapter = new UsuarioAdapter(this, lista);
        lvLista.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        btnCerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Vamos a borrar todo el historico de pantallas
                Intent intent = new Intent(BienvenidoActivity.this, MainActivity.class);
                //Limpiamos todas las tareas que estén en ejecución
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                //Limpiamos todas las pantallas que se hayan quedado en memoría
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                //Creamos una nueva pantalla, en este caso nuestro MainActivity
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                //Ejecutamos el intent
                startActivity(intent);
            }
        });

        lvLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(BienvenidoActivity.this);
                builder.setTitle("Acción a realizar");
                builder.setMessage("¿Que desea hacer?");
                builder.setPositiveButton("Modificar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(BienvenidoActivity.this, RegistroActivity.class);
                        intent.putExtra("posicion", position);
                        startActivity(intent);
                    }
                });
                builder.setNegativeButton("Eliminar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Usuario usuario = lista.get(position);
                        sentenciaSQL.eliminarUsuarioPorId(usuario.getId());
                        Toast.makeText(BienvenidoActivity.this,
                                "Se elimino correctamente el elemento.",
                                Toast.LENGTH_SHORT).show();
                        refrescarListado();
                    }
                });
                builder.create().show();
            }
        });

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscarUsuarios();
            }
        });

        txtNombreCompleto.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                buscarUsuarios();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void buscarUsuarios() {
        String nombreCompleto = txtNombreCompleto.getText().toString();
        lista = sentenciaSQL.consultarUsuariosPorNombre(nombreCompleto);
        adapter = new UsuarioAdapter(BienvenidoActivity.this, lista);
        lvLista.setAdapter(adapter);
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        refrescarListado();
    }

    private void refrescarListado() {
        lista = sentenciaSQL.obtenerUsuarios();
        adapter = new UsuarioAdapter(this, lista);
        lvLista.setAdapter(adapter);
    }
}
