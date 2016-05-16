package com.jcodee.tema02_2.models;

/**
 * Author: johannfjs
 * Date: 7/5/16
 * Time: 12:38
 */
public class Empresa {
    private String empresa, ruc, direccion;

    public Empresa(String empresa, String ruc, String direccion) {
        this.empresa = empresa;
        this.ruc = ruc;
        this.direccion = direccion;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
