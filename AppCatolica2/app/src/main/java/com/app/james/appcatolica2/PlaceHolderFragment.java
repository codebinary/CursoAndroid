package com.app.james.appcatolica2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by codebinary on 31/05/16.
 */

/*
* Fragmento para el contenido principal
 */
public class PlaceHolderFragment extends Fragment {

    //Este argumento del fragmento representa el titulo de cada sección
    public static final String ARG_SECTION_TITLE = "section_number";

    /*
    * Crear un instancia prefabricada de {@link PlaceHolderFragment}
    *
    * @param sectionTitle Título usado en el contneido
    * @return Instancia del fragmento
    *
    * */

    public PlaceHolderFragment(){

    }

    public static PlaceHolderFragment newInstance(String sectionTitle){
        PlaceHolderFragment fragment = new PlaceHolderFragment();
        Bundle args = new Bundle();
        args.putString(ARG_SECTION_TITLE,sectionTitle);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.section_fragment, container, false);

        //Ubicar argumento en el text view de section_fragment.xml
        String title = getArguments().getString(ARG_SECTION_TITLE);
        TextView titulo = (TextView) view.findViewById(R.id.title);
        titulo.setText(title);
        return view;

    }
}
