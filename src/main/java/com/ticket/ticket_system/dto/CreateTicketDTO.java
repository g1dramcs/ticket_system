package com.ticket.ticket_system.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class CreateTicketDTO {
    private String sector;
    private String rowNumber;
    private String seatNumber;
    private BigDecimal price;
    private LocalDateTime dateTime;
}

