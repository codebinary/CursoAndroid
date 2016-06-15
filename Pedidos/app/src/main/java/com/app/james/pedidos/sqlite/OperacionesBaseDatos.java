package com.app.james.pedidos.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.app.james.pedidos.modelos.CabeceraPedido;
import com.app.james.pedidos.modelos.Cliente;
import com.app.james.pedidos.modelos.DetallePedido;
import com.app.james.pedidos.modelos.FormaPago;
import com.app.james.pedidos.modelos.Producto;
import com.app.james.pedidos.modelos.CabeceraPedido;
import com.app.james.pedidos.modelos.Cliente;
import com.app.james.pedidos.modelos.DetallePedido;
import com.app.james.pedidos.modelos.FormaPago;
import com.app.james.pedidos.modelos.Producto;
import com.app.james.pedidos.sqlite.BaseDatosPedidos.Tablas;
import com.app.james.pedidos.sqlite.ContratoPedidos.CabecerasPedido;
import com.app.james.pedidos.sqlite.ContratoPedidos.Clientes;
import com.app.james.pedidos.sqlite.ContratoPedidos.DetallesPedido;
import com.app.james.pedidos.sqlite.ContratoPedidos.FormasPago;
import com.app.james.pedidos.sqlite.ContratoPedidos.Productos;

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

    // [OPERACIONES_CABECERA_PEDIDO]
    public Cursor obtenerCabecerasPedidos() {
        SQLiteDatabase db = baseDatos.getReadableDatabase();

        SQLiteQueryBuilder builder = new SQLiteQueryBuilder();

        builder.setTables(CABECERA_PEDIDO_JOIN_CLIENTE_Y_FORMA_PAGO);

        return builder.query(db, proyCabeceraPedido, null, null, null, null, null);
    }

    public Cursor obtenerCabeceraPorId(String id) {
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

    public String insertarCabeceraPedido(CabeceraPedido pedido) {
        SQLiteDatabase db = baseDatos.getWritableDatabase();

        // Generar Pk
        String idCabeceraPedido = ContratoPedidos.CabecerasPedido.generarIdCabeceraPedido();

        ContentValues valores = new ContentValues();
        valores.put(ContratoPedidos.CabecerasPedido.ID, idCabeceraPedido);
        valores.put(ContratoPedidos.CabecerasPedido.FECHA, pedido.fecha);
        valores.put(ContratoPedidos.CabecerasPedido.ID_CLIENTE, pedido.idCliente);
        valores.put(ContratoPedidos.CabecerasPedido.ID_FORMA_PAGO, pedido.idFormaPago);

        // Insertar cabecera
        db.insertOrThrow(BaseDatosPedidos.Tablas.CABECERA_PEDIDO, null, valores);

        return idCabeceraPedido;
    }

    public boolean actualizarCabeceraPedido(CabeceraPedido pedidoNuevo) {
        SQLiteDatabase db = baseDatos.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(ContratoPedidos.CabecerasPedido.FECHA, pedidoNuevo.fecha);
        valores.put(ContratoPedidos.CabecerasPedido.ID_CLIENTE, pedidoNuevo.idCliente);
        valores.put(ContratoPedidos.CabecerasPedido.ID_FORMA_PAGO, pedidoNuevo.idFormaPago);

        String whereClause = String.format("%s=?", ContratoPedidos.CabecerasPedido.ID);
        String[] whereArgs = {pedidoNuevo.idCabeceraPedido};

        int resultado = db.update(BaseDatosPedidos.Tablas.CABECERA_PEDIDO, valores, whereClause, whereArgs);

        return resultado > 0;
    }

    public boolean eliminarCabeceraPedido(String idCabeceraPedido) {
        SQLiteDatabase db = baseDatos.getWritableDatabase();

        String whereClause = ContratoPedidos.CabecerasPedido.ID + "=?";
        String[] whereArgs = {idCabeceraPedido};

        int resultado = db.delete(BaseDatosPedidos.Tablas.CABECERA_PEDIDO, whereClause, whereArgs);

        return resultado > 0;
    }
    // [/OPERACIONES_CABECERA_PEDIDO]

    // [OPERACIONES_DETALLE_PEDIDO]
    public Cursor obtenerDetallesPedido() {
        SQLiteDatabase db = baseDatos.getReadableDatabase();

        String sql = String.format("SELECT * FROM %s", BaseDatosPedidos.Tablas.DETALLE_PEDIDO);

        return db.rawQuery(sql, null);
    }

    public Cursor obtenerDetallesPorIdPedido(String idCabeceraPedido) {
        SQLiteDatabase db = baseDatos.getReadableDatabase();

        String sql = String.format("SELECT * FROM %s WHERE %s=?",
                BaseDatosPedidos.Tablas.DETALLE_PEDIDO, ContratoPedidos.CabecerasPedido.ID);

        String[] selectionArgs = {idCabeceraPedido};

        return db.rawQuery(sql, selectionArgs);

    }

    public String insertarDetallePedido(DetallePedido detalle) {
        SQLiteDatabase db = baseDatos.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(ContratoPedidos.DetallesPedido.ID, detalle.idCabeceraPedido);
        valores.put(ContratoPedidos.DetallesPedido.SECUENCIA, detalle.secuencia);
        valores.put(ContratoPedidos.DetallesPedido.ID_PRODUCTO, detalle.idProducto);
        valores.put(ContratoPedidos.DetallesPedido.CANTIDAD, detalle.cantidad);
        valores.put(ContratoPedidos.DetallesPedido.PRECIO, detalle.precio);

        db.insertOrThrow(BaseDatosPedidos.Tablas.DETALLE_PEDIDO, null, valores);

        return String.format("%s#%d", detalle.idCabeceraPedido, detalle.secuencia);

    }

    public boolean actualizarDetallePedido(DetallePedido detalle) {
        SQLiteDatabase db = baseDatos.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(ContratoPedidos.DetallesPedido.SECUENCIA, detalle.secuencia);
        valores.put(ContratoPedidos.DetallesPedido.CANTIDAD, detalle.cantidad);
        valores.put(ContratoPedidos.DetallesPedido.PRECIO, detalle.precio);

        String selection = String.format("%s=? AND %s=?",
                ContratoPedidos.DetallesPedido.ID, ContratoPedidos.DetallesPedido.SECUENCIA);
        final String[] whereArgs = {detalle.idCabeceraPedido, String.valueOf(detalle.secuencia)};

        int resultado = db.update(BaseDatosPedidos.Tablas.DETALLE_PEDIDO, valores, selection, whereArgs);

        return resultado > 0;
    }

    public boolean eliminarDetallePedido(String idCabeceraPedido, int secuencia) {
        SQLiteDatabase db = baseDatos.getWritableDatabase();

        String selection = String.format("%s=? AND %s=?",
                ContratoPedidos.DetallesPedido.ID, ContratoPedidos.DetallesPedido.SECUENCIA);
        String[] whereArgs = {idCabeceraPedido, String.valueOf(secuencia)};

        int resultado = db.delete(BaseDatosPedidos.Tablas.DETALLE_PEDIDO, selection, whereArgs);

        return resultado > 0;
    }
    // [/OPERACIONES_DETALLE_PEDIDO]

    // [OPERACIONES_PRODUCTO]
    public Cursor obtenerProductos() {
        SQLiteDatabase db = baseDatos.getReadableDatabase();

        String sql = String.format("SELECT * FROM %s", BaseDatosPedidos.Tablas.PRODUCTO);

        return db.rawQuery(sql, null);
    }

    public String insertarProducto(Producto producto) {
        SQLiteDatabase db = baseDatos.getWritableDatabase();

        ContentValues valores = new ContentValues();
        // Generar Pk
        String idProducto = ContratoPedidos.Productos.generarIdProducto();
        valores.put(ContratoPedidos.Productos.ID, idProducto);
        valores.put(ContratoPedidos.Productos.NOMBRE, producto.nombre);
        valores.put(ContratoPedidos.Productos.PRECIO, producto.precio);
        valores.put(ContratoPedidos.Productos.EXISTENCIAS, producto.existencias);

        db.insertOrThrow(BaseDatosPedidos.Tablas.PRODUCTO, null, valores);

        return idProducto;

    }

    public boolean actualizarProducto(Producto producto) {
        SQLiteDatabase db = baseDatos.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(ContratoPedidos.Productos.NOMBRE, producto.nombre);
        valores.put(ContratoPedidos.Productos.PRECIO, producto.precio);
        valores.put(ContratoPedidos.Productos.EXISTENCIAS, producto.existencias);

        String whereClause = String.format("%s=?", ContratoPedidos.Productos.ID);
        String[] whereArgs = {producto.idProducto};

        int resultado = db.update(BaseDatosPedidos.Tablas.PRODUCTO, valores, whereClause, whereArgs);

        return resultado > 0;
    }

    public boolean eliminarProducto(String idProducto) {
        SQLiteDatabase db = baseDatos.getWritableDatabase();

        String whereClause = String.format("%s=?", ContratoPedidos.Productos.ID);
        String[] whereArgs = {idProducto};

        int resultado = db.delete(BaseDatosPedidos.Tablas.PRODUCTO, whereClause, whereArgs);

        return resultado > 0;
    }
    // [/OPERACIONES_PRODUCTO]

    // [OPERACIONES_CLIENTE]
    public Cursor obtenerClientes() {
        SQLiteDatabase db = baseDatos.getReadableDatabase();

        String sql = String.format("SELECT * FROM %s", BaseDatosPedidos.Tablas.CLIENTE);

        return db.rawQuery(sql, null);
    }

    public String insertarCliente(Cliente cliente) {
        SQLiteDatabase db = baseDatos.getWritableDatabase();

        // Generar Pk
        String idCliente = ContratoPedidos.Clientes.generarIdCliente();

        ContentValues valores = new ContentValues();
        valores.put(ContratoPedidos.Clientes.ID, idCliente);
        valores.put(ContratoPedidos.Clientes.NOMBRES, cliente.nombres);
        valores.put(ContratoPedidos.Clientes.APELLIDOS, cliente.apellidos);
        valores.put(ContratoPedidos.Clientes.TELEFONO, cliente.telefono);

        return db.insertOrThrow(BaseDatosPedidos.Tablas.CLIENTE, null, valores) > 0 ? idCliente : null;
    }

    public boolean actualizarCliente(Cliente cliente) {
        SQLiteDatabase db = baseDatos.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(ContratoPedidos.Clientes.NOMBRES, cliente.nombres);
        valores.put(ContratoPedidos.Clientes.APELLIDOS, cliente.apellidos);
        valores.put(ContratoPedidos.Clientes.TELEFONO, cliente.telefono);

        String whereClause = String.format("%s=?", ContratoPedidos.Clientes.ID);
        final String[] whereArgs = {cliente.idCliente};

        int resultado = db.update(BaseDatosPedidos.Tablas.CLIENTE, valores, whereClause, whereArgs);

        return resultado > 0;
    }

    public boolean eliminarCliente(String idCliente) {
        SQLiteDatabase db = baseDatos.getWritableDatabase();

        String whereClause = String.format("%s=?", ContratoPedidos.Clientes.ID);
        final String[] whereArgs = {idCliente};

        int resultado = db.delete(BaseDatosPedidos.Tablas.CLIENTE, whereClause, whereArgs);

        return resultado > 0;
    }
    // [/OPERACIONES_CLIENTE]

    // [OPERACIONES_FORMA_PAGO]
    public Cursor obtenerFormasPago() {
        SQLiteDatabase db = baseDatos.getReadableDatabase();

        String sql = String.format("SELECT * FROM %s", BaseDatosPedidos.Tablas.FORMA_PAGO);

        return db.rawQuery(sql, null);
    }

    public String insertarFormaPago(FormaPago formaPago) {
        SQLiteDatabase db = baseDatos.getWritableDatabase();

        // Generar Pk
        String idFormaPago = ContratoPedidos.FormasPago.generarIdFormaPago();

        ContentValues valores = new ContentValues();
        valores.put(ContratoPedidos.FormasPago.ID, idFormaPago);
        valores.put(ContratoPedidos.FormasPago.NOMBRE, formaPago.nombre);

        return db.insertOrThrow(BaseDatosPedidos.Tablas.FORMA_PAGO, null, valores) > 0 ? idFormaPago : null;
    }

    public boolean actualizarFormaPago(FormaPago formaPago) {
        SQLiteDatabase db = baseDatos.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(ContratoPedidos.FormasPago.NOMBRE, formaPago.nombre);

        String whereClause = String.format("%s=?", ContratoPedidos.FormasPago.ID);
        String[] whereArgs = {formaPago.idFormaPago};

        int resultado = db.update(BaseDatosPedidos.Tablas.FORMA_PAGO, valores, whereClause, whereArgs);

        return resultado > 0;
    }

    public boolean eliminarFormaPago(String idFormaPago) {
        SQLiteDatabase db = baseDatos.getWritableDatabase();

        String whereClause = String.format("%s=?", ContratoPedidos.FormasPago.ID);
        String[] whereArgs = {idFormaPago};

        int resultado = db.delete(BaseDatosPedidos.Tablas.FORMA_PAGO, whereClause, whereArgs);

        return resultado > 0;
    }

    public SQLiteDatabase getDb() {
        return baseDatos.getWritableDatabase();
    }


    // [/OPERACIONES_FORMA_PAGO]


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

}
