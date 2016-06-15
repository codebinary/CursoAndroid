package com.app.james.pedidos.modelos;

public class Cliente {

    public String idCliente;

    public String nombres;

    public String apellidos;

    public String telefono;

    public Cliente(String idCliente, String nombres, String apellidos, String telefono) {
        this.idCliente = idCliente;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
    }
}
