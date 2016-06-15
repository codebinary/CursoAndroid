package com.app.james.pedidos.sqlite;

/**
 * Created by James on 14/06/16.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

/**
 * Clase auxiliar que implementa a {@link BaseDatosPedidos} para llevar a cabo el CRUD
 * sobre las entidades existentes.
 */
public final class OperacionesBaseDatos {

    private static BaseDatosPedidos baseDatos;

    private static OperacionesBaseDatos instancia = new OperacionesBaseDatos();

    private OperacionesBaseDatos() {
    }

    public static OperacionesBaseDatos obtenerInstancia(Context contexto) {
        if (baseDatos == null) {
            baseDatos = new BaseDatosPedidos(contexto);
        }
        return instancia;
    }



    public Cursor obtenerCabecerasPedidos(){
        SQLiteDatabase db = baseDatos.getReadableDatabase();

        SQLiteQueryBuilder builder = new SQLiteQueryBuilder();

        builder.setTables(CABECERA_PEDIDO_JOIN_CLIENTE_Y_FORMA_PAGO);

        return builder.query(db, proyCabeceraPedido, null, null, null, null, null);
    }

    private static final String CABECERA_PEDIDO_JOIN_CLIENTE_Y_FORMA_PAGO = "cabecera_pedido " +
            "INNER JOIN cliente " +
            "ON cabecera_pedido.id_cliente = cliente.id " +
            "INNER JOIN forma_pago " +
            "ON cabecera_pedido.id_forma_pago = forma_pago.id";

    private final String[] proyCabeceraPedido = new String[]{
            BaseDatosPedidos.Tablas.CABECERA_PEDIDO + "." + ContratoPedidos.CabecerasPedido.ID,
            ContratoPedidos.CabecerasPedido.FECHA,
            ContratoPedidos.Clientes.NOMBRES,
            ContratoPedidos.Clientes.APELLIDOS,
            ContratoPedidos.FormasPago.NOMBRE};


    public Cursor obtenerCabeceraPorId(String id){
        SQLiteDatabase db = baseDatos.getWritableDatabase();

        String selection = String.format("%s=?", ContratoPedidos.CabecerasPedido.ID);
        String[] selectionArgs = {id};

        SQLiteQueryBuilder builder = new SQLiteQueryBuilder();
        builder.setTables(CABECERA_PEDIDO_JOIN_CLIENTE_Y_FORMA_PAGO);

        String[] proyeccion = {
                BaseDatosPedidos.Tablas.CABECERA_PEDIDO + "." + ContratoPedidos.CabecerasPedido.ID,
                ContratoPedidos.CabecerasPedido.FECHA,
                ContratoPedidos.Clientes.NOMBRES,
                ContratoPedidos.Clientes.APELLIDOS,
                ContratoPedidos.FormasPago.NOMBRE};

        return builder.query(db, proyeccion, selection, selectionArgs, null, null, null);
    }

    public String insertarCabeceraPedido(ContratoPedidos.CabecerasPedido pedido){

        SQLiteDatabase db = baseDatos.getWritableDatabase();

        //Generar PK
        String idCabeceraPedido = ContratoPedidos.CabecerasPedido.generarIdCabeceraPedidoString();

        ContentValues valores = new ContentValues();
        valores.put(ContratoPedidos.CabecerasPedido.ID, idCabeceraPedido);
        valores.put(ContratoPedidos.CabecerasPedido.FECHA, pedido.FECHA);
        valores.put(ContratoPedidos.CabecerasPedido.ID_CLIENTE, pedido.ID_CLIENTE);
        valores.put(ContratoPedidos.CabecerasPedido.ID_FORMA_PAGO, pedido.ID_FORMA_PAGO);

        //Insertar cabecera
        db.insertOrThrow(BaseDatosPedidos.Tablas.CABECERA_PEDIDO, null, valores);

        return idCabeceraPedido;
    }

}
