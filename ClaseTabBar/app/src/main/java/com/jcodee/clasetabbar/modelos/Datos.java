package com.jcodee.clasetabbar.modelos;

import android.support.v4.app.Fragment;

/**
 * Author: johannfjs
 * Date: 11/6/16
 * Time: 13:23
 */
public class Datos {
    private Fragment fragment;
    private String titulo;

    public Datos(Fragment fragment, String titulo) {
        this.fragment = fragment;
        this.titulo = titulo;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
