package org.example.cinema;

public class Ticket {
    private Screening screening;
    private String seat;
    private double price;

    public Ticket(Screening screening, String seat) {
        this.screening = screening;
        this.seat = seat;
        this.price = calculatedPrice();
    }

    private double calculatedPrice(){

        double basicPrice = 33.90;
        if(screening.is3D()) basicPrice += 10.00;
        if(screening.isVIP()) basicPrice += 3.00;

        return basicPrice;
    }


    @Override
    public String toString() {
        return "Ticket for " + screening.getMovie() + " | Seat " + seat + " | " + screening.getDate() +
                " | " + (screening.is3D() ? "3D" : "2D") + " | " + (screening.isVIP() ? "VIP" : "Standard") +
                " | Price: " + price + " PLN";
    }
}
