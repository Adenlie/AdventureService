package com.adenlie.adventure.repository;

import com.adenlie.adventure.model.Event;
import com.adenlie.adventure.model.QEvent;
import org.springframework.stereotype.Repository;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Repository
public class EventRepository extends AbstractRepository {
    private QEvent qEvent = QEvent.event;

    public List<Event> getEvents() {
        return from(qEvent).list(qEvent);
    }

    public List<Event> saveAll(List<Event> events) {
        return events.stream().map(this::save).collect(toList());
    }
}
