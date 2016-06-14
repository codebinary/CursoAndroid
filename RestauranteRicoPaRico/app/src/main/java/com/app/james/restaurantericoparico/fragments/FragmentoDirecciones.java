package com.app.james.restaurantericoparico.fragments;

/**
 * Created by James on 14/06/16.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.app.james.restaurantericoparico.DecoracionLineaDivisora;
import com.app.james.restaurantericoparico.R;
import com.app.james.restaurantericoparico.adapters.AdaptadorDirecciones;

/**
 * Fragmento para la pestaña "DIRECCIONES" De la sección "Mi Cuenta"
 */
public class FragmentoDirecciones extends Fragment{

    private LinearLayoutManager linearLayout;

    public FragmentoDirecciones(){}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmento_grupo_items, container, false);

        RecyclerView reciclador = (RecyclerView) view.findViewById(R.id.reciclador);
        linearLayout = new LinearLayoutManager(getActivity());
        reciclador.setLayoutManager(linearLayout);

        AdaptadorDirecciones adaptador = new AdaptadorDirecciones();
        reciclador.setAdapter(adaptador);
        reciclador.addItemDecoration(new DecoracionLineaDivisora(getActivity()));

        return view;
    }
}
