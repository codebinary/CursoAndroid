package com.jcodee.claserecycler.modelos;

/**
 * Author: johannfjs
 * Date: 11/6/16
 * Time: 10:16
 */
public class Datos {
    private int id;
    private String nombre, apellido, carrera, rutaImagen;

    public Datos() {
    }

    public Datos(int id, String nombre, String apellido, String carrera, String rutaImagen) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.carrera = carrera;
        this.rutaImagen = rutaImagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }
}
