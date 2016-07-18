package com.james.codebinary.appcato.models;

/**
 * Created by codebinary on 12/07/16.
 */
public class Secciones  {

    private String sec_name;
    private int category_id;
    private String category_slug;
    private String category_name;
    private String category_parent;
    private String interna_id;
    private String interna_name;
    private String interna_slug;
    private String interna_parent;
    private String interna_flag;

    public Secciones(){

    }

    public Secciones(String sec_name, String category_name, int category_id) {
        this.sec_name = sec_name;
        this.category_id = category_id;
        this.category_name = category_name;
    }

    public Secciones(String sec_name) {
        this.sec_name = sec_name;
    }



    public String getSec_name() {
        return sec_name;
    }

    public void setSec_name(String sec_name) {
        this.sec_name = sec_name;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCategory_slug() {
        return category_slug;
    }

    public void setCategory_slug(String category_slug) {
        this.category_slug = category_slug;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getCategory_parent() {
        return category_parent;
    }

    public void setCategory_parent(String category_parent) {
        this.category_parent = category_parent;
    }

    public String getInterna_id() {
        return interna_id;
    }

    public void setInterna_id(String interna_id) {
        this.interna_id = interna_id;
    }

    public String getInterna_name() {
        return interna_name;
    }

    public void setInterna_name(String interna_name) {
        this.interna_name = interna_name;
    }

    public String getInterna_slug() {
        return interna_slug;
    }

    public void setInterna_slug(String interna_slug) {
        this.interna_slug = interna_slug;
    }

    public String getInterna_parent() {
        return interna_parent;
    }

    public void setInterna_parent(String interna_parent) {
        this.interna_parent = interna_parent;
    }

    public String getInterna_flag() {
        return interna_flag;
    }

    public void setInterna_flag(String interna_flag) {
        this.interna_flag = interna_flag;
    }

    @Override
    public String toString() {
        return "Secciones{" +
                "sec_name='" + sec_name + '\'' +
                ", category_id='" + category_id + '\'' +
                ", category_slug='" + category_slug + '\'' +
                ", category_name='" + category_name + '\'' +
                ", category_parent='" + category_parent + '\'' +
                ", interna_id='" + interna_id + '\'' +
                ", interna_name='" + interna_name + '\'' +
                ", interna_slug='" + interna_slug + '\'' +
                ", interna_parent='" + interna_parent + '\'' +
                ", interna_flag='" + interna_flag + '\'' +
                '}';
    }
}
