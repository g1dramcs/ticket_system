package com.ticket.ticket_system.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sector;
    private String rowNumber;
    private String seatNumber;
    private BigDecimal price;
    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @ManyToMany(mappedBy = "tickets")
    private List<Order> orders = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getSector() {
        return sector;
    }

    public String getRowNumber() {
        return rowNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Event getEvent() {
        return event;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRowNumber(String rowNumber) {
        this.rowNumber = rowNumber;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}

