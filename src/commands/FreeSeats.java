package commands;

import bg.tu_varna.sit.Event;
import bg.tu_varna.sit.ListOfEvents;
import bg.tu_varna.sit.ListOfHalls;

import java.util.Scanner;

public class FreeSeats implements Command{
    @Override
    public void execute(Object[] args) {

        ListOfEvents eventList = new ListOfEvents();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Event date: >");
        String eventDate = scanner.nextLine();

        System.out.print("Event name: >");
        String eventName= scanner.nextLine();

        for (Event event : eventList.getEventList()) {
            if(event.getEventDate().equalsIgnoreCase(eventDate)&&event.getEventName().equalsIgnoreCase(eventName)) {
                System.out.println("event name:" + event.getEventName() + " on: " + event.getEventDate()   );
                event.getHall().printSeats();
            }
        }

    }
}
