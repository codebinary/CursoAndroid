package com.app.james.pedidos.modelo;

/**
 * Created by James on 14/06/16.
 */
public class FormaPago {

    public String idFormaPago;

    public String nombre;

    public FormaPago(String idFormaPago, String nombre) {
        this.idFormaPago = idFormaPago;
        this.nombre = nombre;
    }

    public String getIdFormaPago() {
        return idFormaPago;
    }

    public void setIdFormaPago(String idFormaPago) {
        this.idFormaPago = idFormaPago;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
