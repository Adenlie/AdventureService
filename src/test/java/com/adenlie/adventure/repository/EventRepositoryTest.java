package com.adenlie.adventure.repository;

import com.adenlie.adventure.model.Event;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

import static org.codehaus.groovy.runtime.InvokerHelper.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class EventRepositoryTest {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    EventRepository eventRepository;

    @Test
    public void shouldGetAllEvents() throws Exception {
        Date date = new Date();
        Event event = Event.builder().eventId("2016WY21")
                .price(2000d)
                .duration(2)
                .endDate(date)
                .startDate(date)
                .build();

        entityManager.persist(event);

        List<Event> allEvents = eventRepository.getEvents();

        assertThat(allEvents.size(), is(1));
        assertThat(allEvents, is(asList(event)));
    }
}