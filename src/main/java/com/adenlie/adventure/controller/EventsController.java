package com.adenlie.adventure.controller;

import com.adenlie.adventure.model.Event;
import com.adenlie.adventure.service.EventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("/events")
@ResponseBody
public class EventsController {
    private final EventsService eventsService;

    @Autowired
    public EventsController(EventsService eventsService) {
        this.eventsService = eventsService;
    }

    @RequestMapping(method = GET)
    @ResponseBody
    public List<Event> getEvents() {
        return eventsService.getEvents();
    }

}
