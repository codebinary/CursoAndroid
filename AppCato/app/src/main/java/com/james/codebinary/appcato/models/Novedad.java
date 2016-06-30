package com.james.codebinary.appcato.models;

/**
 * Created by James on 28/06/16.
 */
public class Novedad {

    //Atributos
    private int post_id;
    private String post_title;
    private String post_thumbnail;
    private String post_excerpt;
    private String post_date;


    public Novedad(){

    }

    public Novedad(int post_id, String post_title, String post_thumbnail, String post_excerpt, String post_date) {
        this.post_id = post_id;
        this.post_title = post_title;
        this.post_thumbnail = post_thumbnail;
        this.post_excerpt = post_excerpt;
        this.post_date = post_date;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public String getPost_title() {
        return post_title;
    }

    public void setPost_title(String post_title) {
        this.post_title = post_title;
    }

    public String getPost_thumbnail() {
        return post_thumbnail;
    }

    public void setPost_thumbnail(String post_thumbnail) {
        this.post_thumbnail = post_thumbnail;
    }

    public String getPost_excerpt() {
        return post_excerpt;
    }

    public void setPost_excerpt(String post_excerpt) {
        this.post_excerpt = post_excerpt;
    }

    public String getPost_date() {
        return post_date;
    }

    public void setPost_date(String post_date) {
        this.post_date = post_date;
    }
}
