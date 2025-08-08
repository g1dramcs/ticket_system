package com.ticket.ticket_system.service;

import com.ticket.ticket_system.entity.Event;
import com.ticket.ticket_system.entity.Order;
import com.ticket.ticket_system.entity.Ticket;
import com.ticket.ticket_system.entity.User;
import com.ticket.ticket_system.repository.OrderRepository;
import com.ticket.ticket_system.repository.TicketRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {
    private final OrderRepository orderRepository;
    private final TicketRepository ticketRepository;
    private final UserService userService;

    public Order createOrder(Long userId, List<Long> ticketIds, BigDecimal totalAmount) {
        List<Ticket> tickets = ticketRepository.findAllByIdIn(ticketIds);

        if (tickets.size() != ticketIds.size()) {
            throw new IllegalArgumentException("Some tickets not found.");
        }

        for (Ticket ticket : tickets) {
            Event event = ticket.getEvent();
            if (event.getAvailableTickets() <= 0) {
                throw new IllegalStateException("Not enough available tickets for event " + event.getName());
            }
            event.setAvailableTickets(event.getAvailableTickets() - 1);
        }

        User user = userService.getById(userId);

        Order order = new Order();
        order.setUser(user);
        order.setBookingTime(LocalDateTime.now());
        order.setTickets(tickets);

        return orderRepository.save(order);
    }

    public Order getOrderByUserId(Long userId) {
        return orderRepository.findByUserId(userId)
                .orElseThrow(() -> new EntityNotFoundException("Order not found for userId " + userId));
    }
}
