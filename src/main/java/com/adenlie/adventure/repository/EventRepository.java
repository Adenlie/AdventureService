package com.adenlie.adventure.repository;

import com.adenlie.adventure.model.Event;
import com.adenlie.adventure.model.QEvent;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EventRepository extends AbstractRepository {
    private QEvent qEvent = QEvent.event;

    public List<Event> getEvents() {
        return from(qEvent).list(qEvent);
    }
}
