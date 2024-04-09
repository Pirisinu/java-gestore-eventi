package org.experis.gestoreEventi;

import java.time.LocalTime;
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
    public List<Event> getEventsByDate(LocalTime date) {
        List<Event> eventsOnDateSelected = new ArrayList<>();
        for (Event event : events) {
            if (event.getDate().equals(date)) {
                eventsOnDateSelected.add(event);
            }
        }
        return eventsOnDateSelected;
    }
    public int getNumberOfEvents() {
        return events.size();
    }
    public void clearEvents() {
        events.clear();
    }
    public String getFormattedEvents() {
        String formattedEvents = title + "\n";
        for (Event event : events) {
            formattedEvents += event.getDate() + " - " + event.getTitle() + "\n";
        }
        return formattedEvents;
    }

}
