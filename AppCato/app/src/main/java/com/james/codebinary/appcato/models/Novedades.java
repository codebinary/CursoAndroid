package com.james.codebinary.appcato.models;

/**
 * Created by James on 28/06/16.
 */
public class Novedades {

    //Atributos
    private String titulo;
    private String descripcion;
    private String rutaImagen;

    public Novedades(){

    }

    public Novedades(String titulo, String descripcion, String rutaImagen) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.rutaImagen = rutaImagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }
}
