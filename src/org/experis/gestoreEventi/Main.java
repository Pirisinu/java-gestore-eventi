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
                    do {
                        System.out.println("How many reservations do you want to make?");
                        int numOfReservations = Integer.parseInt(scan.nextLine());
                        int successfulReservations = 0;
                        if (numOfReservations <= (event.getTotalSeats() - event.getReservedSeats())) {
                            for (int i = 0; i < numOfReservations; i++) {
                                boolean success = event.reservation();
                                if (success) {
                                    successfulReservations++;
                                } else {
                                    System.out.println("No more seats available for reservation.");
                                    break;
                                }
                            }
                        } else {
                            System.out.println("The number of reservations exceeds the available seats.");
                        }
                        System.out.println("Added " + successfulReservations + " reservations.");
                        System.out.println("Available seats: " + (event.getTotalSeats() - event.getReservedSeats()));
                        System.out.println("Do you want to make more reservations for this event? (Y/N)");
                        response = scan.nextLine();
                    } while (response.equalsIgnoreCase("Y"));
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
