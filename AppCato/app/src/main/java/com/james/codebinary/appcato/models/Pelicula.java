package com.james.codebinary.appcato.models;

/**
 * Created by James on 01/07/16.
 */
public class Pelicula {

    private int pelicula_id;
    private String pelicula_titulo;
    private String pelicula_thumbnail;
    private String pelicula_director;
    private String pelicula_excerpt;

    public Pelicula(){

    }

    public Pelicula(int pelicula_id, String pelicula_titulo, String pelicula_thumbnail, String pelicula_director, String pelicula_excerpt) {
        this.pelicula_id = pelicula_id;
        this.pelicula_titulo = pelicula_titulo;
        this.pelicula_thumbnail = pelicula_thumbnail;
        this.pelicula_director = pelicula_director;
        this.pelicula_excerpt = pelicula_excerpt;
    }

    public int getPelicula_id() {
        return pelicula_id;
    }

    public void setPelicula_id(int pelicula_id) {
        this.pelicula_id = pelicula_id;
    }

    public String getPelicula_titulo() {
        return pelicula_titulo;
    }

    public void setPelicula_titulo(String pelicula_titulo) {
        this.pelicula_titulo = pelicula_titulo;
    }

    public String getPelicula_thumbnail() {
        return pelicula_thumbnail;
    }

    public void setPelicula_thumbnail(String pelicula_thumbnail) {
        this.pelicula_thumbnail = pelicula_thumbnail;
    }

    public String getPelicula_director() {
        return pelicula_director;
    }

    public void setPelicula_director(String pelicula_director) {
        this.pelicula_director = pelicula_director;
    }

    public String getPelicula_excerpt() {
        return pelicula_excerpt;
    }

    public void setPelicula_excerpt(String pelicula_excerpt) {
        this.pelicula_excerpt = pelicula_excerpt;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "pelicula_id=" + pelicula_id +
                ", pelicula_titulo='" + pelicula_titulo + '\'' +
                ", pelicula_thumbnail='" + pelicula_thumbnail + '\'' +
                ", pelicula_director='" + pelicula_director + '\'' +
                ", pelicula_excerpt='" + pelicula_excerpt + '\'' +
                '}';
    }
}
