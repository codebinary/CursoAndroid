package com.app.james.serviceout;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by James on 10/06/16.
 */
public class MemoryService extends Service{

    private static final String TAG = MemoryService.class.getSimpleName();
    TimerTask timerTask;

    public MemoryService(){

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "Servicio creado....");

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "Servicio iniciando....");

        final ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        final ActivityManager activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);

        Timer timer = new Timer();

        timerTask = new TimerTask() {
            @Override
            public void run() {
                activityManager.getMemoryInfo(memoryInfo);
                String availMen = memoryInfo.availMem / 1048576 + "MB";

                Log.d(TAG, availMen);

                Intent localIntent = new Intent(Constants.ACTION_RUN_SERVICE)
                        .putExtra(Constants.EXTRA_MEMORY, availMen);

                //Emitir el intent a la actividad
                LocalBroadcastManager.getInstance(MemoryService.this).sendBroadcast(localIntent);
            }
        };
        timer.scheduleAtFixedRate(timerTask, 0, 1000);

        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        timerTask.cancel();
        Intent localIntent = new Intent(Constants.ACTION_MEMORY_EXIT);

        //Emitir el intent en la actidad
        LocalBroadcastManager.getInstance(MemoryService.this).sendBroadcast(localIntent);
        Log.d(TAG, "Servicio destruido");
    }
}
