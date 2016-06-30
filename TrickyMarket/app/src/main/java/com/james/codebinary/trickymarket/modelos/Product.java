package com.james.codebinary.trickymarket.modelos;

/**
 * POJO de un producto
 */
public class Product {
    /**
     * Nombre del producto
     */
    private String nombre;
    /**
     * Especificaciones del producto
     */
    private String descripcion;
    /**
     * Precio del producto
     */
    private String precio;
    /**
     * Valoraciones del producto
     */
    private float rating;
    /**
     * Identificador de la imagen para miniatura
     */
    private int idThumbnail;

    public Product(String nombre, String descripcion, String precio, float rating, int idThumbnail) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.rating = rating;
        this.idThumbnail = idThumbnail;
    }

    public Product() {
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public float getRating() {
        return rating;
    }

    public int getIdThumbnail() {
        return idThumbnail;
    }
}
