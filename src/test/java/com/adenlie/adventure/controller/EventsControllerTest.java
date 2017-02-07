//package com.adenlie.adventure.controller;
//
//import com.adenlie.adventure.model.Event;
//import com.adenlie.adventure.service.EventsService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.runners.MockitoJUnitRunner;
//
//import java.util.List;
//
//import static java.util.Collections.singletonList;
//import static org.hamcrest.core.Is.is;
//import static org.junit.Assert.assertThat;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@RunWith(MockitoJUnitRunner.class)
//public class EventsControllerTest {
//    @InjectMocks
//    private EventsController eventsController;
//
//    @Mock
//    private EventsService eventsService;
//
//    @Test
//    public void shouldGetEvents() throws Exception {
//        String startDateString = "10/24/2016";
//        String endDateString = "10/31/2016";
//        Event event = Event.builder().eventId("2017MNR1").build();
//        List<Event> expectedEvents = singletonList(event);
//
//        when(eventsService.getEvents()).thenReturn(expectedEvents);
//
//        List<Event> actualEvents = eventsController.getEvents();
//
//        verify(eventsService).getEvents();
//        assertThat(actualEvents, is(actualEvents));
//    }
//
//}