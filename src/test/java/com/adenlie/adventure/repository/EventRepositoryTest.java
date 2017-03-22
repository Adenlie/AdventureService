package com.adenlie.adventure.repository;

import com.adenlie.adventure.model.Event;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.codehaus.groovy.runtime.InvokerHelper.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@TestConfiguration("resources/application.properties")
@DataJpaTest
public class EventRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EventRepository eventRepository;
    private Event event;

    @Before
    public void setUp() throws Exception {
        Date date = new Date();
        event = Event.builder().eventId("2016WY21")
                .price(2000d)
                .duration(2)
                .endDate(date)
                .startDate(date)
                .build();
    }

    @Test
    @Ignore
    public void shouldCreateNewEvent() throws Exception {
        eventRepository.save(event);
        Event expectedEvent = entityManager.find(Event.class, "2016WY21");

        assertNotNull(expectedEvent);
        assertThat(expectedEvent, is(event));
    }

    @Test
    @Ignore
    public void shouldGetAllEvents() throws Exception {
        entityManager.persist(event);
        List<Event> allEvents = eventRepository.getEvents();

        assertThat(allEvents.size(), is(1));
        assertThat(allEvents, is(asList(event)));
    }
}