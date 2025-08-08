package com.ticket.ticket_system.repository;

import com.ticket.ticket_system.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findByUserId(Long userId);
}

