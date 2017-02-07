package com.adenlie.adventure.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "events")
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Event {
    @Id
    private String eventId;
    private Integer duration;
    private Date endDate;
    private String eventName;
    private Double price;
    private Date startDate;
}
