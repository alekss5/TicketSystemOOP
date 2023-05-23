package bg.tu_varna.sit;

import exceptions.NoSuchHallException;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
@XmlRootElement(name ="Events")

public class ListOfEvents {
    private static List<Event> eventList = new ArrayList<>();
    public ListOfEvents() {
    }
    public void addEvent(Event event) throws ParseException {
        this.eventList.add(event);
    }
    public void Sort(){
        eventList.sort(Comparator.comparingInt(Event::getBoughtTickets).reversed());
    }
    public void printEvents(){

        for (Event event : eventList) {
            System.out.println("event name" + event.getEventName() + "" + event.getEventDate() + "" + event.getHall().getHallName());
        }
    }

    @Override
    public String toString() {
//        return "ListOfEvents{" +
//                "eventList=" + eventList +
//                '}';
           return null;
    }


    @XmlElement(name="Event")
    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }
   // public boolean isEvent(String eventName,String date) {
//        for (Event event : eventList) {
//            if (event.getHall().getHallName().equalsIgnoreCase(eventName)&&event.getEventDate().equalsIgnoreCase(date)) {
//                return true;
//            }
//
//        }
//        return false;
//
//    }

}
