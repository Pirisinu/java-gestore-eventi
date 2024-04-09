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

        while (!exit) {
            System.out.println("Do you want insert a new event? (Y/N)");
            String response = scan.nextLine();
            switch (response.toUpperCase()) {
                case "Y":
                    Event event = createNewEvent(scan);
                    System.out.println(event);
                    boolean makeReservations = true;
                    while (makeReservations) {
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
                        String moreReservations = scan.nextLine();
                        if (!moreReservations.equalsIgnoreCase("Y")) {
                            makeReservations = false;
                            boolean deleteReservations = true;
                            while (deleteReservations) {
                                System.out.println("Do you want to delete some reservations for this event? (Y/N)");
                                String deleteReservation = scan.nextLine();
                                if (deleteReservation.equalsIgnoreCase("Y")) {
                                    System.out.println("How many reservations do you want to delete?");
                                    int deleteCount = Integer.parseInt(scan.nextLine());
                                    int successfulDeleteReservations = 0;
                                    if (deleteCount <= event.getReservedSeats()) {
                                        for (int i = 0; i < deleteCount; i++) {
                                            boolean success = event.cancelReservation();
                                            if (success) {
                                                successfulDeleteReservations++;
                                            } else {
                                                System.out.println("No more reservations to cancel.");
                                                break;
                                            }
                                        }
                                        System.out.println("Cancelled " + successfulDeleteReservations + " reservations.");
                                    } else {
                                        System.out.println("The number of reservations to cancel exceeds the number of reservations made.");
                                    }
                                } else {
                                    deleteReservations = false;
                                }
                            }
                        }
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
