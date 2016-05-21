package com.james.codebinary.repasotema02_2v1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.james.codebinary.repasotema02_2v1.adapters.EmpresaAdapter;
import com.james.codebinary.repasotema02_2v1.models.Empresa;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText empresa, ruc, direccion;
    private Button btnGrabar;

    private ListView listaview;
    private ArrayList<Empresa> lista = new ArrayList<>();
    private EmpresaAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        empresa = (EditText) findViewById(R.id.txtEmpresa);
        ruc     = (EditText) findViewById(R.id.numRuc);
        direccion = (EditText) findViewById(R.id.txtDireccion);
        btnGrabar = (Button) findViewById(R.id.btnGrabar);
        listaview = (ListView) findViewById(R.id.lvLista);

        btnGrabar.setTag(-1);

        adapter = new EmpresaAdapter(MainActivity.this, lista);
        listaview.setAdapter(adapter);

    }


    @Override
    protected void onResume() {
        super.onResume();

        btnGrabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String emp = empresa.getText().toString();
                String ru = ruc.getText().toString();
                String dir = direccion.getText().toString();

                if(emp.length() > 0 && ru.length() > 0 && dir.length() > 0){

                    int posicion = (int)btnGrabar.getTag();
                    if(posicion == -1){
                        lista.add(new Empresa(emp, ru, dir));
                    }else{
                        lista.get(posicion).setEmpresa(emp);;
                        lista.get(posicion).setDireccion(dir);
                        lista.get(posicion).setRuc(ru);
                        btnGrabar.setTag(-1);
                    }

                    adapter.notifyDataSetChanged();
                    limpiar();

                }

            }
        });

        listaview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
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
                        btnGrabar.setTag(position);
                    }
                });
                alerBuilder.create().show();
            }
        });

    }

    public void limpiar(){
        empresa.setText("");
        ruc.setText("");
        direccion.setText("");
        empresa.requestFocus();

    }
}
