package com.jcodee.tema4_2.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * Author: johannfjs
 * Date: 21/5/16
 * Time: 12:19
 */
public class InternetReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            Toast.makeText(context, "Conexión a internet", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "No hay conexión a internet", Toast.LENGTH_SHORT).show();
        }
    }
}
