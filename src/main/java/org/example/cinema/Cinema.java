package org.example.cinema;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cinema {
    private String name;
    private String address;
    private List<Screening> screenings = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();

    public Cinema(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public void addScreening(Screening screening) {
        screenings.add(screening);
    }

    public void registerCustomer(Customer customer){

        customers.add(customer);
    }

    public void buyTicket(Customer customer, Screening screening, String seat) {
        if (screening.getDate().isBefore(LocalDate.now())) {
            System.out.println("You can't buy ticket for past movies!");
            return;
        }
        if (screening.reservedSeat(seat)) {
            Ticket ticket = new Ticket(screening, seat);
            customer.addTicket(ticket);
            System.out.println("Ticket was bought by: " + customer.getId() + " on seat: " + seat);
        } else {
            System.out.println("Seat: " + seat + " is not available!");
        }
    }

    public void buyTicketWithoutAccount(Screening screening, String seat) {
        if (screening.getDate().isBefore(LocalDate.now())) {
            System.out.println("You can't buy ticket for past movies!");
            return;
        }
        if (screening.reservedSeat(seat)) {
            System.out.println("Ticket for: " + screening.getMovie() + " seat: " + seat + " bought without account");
        } else {
            System.out.println("Seat " + seat + " is not available!");
        }
    }

    public void checkCustomerTickets(String customerId) {
        for (Customer customer : customers) {
            if (customer.getId().equals(customerId)) {
                customer.printTickets();
                return;
            }
        }
        System.out.println("Customer ID " + customerId + " doesn't exist");
    }

    public List<Screening> getScreeningsForNextWeek() {
        LocalDate today = LocalDate.now();
        LocalDate nextWeek = today.plusDays(7);
        List<Screening> upcomingScreenings = new ArrayList<>();
        for (Screening s : screenings) {
            if (!s.getDate().isBefore(today) && !s.getDate().isAfter(nextWeek)) {
                upcomingScreenings.add(s);
            }
        }
        return upcomingScreenings;
    }

    public void printProgramme() {
        System.out.println("Programme cinema " + name + ":");
        for (Screening s : screenings) {
            System.out.println(s);
        }
    }

    public Screening[] getScreenings() {
        return screenings.toArray(new Screening[0]);
    }

    public void printWeeklyProgramme() {
        LocalDate today = LocalDate.now();
        LocalDate nextWeek = today.plusDays(7);

        System.out.println("Programme cinema" + name + "for closest week");

        for (Screening s : screenings){

            if (!s.getDate().isBefore(today) && !s.getDate().isAfter(nextWeek)) {
                System.out.println(s);
            }
        }
    }

    public Movie findMovie(String title) {
        for (Screening screening : screenings) {
            if (screening.getMovie().getTitle().equalsIgnoreCase(title)) {
                return screening.getMovie();
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
