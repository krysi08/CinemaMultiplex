package org.example.cinema;

import java.util.ArrayList;
import java.util.List;

public class CinemaSystem {
    private List<Cinema> cinemas = new ArrayList<>();

    public void addCinema(Cinema cinema) {
        cinemas.add(cinema);
    }

    public void showAllCinemas() {
        System.out.println("Available cinemas:");
        for (Cinema cinema : cinemas) {
            System.out.println(cinema.getName() + " - " + cinema.getAddress());
        }
    }

    public Cinema findCinema(String name) {
        return cinemas.stream()
                .filter(cinema -> cinema.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
}
