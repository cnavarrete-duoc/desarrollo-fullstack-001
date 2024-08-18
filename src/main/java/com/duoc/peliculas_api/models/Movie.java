package com.duoc.peliculas_api.models;

public class Movie {
    private int id;
    private String titulo;
    private String annio;
    private String director;
    private String genero;
    private String sinopsis;

    public Movie() {
    }

    public Movie(int id, String titulo, String annio, String director, String genero, String sinopsis) {
        this.id = id;
        this.titulo = titulo;
        this.annio = annio;
        this.director = director;
        this.genero = genero;
        this.sinopsis = sinopsis;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAnnio() {
        return annio;
    }

    public String getDirector() {
        return director;
    }

    public String getGenero() {
        return genero;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAnnio(String annio) {
        this.annio = annio;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    @Override
    public String toString() {
        return "Pelicula [annio=" + annio + ", director=" + director + ", genero=" + genero + ", id=" + id
                + ", sinopsis="
                + sinopsis + ", titulo=" + titulo + "]";
    }

}
