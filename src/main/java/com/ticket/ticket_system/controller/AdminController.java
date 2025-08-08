package com.ticket.ticket_system.controller;

import com.ticket.ticket_system.dto.CreateEventRequestDTO;
import com.ticket.ticket_system.entity.Event;
import com.ticket.ticket_system.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {
    private final EventService eventService;

    @PostMapping("/event")
    public ResponseEntity<Event> createEvent(@RequestBody CreateEventRequestDTO dto) {
        Event saved = eventService.createEventWithGeneratedTickets(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}

