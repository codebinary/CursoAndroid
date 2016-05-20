package com.james.codebinary.repasotema02_2v1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

                }

            }
        });

    }
}
