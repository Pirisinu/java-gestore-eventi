package org.experis.gestoreEventi;

import java.time.LocalDate;

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
}
