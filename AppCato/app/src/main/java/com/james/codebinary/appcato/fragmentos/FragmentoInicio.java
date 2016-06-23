package com.james.codebinary.appcato.fragmentos;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.james.codebinary.appcato.R;

import butterknife.BindView;

/**
 * Created by codebinary on 22/06/16.
 */

//Fragmento para el diseño del home
public class FragmentoInicio extends Fragment {

    @BindView(R.id.title)
    TextView title;

    public static final String ARG_SECTION_TITLE = "section_number";


    //Crear una instancia de FragmentoIncio
    //sectionTitle Titulo utilizado en el contenido
    //@return instancia del fragmento
    public static FragmentoInicio newInstance(String sectionTitle){
        //Creamos un framento
        FragmentoInicio fragmentoInicio = new FragmentoInicio();
        //Guardamos el argumento
        Bundle args = new Bundle();
        //Le pasamos la clave y el valor
        args.putString(ARG_SECTION_TITLE, sectionTitle);
        //Seteamos el argumento en el fragmento
        fragmentoInicio.setArguments(args);
        //Retornamos el fragmento
        return fragmentoInicio;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragmento_inicio, container, false);

        //Ubicar argumento en el text view de section_fragment.xml
        String titulo = getArguments().getString(ARG_SECTION_TITLE);
        title.setText(titulo);
        return view;

    }
}
