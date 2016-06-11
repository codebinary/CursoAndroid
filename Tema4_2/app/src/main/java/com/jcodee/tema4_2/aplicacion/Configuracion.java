package com.jcodee.tema4_2.aplicacion;

import android.app.Application;
import android.content.IntentFilter;
import android.net.ConnectivityManager;

import com.jcodee.tema4_2.receiver.InternetReceiver;

/**
 * Author: johannfjs
 * Date: 21/5/16
 * Time: 12:17
 */
public class Configuracion extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(new InternetReceiver(), intentFilter);
    }
}
