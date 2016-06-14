package com.james.codebinary.trickymarket.modelos;

/**
 * Created by codebinary on 11/06/16.
 */
public class Product {

    private String nombre;
    private String descripcion;
    private String precio;
    private float rating;
    private int idThumbail;

    public Product(){

    }

    public Product(String nombre, String descripcion, String precio, float rating, int idThumbail) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.rating = rating;
        this.idThumbail = idThumbail;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getIdThumbail() {
        return idThumbail;
    }

    public void setIdThumbail(int idThumbail) {
        this.idThumbail = idThumbail;
    }
}
