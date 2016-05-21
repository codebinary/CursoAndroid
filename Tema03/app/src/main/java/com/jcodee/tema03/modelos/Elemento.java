package com.jcodee.tema03.modelos;

/**
 * Author: johannfjs
 * Date: 14/5/16
 * Time: 10:11
 */
public class Elemento {
    private int id;
    private String rutaImagen, descripcion;

    public Elemento(int id, String rutaImagen, String descripcion) {
        this.id = id;
        this.rutaImagen = rutaImagen;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
