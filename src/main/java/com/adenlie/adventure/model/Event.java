package com.adenlie.adventure.model;

import java.util.Date;

public class Event {
    private String eventName;
    private Date startDate;
    private Date endDate;
    private Integer duration;
    private Double price;

    public Event(String s, Date date, Date date1,Integer i,Double v) {
        eventName=s;
        startDate=date;
        endDate=date1;
        duration=i;
        price=v;
    }


}
