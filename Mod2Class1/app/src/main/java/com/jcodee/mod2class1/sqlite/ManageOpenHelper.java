package com.jcodee.mod2class1.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Author: johannfjs
 * Date: 28/5/16
 * Time: 10:28
 */
public class ManageOpenHelper extends SQLiteOpenHelper {
    public ManageOpenHelper(Context context) {
        super(context, "mod2class1.db", null, 1);
    }

    //Se va a ejecutar solamente la primera vez que se utilice la clase de ManageOpenHelper
    @Override
    public void onCreate(SQLiteDatabase db) {
        //Diseñar todas las tablas de bd
        db.execSQL(
                "create table usuarios(" +
                        "id integer primary key autoincrement," +
                        "usuario text," +
                        "nombre_completo text," +
                        "correo text," +
                        "contrasenia text)"
        );
    }

    //Se ejecuta siempre y cuando varie la versión de la bd
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        switch (newVersion) {
            case 2:
                //Ejecutando las sentencias de sql
                break;
        }
    }
}
