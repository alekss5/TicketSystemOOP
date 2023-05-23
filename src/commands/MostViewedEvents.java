package commands;

import bg.tu_varna.sit.Event;
import bg.tu_varna.sit.ListOfEvents;
import exceptions.NoSuchEventException;
import exceptions.NoSuchHallException;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MostViewedEvents implements Command{
    ListOfEvents listOfEvents = new ListOfEvents();
    @Override
    public void execute(Object[] args) throws NoSuchHallException, NoSuchEventException {

        listOfEvents.Sort();

        System.out.println("In first place is the most viewed performance is: "+"Event name: "+listOfEvents.getEventList().get(0).getEventName()+ " on: " +listOfEvents.getEventList().get(0).getEventDate()+" is whit: "+listOfEvents.getEventList().get(0).getBoughtTickets());
        System.out.println("In second place is the most viewed performance is: "+"Event name: "+listOfEvents.getEventList().get(1).getEventName()+ " on: " +listOfEvents.getEventList().get(1).getEventDate()+" is whit: "+listOfEvents.getEventList().get(1).getBoughtTickets());
        System.out.println("In third place is the most viewed performance is: "+"Event name: "+listOfEvents.getEventList().get(2).getEventName()+ " on: " +listOfEvents.getEventList().get(2).getEventDate()+" is whit: "+listOfEvents.getEventList().get(2).getBoughtTickets());


    }
}
