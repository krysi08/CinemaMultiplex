package org.example.cinema;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Screening {
    private Movie movie;
    private boolean is3D;
    private boolean isVIP;
    private LocalDate date;
    private LocalTime time;
    private List<String> availableSeats = new ArrayList<>();
    private Set<String> reservedSeats = new HashSet<>();

    public Screening(Movie movie, boolean is3D, boolean isVIP, LocalDate date, LocalTime time) {
        this.movie = movie;
        this.is3D = is3D;
        this.isVIP = isVIP;
        this.date = date;
        this.time = time;
    }

    public Screening(Movie movie, LocalDate date, LocalTime time, List<String> seats, boolean is3D, boolean isVIP) {
        this.movie = movie;
        this.date = date;
        this.time = time;
        this.availableSeats.addAll(seats);
        this.is3D = is3D;
        this.isVIP = isVIP;
    }

    public Screening(Movie movie, LocalDate date, LocalTime time, Set<String> reservedSeats) {
        this.movie = movie;
        this.date = date;
        this.time = time;
        this.reservedSeats = new HashSet<>();
    }

    public boolean is3D() {
        return is3D;
    }

    public boolean isVIP() {
        return isVIP;
    }

    public boolean reservedSeat(String seat){
        return reservedSeats.add(seat);
    }

    public Movie getMovie() {
        return movie;
    }

    public LocalDate getDate() {
        return date;
    }

    public void reservePlaces(String... seats) {
        for (String seat : seats) {
            if (availableSeats.contains(seat)) {
                availableSeats.remove(seat);
                System.out.println("Seat " + seat + " booked");
            } else {
                System.out.println("Seat " + seat + " is not available");
            }
        }
    }

    public void reservePlaces(Customer customer, String... seats) {
        reservePlaces(seats);
        customer.addReservation(this, seats);
    }

    @Override
    public String toString() {
        return movie + " | " + date + " " + time + " | Available seats: " + availableSeats.size();
    }
}
