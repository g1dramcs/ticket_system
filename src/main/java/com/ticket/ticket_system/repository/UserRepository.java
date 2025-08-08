package com.ticket.ticket_system.repository;

import com.ticket.ticket_system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

