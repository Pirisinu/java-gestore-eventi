package org.experis.gestoreEventi;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the event manager");
        boolean exit = false;
        Scanner scan = new Scanner(System.in);
//        //Test
//        Event event = new Event("pippo", LocalDate.of(2025,10,10),-10);
//        System.out.println(event);

        while (!exit){
            System.out.println("Do you want insert a new event? (Y/N)");
            String response = scan.nextLine();
            switch (response.toUpperCase()){
                case "Y":
                    Event event = createNewEvent(scan);
                    System.out.println(event);
                    System.out.println("How many reservations do you want to make?");
                    int numOfReservations = Integer.parseInt(scan.nextLine());
                    if (numOfReservations <= (event.getTotalSeats() - event.getReservedSeats())) {
                        System.out.println("adding");
                    } else {
                        System.out.println("The number of reservations exceeds the available seats.");
                    }
                    break;
                case "N":
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid input. Please enter 'Y' or 'N'.");
            }
        }

        scan.close();
    }
    public static Event createNewEvent(Scanner scan) {
        try {
            Event event = Event.createEvent(scan);
            System.out.println("New event created: " + event);
            return event;
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating event: " + e.getMessage());
        }
        return null;
    }
}
