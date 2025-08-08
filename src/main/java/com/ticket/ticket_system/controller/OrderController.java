package com.ticket.ticket_system.controller;

import com.ticket.ticket_system.dto.OrderRequestDTO;
import com.ticket.ticket_system.entity.Order;
import com.ticket.ticket_system.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/order")
    public ResponseEntity<Order> createOrder(@RequestBody OrderRequestDTO dto) {
        Order order = orderService.createOrder(dto.getUserId(), dto.getTicketIds(), dto.getTotalAmount());
        return ResponseEntity.ok(order);
    }

    @GetMapping("/users/{userId}/order")
    public ResponseEntity<Order> getUserOrder(@PathVariable Long userId) {
        Order order = orderService.getOrderByUserId(userId);
        return ResponseEntity.ok(order);
    }
}

