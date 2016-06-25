package com.jcodee.mod2class1.models;

/**
 * Author: johannfjs
 * Date: 28/5/16
 * Time: 10:38
 */
public class Usuario {
    private int id;
    private String usuario, nombreCompleto, correo, contrasenia;

    public Usuario() {
    }

    public Usuario(int id, String usuario, String nombreCompleto, String correo, String contrasenia) {
        this.id = id;
        this.usuario = usuario;
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        this.contrasenia = contrasenia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}
