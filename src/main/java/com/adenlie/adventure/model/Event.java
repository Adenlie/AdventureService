package com.adenlie.adventure.model;

import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "events")
@Builder
@AllArgsConstructor
public class Event {
    @Id
    private String eventId;
    private String eventName;
    private Date startDate;
    private Date endDate;
    private Integer duration;
    private Double price;
}
