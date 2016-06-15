package com.app.james.pedidos.modelos;

public class CabeceraPedido {

    public String idCabeceraPedido;

    public String fecha;

    public String idCliente;

    public String idFormaPago;

    public CabeceraPedido(String idCabeceraPedido, String fecha,
                          String idCliente, String idFormaPago) {
        this.idCabeceraPedido = idCabeceraPedido;
        this.fecha = fecha;
        this.idCliente = idCliente;
        this.idFormaPago = idFormaPago;
    }
}
