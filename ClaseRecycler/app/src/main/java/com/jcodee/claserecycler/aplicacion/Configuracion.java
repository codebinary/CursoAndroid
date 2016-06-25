package com.jcodee.claserecycler.aplicacion;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Author: johannfjs
 * Date: 11/6/16
 * Time: 10:00
 */
public class Configuracion extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Fresco.initialize(getApplicationContext());
    }
}
