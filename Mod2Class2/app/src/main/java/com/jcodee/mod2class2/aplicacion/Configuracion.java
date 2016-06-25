package com.jcodee.mod2class2.aplicacion;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Author: johannfjs
 * Date: 4/6/16
 * Time: 10:26
 */
public class Configuracion extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //Creamos la configuración que tendrá la base de datos de realm
        //En el campo "name" estamos asignando el nombre de la base de datos que se creará
        RealmConfiguration realmConfiguration = new RealmConfiguration
                .Builder(getApplicationContext())
                .name("mod2class2.realm")
                .initialData(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        //Se ejecutan las sentencias para que tenga data pre-cargada
                    }
                })
                .build();

        //Informamos a realm que hay una configuración en la base de datos
        Realm.setDefaultConfiguration(realmConfiguration);
    }
}
