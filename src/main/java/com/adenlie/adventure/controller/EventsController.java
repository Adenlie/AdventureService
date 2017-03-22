package com.adenlie.adventure.controller;

import com.adenlie.adventure.model.Event;
import com.adenlie.adventure.repository.EventRepository;
import com.adenlie.adventure.service.EventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/events")
@ResponseBody
public class EventsController {
    private final EventsService eventsService;
    private final EventRepository eventRepository;

    @Autowired
    public EventsController(EventsService eventsService, EventRepository eventRepository) {
        this.eventsService = eventsService;
        this.eventRepository = eventRepository;
    }

    @RequestMapping(method = GET)
    @ResponseBody
    public List<Event> getEvents() {
        return eventsService.getEvents();
    }

    @RequestMapping(method = POST)
    public List<Event> createEvents(@RequestBody List<Event> events) {
        return eventsService.createEvents(events);
    }

}
