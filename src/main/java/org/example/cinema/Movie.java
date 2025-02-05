package org.example.cinema;

public class Movie {
    private String title;

    public Movie(String title, boolean is3D, boolean isVIP) {
        this.title = title;

    }
    public Movie(String title) {
        this.title = title;
    }


    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title;
    }
}
