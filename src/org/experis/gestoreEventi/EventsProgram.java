package org.experis.gestoreEventi;

import java.util.ArrayList;
import java.util.List;

public class EventsProgram {
    // Attributes
    public String title;
    public List<Event> events;
    // Constructor

    public EventsProgram(String title) {
        this.title = title;
        this.events = new ArrayList<>();
    }
    // Getter e Setter
    // Methods
    public void addEvent(Event event) {
        events.add(event);
    }
}
