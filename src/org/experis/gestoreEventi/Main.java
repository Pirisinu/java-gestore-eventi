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
                    break;
                case "N":
                    exit = true;
                    break;
            }
        }


    }
}
