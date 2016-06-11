package com.app.james.serviceout;

import android.app.IntentService;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by James on 10/06/16.
 */
public class ProgressIntentService extends IntentService {

    private static final String TAG = ProgressIntentService.class.getSimpleName();

    public ProgressIntentService() {
        super("ProgressIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if(intent != null){
            final String action = intent.getAction();
            if(Constants.ACTION_RUN_ISERVICE.equals(action)){
                handleActionRun();
            }
        }
    }

    /**
     * Maneja la acción de ejecución del servicio
     */
    private void handleActionRun(){
        try {
            //Se construye la notificación
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                    .setSmallIcon(android.R.drawable.stat_sys_download_done)
                    .setContentTitle("Servicio en segundo plano")
                    .setContentText("Procesando...");

            //Bucle de simulación
            for(int i = 1; i <= 10; i++){
                Log.d(TAG, i + ""); //Logueo

                //Poner en primero plano
                builder.setProgress(10, i, false);
                startForeground(1, builder.build());

                Intent localIntent = new Intent(Constants.ACTION_RUN_ISERVICE)
                        .putExtra(Constants.EXTRA_PROGRESS, i);

                // Emisión de {@code localIntent}
                LocalBroadcastManager.getInstance(this).sendBroadcast(localIntent);

                //Retardo de 1 segundo en la iteracion
                Thread.sleep(1000);
            }

            //quitar de primero plano
            stopForeground(true);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Servicio destruido.....", Toast.LENGTH_LONG).show();

        //Emisión para avisar que se terminó el servicio
        Intent localIntent = new Intent(Constants.ACTION_PROGRESS_EXIT);
        LocalBroadcastManager.getInstance(this).sendBroadcast(localIntent);
    }
}
