package com.jcodee.clasetabbar.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.jcodee.clasetabbar.fragments.ContactoFragment;
import com.jcodee.clasetabbar.fragments.LlamadaFragment;
import com.jcodee.clasetabbar.fragments.MensajeFragment;
import com.jcodee.clasetabbar.modelos.Datos;

import java.util.ArrayList;

/**
 * Author: johannfjs
 * Date: 11/6/16
 * Time: 12:58
 */
public class DatosAdapter extends FragmentPagerAdapter {
    private ArrayList<Datos> lista = new ArrayList<>();

    public DatosAdapter(FragmentManager fm) {
        super(fm);
    }

    public void agregarPantallas(Datos datos) {
        lista.add(datos);
    }

    @Override
    public Fragment getItem(int position) {
        return lista.get(position).getFragment();
        /*
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new LlamadaFragment();
                break;
            case 1:
                fragment = new MensajeFragment();
                break;
            case 2:
                fragment = new ContactoFragment();
                break;
        }
        return fragment;
        */
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return lista.get(position).getTitulo();
        /*
        String titulo = "";
        switch (position) {
            case 0:
                titulo = "Llamada";
                break;
            case 1:
                titulo = "Mensajes";
                break;
            case 2:
                titulo = "Contactos";
                break;
        }
        return titulo;
        */
    }
}
