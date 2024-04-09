package org.experis.gestoreEventi;

import org.experis.gestoreEventi.excetpion.EventException;

import java.time.LocalDate;
import java.util.Scanner;

public class Event {
    // Attributes
    private String title;
    private LocalDate date;
    private int totalSeats, reservedSeats;

    // Constructor
    public Event(String title, LocalDate date, int totalSeats) {
        this.title = title;
        if (LocalDate.now().isAfter(date)){
            throw new EventException("Enter a date after than today.");
        } else this.date = date;

        if (totalSeats < 0){
            throw new EventException("Enter a number greater than 0");
        } else this.totalSeats = totalSeats;
        this.reservedSeats = 0;
    }
    // Getter

    public String getTitle() {
        return title;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getTotalSeats() {
        return totalSeats;
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
        if (reservedSeats < totalSeats){
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

    public static Event createEvent(Scanner scan){
        try {
            System.out.print("Insert event name: ");
            String eventName = scan.nextLine();
            System.out.print("Insert event year: ");
            int eventYear = Integer.parseInt(scan.nextLine());
            System.out.print("Insert event month: ");
            int eventMonth = Integer.parseInt(scan.nextLine());
            System.out.print("Insert event day: ");
            int eventDay = Integer.parseInt(scan.nextLine());
            System.out.print("Insert event total seats: ");
            int eventTotalSeats = Integer.parseInt(scan.nextLine());

            LocalDate eventDate = LocalDate.of(eventYear, eventMonth, eventDay);
            return new Event(eventName, eventDate, eventTotalSeats);
        } catch (NumberFormatException e) {
            throw new EventException("Invalid input format for date or total seats.");
        }
    }

    // Methods Overload


    @Override
    public String toString() {
        return "Event{" +
                "title='" + title + '\'' +
                ", date=" + date +
                ", totalSeats=" + totalSeats +
                ", reservedSeats=" + reservedSeats +
                '}';
    }
}
