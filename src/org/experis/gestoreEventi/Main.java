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
            System.out.println("Do you want insert a new event?");
            String response = scan.nextLine();
            switch (response.toUpperCase()){
                case "Y":
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

                    Event event = new Event(eventName, LocalDate.of(eventYear,eventMonth,eventDay), eventTotalSeats);
                    System.out.println(event);
                    break;
                case "N":
                    exit = true;
                    break;
            }
        }


    }
}
