package com.app.james.pedidos.modelo;

/**
 * Created by James on 14/06/16.
 */
public class DetallePedido {

    public String idCabeceraPedido;

    public int secuencia;

    public String idProducto;

    public int cantidad;

    public float precio;

    public DetallePedido(String idCabeceraPedido, int secuencia, String idProducto, int cantidad, float precio) {
        this.idCabeceraPedido = idCabeceraPedido;
        this.secuencia = secuencia;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getIdCabeceraPedido() {
        return idCabeceraPedido;
    }

    public void setIdCabeceraPedido(String idCabeceraPedido) {
        this.idCabeceraPedido = idCabeceraPedido;
    }

    public int getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(int secuencia) {
        this.secuencia = secuencia;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}
