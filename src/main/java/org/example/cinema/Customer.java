package org.example.cinema;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String id;
    private String name;
    private List<Ticket> tickets = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public Customer(String name, String id) {
        this.name = name;
        this.id = id;
        this.tickets = new ArrayList<>();
    }

    public void addReservation(Screening screening, String... seats) {
        for (String seat : seats) {
            tickets.add(new Ticket(screening, seat));
        }
    }

    public void printTickets() {
        if (tickets.isEmpty()) {
            System.out.println(name + " Run out of available tickets");
        } else {
            System.out.println("Customer ticket: " + name);
            for (Ticket ticket : tickets) {
                System.out.println(ticket);
            }
        }
    }
}
