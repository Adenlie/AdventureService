package com.adenlie.adventure.service;

import com.adenlie.adventure.model.Event;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static java.util.Arrays.asList;

public class EventsService {

    public List<Event> getEvents(){
        //new Event("some",new Date(),new Date(),new Integer(5),new Double(2000.0));
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
        return asList(new Event("Mystic Munnar", startDate, endDate, 4, 2000.00));

    }
}
