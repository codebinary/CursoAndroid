package com.app.james.pedidos.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.provider.BaseColumns;

/**
 * Created by James on 14/06/16.
 */

/**
 * Clase que administra la conexión de la base de datos y su estructuración
 */
public class BaseDatosPedidos extends SQLiteOpenHelper {

    private static  final String NOMBRE_BASE_DATOS = "pedidos.db";

    private static final int VERSION_ACTUAL = 1;

    private final Context context;

    interface Tablas{
        String CABECERA_PEDIDO = "cabecera_pedido";
        String DETALLE_PEDIDO = "detalle_pedido";
        String PRODUCTO = "producto";
        String CLIENTE = "cliente";
        String FORMA_PAGO = "forma_pago";
    }

    interface Referencias {
        String ID_CABECERA_PEDIDO = String.format("REFERENCES %s(%s) ON DELETE CASCADE",
                Tablas.CABECERA_PEDIDO, ContratoPedidos.CabecerasPedido.ID
                );

        String ID_PRODUCTO = String.format("REFERENCES %s(%s)",
                Tablas.PRODUCTO, ContratoPedidos.Productos.ID);

        String ID_CLIENTE = String.format("REFERENCES %s(%s)",
                Tablas.CLIENTE, ContratoPedidos.Clientes.ID);

        String ID_FORMA_PAGO = String.format("REFERENCES %s(%s)",
                Tablas.FORMA_PAGO, ContratoPedidos.FormasPago.ID);

    }

    public BaseDatosPedidos(Context context) {
        super(context, NOMBRE_BASE_DATOS, null, VERSION_ACTUAL);
        this.context = context;
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                db.setForeignKeyConstraintsEnabled(true);
            } else {
                db.execSQL("PRAGMA foreign_keys=ON");
            }
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "%s TEXT UNIQUE NOT NULL,%s DATETIME NOT NULL,%s TEXT NOT NULL %s," +
                        "%s TEXT NOT NULL %s)",
                Tablas.CABECERA_PEDIDO, BaseColumns._ID,
                ContratoPedidos.CabecerasPedido.ID, ContratoPedidos.CabecerasPedido.FECHA,
                ContratoPedidos.CabecerasPedido.ID_CLIENTE, Referencias.ID_CLIENTE,
                ContratoPedidos.CabecerasPedido.ID_FORMA_PAGO, Referencias.ID_FORMA_PAGO));

        db.execSQL(String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "%s TEXT NOT NULL %s,%s INTEGER NOT NULL CHECK (%s>0),%s INTEGER NOT NULL %s," +
                        "%s INTEGER NOT NULL,%s REAL NOT NULL,UNIQUE (%s,%s) )",
                Tablas.DETALLE_PEDIDO, BaseColumns._ID,
                ContratoPedidos.DetallesPedido.ID, Referencias.ID_CABECERA_PEDIDO,
                ContratoPedidos.DetallesPedido.SECUENCIA, ContratoPedidos.DetallesPedido.SECUENCIA,
                ContratoPedidos.DetallesPedido.ID_PRODUCTO, Referencias.ID_PRODUCTO,
                ContratoPedidos.DetallesPedido.CANTIDAD, ContratoPedidos.DetallesPedido.PRECIO,
                ContratoPedidos.DetallesPedido.ID, ContratoPedidos.DetallesPedido.SECUENCIA));

        db.execSQL(String.format("CREATE TABLE %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "%s TEXT NOT NULL UNIQUE,%s TEXT NOT NULL,%s REAL NOT NULL," +
                        "%s INTEGER NOT NULL CHECK(%s>=0) )",
                Tablas.PRODUCTO, BaseColumns._ID,
                ContratoPedidos.Productos.ID, ContratoPedidos.Productos.NOMBRE, ContratoPedidos.Productos.PRECIO,
                ContratoPedidos.Productos.EXISTENCIAS, ContratoPedidos.Productos.EXISTENCIAS));

        db.execSQL(String.format("CREATE TABLE %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "%s TEXT NOT NULL UNIQUE,%s TEXT NOT NULL,%s TEXT NOT NULL,%s )",
                Tablas.CLIENTE, BaseColumns._ID,
                ContratoPedidos.Clientes.ID, ContratoPedidos.Clientes.NOMBRES, ContratoPedidos.Clientes.APELLIDOS, ContratoPedidos.Clientes.TELEFONO));

        db.execSQL(String.format("CREATE TABLE %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "%s TEXT NOT NULL UNIQUE,%s TEXT NOT NULL )",
                Tablas.FORMA_PAGO, BaseColumns._ID,
                ContratoPedidos.FormasPago.ID, ContratoPedidos.FormasPago.NOMBRE));
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + Tablas.CABECERA_PEDIDO);
        db.execSQL("DROP TABLE IF EXISTS " + Tablas.DETALLE_PEDIDO);
        db.execSQL("DROP TABLE IF EXISTS " + Tablas.PRODUCTO);
        db.execSQL("DROP TABLE IF EXISTS " + Tablas.CLIENTE);
        db.execSQL("DROP TABLE IF EXISTS " + Tablas.FORMA_PAGO);

        onCreate(db);
    }
}
