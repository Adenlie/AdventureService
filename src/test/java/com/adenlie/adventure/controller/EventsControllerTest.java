package com.adenlie.adventure.controller;

import com.adenlie.adventure.model.Event;
import com.adenlie.adventure.service.EventsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        String startDateString = "10/24/2016";
        String endDateString = "10/31/2016";
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        Date startDate=null;
        Date endDate=null;
        try {
            startDate = df.parse(startDateString);
            endDate=df.parse(endDateString);
            //String newDateString = df.format(startDate);
            //System.out.println(newDateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Event event = new Event("Mystic Munnar", startDate, endDate, 4, 2000.00);
        when(eventsService.getEvents()).thenReturn(asList(event));

        List<Event> events = eventsController.getEvents();

        verify(eventsService).getEvents();
        assertThat(events, is(asList(event)));
    }

}