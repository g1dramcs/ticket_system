package com.ticket.ticket_system.repository;

import com.ticket.ticket_system.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}

