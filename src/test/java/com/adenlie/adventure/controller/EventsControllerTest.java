package com.adenlie.adventure.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class EventsControllerTest {
    @InjectMocks
    private EventsController eventsController;

    @Test
    public void shouldGetEvents() throws Exception {
        String events = eventsController.getEvents();

        assertThat(events, is("listing all events"));
    }

}