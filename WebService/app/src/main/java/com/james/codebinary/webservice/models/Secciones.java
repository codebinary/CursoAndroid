package com.james.codebinary.webservice.models;

/**
 * Created by codebinary on 02/06/16.
 */
public class Secciones {

    private String sec_name;
    private int sec_items;

    public Secciones(){

    }

    public Secciones(String sec_name, int sec_items) {
        this.sec_name = sec_name;
        this.sec_items = sec_items;
    }

    public String getSec_name() {
        return sec_name;
    }

    public void setSec_name(String sec_name) {
        this.sec_name = sec_name;
    }

    public int getSec_items() {
        return sec_items;
    }

    public void setSec_items(int sec_items) {
        this.sec_items = sec_items;
    }
}
