package com.ticket.ticket_system.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderRequestDTO {
    private Long userId;
    private List<Long> ticketIds;
    private BigDecimal totalAmount;
}
