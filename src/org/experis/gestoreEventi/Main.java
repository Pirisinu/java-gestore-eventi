package org.experis.gestoreEventi;

import org.experis.gestoreEventi.excetpion.EventException;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the event manager");
        boolean exit = false;
        Scanner scan = new Scanner(System.in);
        EventsProgram eventsProgram = new EventsProgram("Event Program");


        while (!exit) {
            System.out.println("Do you want insert a new event? (Y/N)");
            String response = scan.nextLine();
            switch (response.toUpperCase()) {
                case "Y":
                    Event event = createNewEvent(scan);
                    eventsProgram.addEvent(event);
                    System.out.println(event);
                    boolean makeReservations = true;
                    while (makeReservations) {
                        System.out.println("How many reservations do you want to make?");
                        int numOfReservations = Integer.parseInt(scan.nextLine());
                        int successfulReservations = 0;
                        for (int i = 0; i < numOfReservations; i++) {
                            boolean success = event.reservation();
                            if (success) {
                                successfulReservations++;
                            } else {
                                int remamingSeats = numOfReservations - successfulReservations;
                                System.out.println("No more seats available for reservation.");
                                System.out.println("Reservations not added = " + remamingSeats);
                                break;
                            }
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
                    System.out.println(event);
                    System.out.println("Event reserved seats: "+ event.getReservedSeats());
                    System.out.println("Event remaining places : "+ (event.getTotalSeats() - event.getReservedSeats()));
                    break;
                case "N":
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid input. Please enter 'Y' or 'N'.");
            }
        }
        System.out.println("------------------------------------------");
        System.out.println("Events in the program:");
        System.out.println(eventsProgram.getFormattedEvents());

        System.out.println("Events programmed: " + eventsProgram.getNumberOfEvents());
        System.out.println("Do you want to delete the events? (Y/N)");
        String delete = scan.nextLine();
        if (delete.equalsIgnoreCase("Y")) {
            eventsProgram.clearEvents();
            System.out.println("Events deleted succesfully!");
            System.out.println("Thank you and goodbye!");
        } else if (delete.equalsIgnoreCase("N")) {
            System.out.println("Thank you and goodbye!");

        }

        scan.close();
    }
    public static Event createNewEvent(Scanner scan) {
        String eventName = null;
        LocalDate eventDate = null;
        int eventTotalSeats = 0;

        while (true) {
            try {
                System.out.print("Insert event name: ");
                eventName = scan.nextLine();
                if (eventName.isEmpty()) {
                    throw new EventException("Event name cannot be empty.");
                }

                System.out.print("Insert event year: ");
                int eventYear = Integer.parseInt(scan.nextLine());
                if (eventYear < LocalDate.now().getYear()) {
                    throw new EventException("Year cannot be in the past.");
                }

                System.out.print("Insert event month: ");
                int eventMonth = Integer.parseInt(scan.nextLine());
                if (eventMonth < 1 || eventMonth > 12) {
                    throw new EventException("Invalid month. Please enter a value between 1 and 12.");
                }

                System.out.print("Insert event day: ");
                int eventDay = Integer.parseInt(scan.nextLine());
                if (eventDay < 1 || eventDay > 31) {
                    throw new EventException("Invalid day. Please enter a value between 1 and 31.");
                }

                eventDate = LocalDate.of(eventYear, eventMonth, eventDay);

                System.out.print("Insert event total seats: ");
                eventTotalSeats = Integer.parseInt(scan.nextLine());
                if (eventTotalSeats <= 0) {
                    throw new EventException("Enter a number greater than 0 for total seats.");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input format. Please enter a valid number.");
            } catch (EventException e) {
                System.out.println(e.getMessage());
            }
        }
        return new Event(eventName, eventDate, eventTotalSeats);
    }
}
