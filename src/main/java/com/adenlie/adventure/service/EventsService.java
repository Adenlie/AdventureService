package com.adenlie.adventure.service;

import com.adenlie.adventure.model.Event;
import com.adenlie.adventure.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class EventsService {
    private final EventRepository eventRepository;

    @Autowired
    public EventsService(EventRepository eventRepository) {
        Assert.notNull(eventRepository, "EventRepository should exist");
        this.eventRepository = eventRepository;
    }

    public List<Event> getEvents() {
        return eventRepository.getEvents();
    }

    public List<Event> createEvents(List<Event> events) {
        return eventRepository.saveAll(events);
    }
}
