package org.example;

import org.example.cinema.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CinemaSystem cinemaSystem = new CinemaSystem();

        Cinema cinema1 = new Cinema("Super Tarasy", "ul. Akademicka 5");
        Cinema cinema2 = new Cinema("Wielkie Cinema", "ul. Skosna 16");

        cinemaSystem.addCinema(cinema1);
        cinemaSystem.addCinema(cinema2);

        Movie movie1 = new Movie("Pulp Fiction", false, false);
        Movie movie2 = new Movie("Titanic", true, true);
        Movie movie3 = new Movie("Agent 007", false, true);

        List<String> seats = List.of("A1", "A2", "A3", "A4","A5", "A6", "A7", "A8", "A9", "B1", "B2","B3","B4","B5","B6","B7","B8","B9");

        Screening screening1 = new Screening(movie1, LocalDate.now(), LocalTime.of(18, 0), Arrays.asList("A1", "A2"),false,false);
        Screening screening2 = new Screening(movie2, LocalDate.now().plusDays(1), LocalTime.of(20, 30), Arrays.asList("B1", "B2"),true,false);
        Screening screening3 = new Screening(movie3, LocalDate.now().minusDays(1), LocalTime.of(19, 0), Arrays.asList("C1", "C2"),false,true);

        cinema1.addScreening(screening1);
        cinema1.addScreening(screening2);
        cinema2.addScreening(screening3);

        cinemaSystem.showAllCinemas();

        cinema1.printProgramme();
        cinema2.printProgramme();

        cinema1.printWeeklyProgramme();
        cinema2.printWeeklyProgramme();

        screening1.reservePlaces("A1", "A2");
        screening2.reservePlaces("B1");

        Customer customer = new Customer("Jan Kowalski","1");
        cinema1.registerCustomer(customer);

        cinema1.buyTicket(customer,screening1,"A4");
        cinema2.buyTicket(customer,screening3,"A7");
        cinema1.buyTicketWithoutAccount(screening1,"A5");

        cinema1.checkCustomerTickets("1");
        cinema1.checkCustomerTickets("2");

        customer.printTickets();
    }
}
