package com.example.domain;

public class Artist extends Person {

    // referintele sunt initializate cu null
    private String genre;

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Artist(int id, String name, String genre) {
        super(id, name);
        this.genre = genre;
    }

    @Override
    public String toString() {
        return Integer.toString(getId()) + " - " + getName() + " - " + getGenre();
    }
}
