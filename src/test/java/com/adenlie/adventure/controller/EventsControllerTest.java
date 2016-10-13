package com.adenlie.adventure.controller;

import com.adenlie.adventure.model.Event;
import com.adenlie.adventure.service.EventsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static java.util.Arrays.asList;
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

    @Test
    public void shouldGetEvents() throws Exception {
        Event event = new Event();
        when(eventsService.getEvents()).thenReturn(asList(event));

        List<Event> events = eventsController.getEvents();

        verify(eventsService).getEvents();
        assertThat(events, is(asList(event)));
    }

}