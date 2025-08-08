package com.ticket.ticket_system.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class TicketGenerationConfigDTO {
    private String sector;
    private int rows;
    private int seatsPerRow;
    private BigDecimal price;
    private LocalDateTime dateTime;
}

