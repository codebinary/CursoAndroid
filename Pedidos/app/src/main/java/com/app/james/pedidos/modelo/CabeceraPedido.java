package com.app.james.pedidos.modelo;

/**
 * Created by James on 14/06/16.
 */
public class CabeceraPedido {

    private String idCabeceraPedido;
    private String fecha;
    private String idCliente;
    private String idFormaPago;

    public CabeceraPedido(String idCabeceraPedido, String fecha, String idCliente, String idFormaPago) {
        this.idCabeceraPedido = idCabeceraPedido;
        this.fecha = fecha;
        this.idCliente = idCliente;
        this.idFormaPago = idFormaPago;
    }

    public String getIdCabeceraPedido() {
        return idCabeceraPedido;
    }

    public void setIdCabeceraPedido(String idCabeceraPedido) {
        this.idCabeceraPedido = idCabeceraPedido;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getIdFormaPago() {
        return idFormaPago;
    }

    public void setIdFormaPago(String idFormaPago) {
        this.idFormaPago = idFormaPago;
    }
}
