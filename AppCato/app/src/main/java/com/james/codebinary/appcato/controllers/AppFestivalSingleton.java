package com.james.codebinary.appcato.controllers;

/**
 * Created by James on 28/06/16.
 */

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Patrón singleton para Volley
 */
public class AppFestivalSingleton {
    //Atributos
    private static AppFestivalSingleton festivalSingleton;
    private RequestQueue requestQueue;
    private static Context context;

    private AppFestivalSingleton(Context context){
        AppFestivalSingleton.context = context;
        requestQueue = getRequestQueue();
    }

    private static synchronized AppFestivalSingleton getInstance(Context context){
        if(festivalSingleton == null){
            festivalSingleton = new AppFestivalSingleton(context);
        }
        return festivalSingleton;
    }

    public RequestQueue getRequestQueue(){
        if(requestQueue == null){
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }

    public void addToRequestQueue(Request req){
        getRequestQueue().add(req);
    }
}
