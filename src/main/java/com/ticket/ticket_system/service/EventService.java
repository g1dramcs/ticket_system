package com.ticket.ticket_system.service;

import com.ticket.ticket_system.dto.CreateEventRequestDTO;
import com.ticket.ticket_system.dto.TicketGenerationConfigDTO;
import com.ticket.ticket_system.entity.Event;
import com.ticket.ticket_system.entity.Ticket;
import com.ticket.ticket_system.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepository eventRepository;

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event createEventWithGeneratedTickets(CreateEventRequestDTO dto) {
        Event event = new Event();
        event.setName(dto.getName());
        event.setDateTime(dto.getDateTime());
        event.setVenue(dto.getVenue());

        TicketGenerationConfigDTO config = dto.getTicketConfig();
        List<Ticket> generatedTickets = new ArrayList<>();

        for (int row = 1; row <= config.getRows(); row++) {
            for (int seat = 1; seat <= config.getSeatsPerRow(); seat++) {
                Ticket ticket = new Ticket();
                ticket.setSector(config.getSector());
                ticket.setRowNumber(String.valueOf(row));
                ticket.setSeatNumber(String.valueOf(seat));
                ticket.setPrice(config.getPrice());
                ticket.setDateTime(config.getDateTime());
                ticket.setEvent(event);
                generatedTickets.add(ticket);
            }
        }

        event.setTotalTickets(generatedTickets.size());
        event.setAvailableTickets(generatedTickets.size());
        event.setTickets(generatedTickets);

        return eventRepository.save(event);
    }



}

