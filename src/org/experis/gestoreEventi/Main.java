package org.experis.gestoreEventi;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the event manager");

        //Test
        Event event = new Event("pippo", LocalDate.of(2025,10,10),-10);
        System.out.println(event);
    }
}
