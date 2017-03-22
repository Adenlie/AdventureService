package com.adenlie.adventure.controller;

import com.adenlie.adventure.model.Event;
import com.adenlie.adventure.service.EventsService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static java.util.Collections.singletonList;
import static org.codehaus.groovy.runtime.InvokerHelper.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EventsControllerTest {
    @InjectMocks
    private EventsController eventsController;

    @Mock
    private EventsService eventsService;
    private Event event;

    @Before
    public void setUp() throws Exception {
        event = Event.builder().eventId("2017MNR1").build();
    }

    @Test
    public void addEvent() throws Exception {
        List events = asList(event);
        eventsController.createEvents(events);
        verify(eventsService).createEvents(events);
    }

    @Test
    public void shouldGetEvents() throws Exception {
        List<Event> expectedEvents = singletonList(event);
        when(eventsService.getEvents()).thenReturn(expectedEvents);
        List<Event> actualEvents = eventsController.getEvents();

        verify(eventsService).getEvents();
        assertThat(actualEvents, is(actualEvents));
    }

}