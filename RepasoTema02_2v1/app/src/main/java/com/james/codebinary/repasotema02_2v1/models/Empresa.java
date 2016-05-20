package com.james.codebinary.repasotema02_2v1.models;

/**
 * Created by codebinary on 18/05/16.
 */
public class Empresa {

    private String empresa, ruc, direccion;

    public Empresa(){

    }

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
