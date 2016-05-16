package com.jcodee.tema02_2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.jcodee.tema02_2.adapters.EmpresaAdapter;
import com.jcodee.tema02_2.models.Empresa;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText empresa, ruc, direccion;
    private Button grabar;
    private ListView listaView;
    public static ArrayList<Empresa> lista = new ArrayList<>();
    private EmpresaAdapter adapter;

    //johannfjs@gmail.com
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        empresa = (EditText) findViewById(R.id.txtEmpresa);
        ruc = (EditText) findViewById(R.id.txtRUC);
        direccion = (EditText) findViewById(R.id.txtDireccion);
        grabar = (Button) findViewById(R.id.btnGrabar);
        listaView = (ListView) findViewById(R.id.lvLista);
        grabar.setTag(-1);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Pacifico.ttf");
        empresa.setTypeface(typeface);

        adapter = new EmpresaAdapter(MainActivity.this, lista);
        listaView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        grabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emp = empresa.getText().toString(),
                        ru = ruc.getText().toString(),
                        dir = direccion.getText().toString();

                if (emp.length() > 0 &&
                        ru.length() > 0 &&
                        dir.length() > 0) {

                    int posicion = (int) grabar.getTag();
                    if (posicion == -1) {
                        lista.add(new Empresa(emp, ru, dir));
                    } else {
                        lista.get(posicion).setEmpresa(emp);
                        lista.get(posicion).setDireccion(dir);
                        lista.get(posicion).setRuc(ru);
                        grabar.setTag(-1);
                    }
                    adapter.notifyDataSetChanged();
                    limpiar();
                } else {
                    Toast.makeText(MainActivity.this,
                            getResources().getString(R.string.validacion),
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        listaView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                Intent intent = new Intent(MainActivity.this, MostrarActivity.class);
                intent.putExtra("posicion", position);
                startActivity(intent);
                /*
                //Toast.makeText(MainActivity.this, "->"+position, Toast.LENGTH_SHORT).show();
                AlertDialog.Builder alerBuilder = new AlertDialog.Builder(MainActivity.this);
                alerBuilder.setTitle("Mensaje");
                alerBuilder.setCancelable(false);
                alerBuilder.setMessage("¿Desea Eliminar el registro?");
                alerBuilder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Toast.makeText(MainActivity.this, "OK", Toast.LENGTH_SHORT).show();
                        lista.remove(position);
                        adapter.notifyDataSetChanged();
                    }
                });
                alerBuilder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Toast.makeText(MainActivity.this, ":(", Toast.LENGTH_SHORT).show();
                    }
                });
                alerBuilder.setNeutralButton("Modificar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Empresa obj = lista.get(position);
                        empresa.setText(obj.getEmpresa());
                        ruc.setText(obj.getRuc());
                        direccion.setText(obj.getDireccion());
                        grabar.setTag(position);
                    }
                });
                alerBuilder.create().show();
                */
            }
        });
    }

    private void limpiar() {
        empresa.setText("");
        ruc.setText("");
        direccion.setText("");
        empresa.requestFocus();
    }
}
