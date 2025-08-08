package com.ticket.ticket_system.repository;

import java.util.List;
import com.ticket.ticket_system.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findAllByIdIn(List<Long> ids);
}


