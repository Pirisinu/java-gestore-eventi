package org.experis.gestoreEventi;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concert extends Event{
    // Attributes
    private LocalTime time;
    private BigDecimal price;

    // Constructor
    public Concert(String title, LocalDate date, int totalSeats, LocalTime time, BigDecimal price) {
        super(title, date, totalSeats);
        this.time = time;
        this.price = price;
    }
    // Getter e Setter

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
    // Methods
    public String getFormattedDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return getDate().format(formatter);
    }

    public String getFormattedTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return time.format(formatter);
    }

    public String getFormattedPrice() {
        return String.format("%.2f€", getPrice());
    }
    // Methods Override

    @Override
    public String toString() {
        return getFormattedDate() + " " + getFormattedTime() + " - " + getTitle() + " - " + getFormattedPrice();
    }
}
