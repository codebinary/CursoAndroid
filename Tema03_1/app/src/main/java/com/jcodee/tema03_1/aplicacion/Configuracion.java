package com.jcodee.tema03_1.aplicacion;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Author: johannfjs
 * Date: 14/5/16
 * Time: 13:09
 */
public class Configuracion extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Fresco.initialize(getApplicationContext());
    }
}
