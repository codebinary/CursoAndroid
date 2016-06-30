package com.james.codebinary.appcato.models;

/**
 * Created by James on 30/06/16.
 */
public class Pais {

    private int pais_id;
    private String pais_nombre;

    public Pais(){

    }

    public Pais(int pais_id, String pais_nombre) {
        this.pais_id = pais_id;
        this.pais_nombre = pais_nombre;
    }

    public int getPais_id() {
        return pais_id;
    }

    public void setPais_id(int pais_id) {
        this.pais_id = pais_id;
    }

    public String getPais_nombre() {
        return pais_nombre;
    }

    public void setPais_nombre(String pais_nombre) {
        this.pais_nombre = pais_nombre;
    }

    @Override
    public String toString() {
        return "Pais{" +
                "pais_id=" + pais_id +
                ", pais_nombre='" + pais_nombre + '\'' +
                '}';
    }
}
