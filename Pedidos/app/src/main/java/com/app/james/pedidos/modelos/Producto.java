package com.app.james.pedidos.modelos;


public class Producto {

    public String idProducto;

    public String nombre;

    public float precio;

    public int existencias;

    public Producto(String idProducto, String nombre, float precio, int existencias) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.existencias = existencias;
    }
}
