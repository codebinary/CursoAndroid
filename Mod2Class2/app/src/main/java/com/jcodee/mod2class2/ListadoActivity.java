package com.jcodee.mod2class2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.jcodee.mod2class2.adapters.UsuarioAdapter;
import com.jcodee.mod2class2.modelos.Usuario;

import butterknife.BindView;
import io.realm.Realm;
import io.realm.RealmResults;

public class ListadoActivity extends BaseActivity {
    @BindView(R.id.lvLista)
    ListView lvLista;

    private UsuarioAdapter adapter;
    private RealmResults<Usuario> results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        //Realizamos la consulta a la base de datos para traer todos los registros
        Realm realm = Realm.getDefaultInstance();
        results = realm.where(Usuario.class).findAll();
        adapter = new UsuarioAdapter(this, results);
        lvLista.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        lvLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                AlertDialog.Builder alerBuilder = new AlertDialog.Builder(ListadoActivity.this);
                alerBuilder.setTitle("Seleccione");
                alerBuilder.setMessage("Acción a realizar?");
                alerBuilder.setPositiveButton("Modificar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(ListadoActivity.this, RegistrarActivity.class);
                        intent.putExtra("id", results.get(position).getId());
                        startActivity(intent);
                    }
                });
                alerBuilder.setNegativeButton("Eliminar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //realizamos la consulta del registro que queremos eliminar
                        Realm realm = Realm.getDefaultInstance();
                        //Indicamos que estamos iniciando una transacción
                        realm.beginTransaction();
                        //Buscamos el dato a eliminar
                        RealmResults<Usuario> usuario = realm.where(Usuario.class)
                                .equalTo(Usuario.C_ID, results.get(position).getId())
                                .findAll();
                        //Eliminamos el registro de la bd
                        usuario.deleteFirstFromRealm();
                        //Guardamos los cambios que se han realizado en la base de datos
                        realm.commitTransaction();

                        //Obtenemos los datos actuales de la base de datos
                        results = realm.where(Usuario.class).findAll();
                        adapter = new UsuarioAdapter(ListadoActivity.this, results);
                        lvLista.setAdapter(adapter);
                    }
                });
                alerBuilder.create().show();
            }
        });
    }
}
