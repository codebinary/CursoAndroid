package com.app.james.restaurantericoparico.fragments;

/**
 * Created by codebinary on 13/06/16.
 */

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.james.restaurantericoparico.R;

/**
 * Fragmento de la sección "Mi Cuenta"
 */
public class FragmentoCuenta extends Fragment {

    private AppBarLayout appBar;
    private TabLayout pestanas;

    public FragmentoCuenta(){
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragmento_paginado, container, false);

        if(savedInstanceState == null){
            insertarTabs(container);
        }
        return view;
    }

    private void insertarTabs(ViewGroup container) {
        View padre = (View) container.getParent();
        appBar = (AppBarLayout) padre.findViewById(R.id.appbar);
        pestanas = new TabLayout(getActivity());
        pestanas.setTabTextColors(Color.parseColor("#FFFFFF"), Color.parseColor("#FFFFFF"));
        appBar.addView(pestanas);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        appBar.removeView(pestanas);
    }
}
