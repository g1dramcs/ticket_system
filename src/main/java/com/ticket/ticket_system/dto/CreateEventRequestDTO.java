package com.ticket.ticket_system.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateEventRequestDTO {
    private String name;
    private LocalDateTime dateTime;
    private String venue;
    private TicketGenerationConfigDTO ticketConfig;
}


