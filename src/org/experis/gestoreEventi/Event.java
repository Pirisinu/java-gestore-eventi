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
        if (LocalDate.now().isAfter(date)){
            throw new IllegalArgumentException("Enter a date after than today.");
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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    // Methods
    public boolean reservation(){
        if (reservedSeats < totaltSeats){
            reservedSeats++;
            return true;
        }else return false;
    }
    public boolean cancelReservation(){
        if (reservedSeats > 0){
            reservedSeats--;
            return true;
        }else return false;
    }

    // Methods Overload

    @Override
    public String toString() {
        return "Event{" +
                "title='" + title + '\'' +
                ", date=" + date +
                ", totaltSeats=" + totaltSeats +
                ", reservedSeats=" + reservedSeats +
                '}';
    }
}
