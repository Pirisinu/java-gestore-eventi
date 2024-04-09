package org.experis.gestoreEventi;

import java.time.LocalDate;

public class Event {
    // Attributes
    String title;
    LocalDate date;
    int totaltSeats, reservedSeats;

    // Constructor
    // TODO change Exception
    public Event(String title, LocalDate date, int totaltSeats) {
        this.title = title;
        if (LocalDate.now().isBefore(date)){
            throw new IllegalArgumentException("Enter a date later than today.");
        } else this.date = date;

        if (totaltSeats < 0){
            throw new IllegalArgumentException("Enter a number greater than 0");
        } else this.reservedSeats = 0;
    }
    // Getter

    public String getTitle() {
        return title;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getTotaltSeats() {
        return totaltSeats;
    }

    public int getReservedSeats() {
        return reservedSeats;
    }

    // Setter

    // Methods
}
