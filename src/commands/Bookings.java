package commands;

import bg.tu_varna.sit.ListOfEvents;
import exceptions.NoSuchEventException;
import exceptions.NoSuchHallException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Bookings implements Command{
    @Override
    public void execute(Object[] args) throws NoSuchHallException, NoSuchEventException {

        ListOfEvents listOfEvents = new ListOfEvents();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Date: >");
        String Date = scanner.nextLine();

        System.out.print("Hall name: >");
        String hallName= scanner.nextLine();
        int bookings = 0;
        boolean booked = true;


        try {

            for(int i = 0;i<listOfEvents.getEventList().size();i++){

                if(Date.isEmpty()|| Date==null) {
                    if (listOfEvents.getEventList().get(i).getHall().getHallName().equalsIgnoreCase(hallName) ) {
                        System.out.println("event name:" + listOfEvents.getEventList().get(i).getEventName() + " on: " + listOfEvents.getEventList().get(i).getEventDate());
                        bookings = listOfEvents.getEventList().get(i).getHall().BookingsCount()+bookings;
                        booked = true;

                    }
                }

                    Date DDate = new SimpleDateFormat("dd-MM-yyyy").parse(Date);

                    Date listDate = listOfEvents.getEventList().get(i).getDateAsDate();
                    if(hallName.isEmpty()&&listDate.equals(DDate)){
                        System.out.println("event name:" + listOfEvents.getEventList().get(i).getEventName() + " on: " + listOfEvents.getEventList().get(i).getEventDate());
                        bookings = listOfEvents.getEventList().get(i).getHall().BookingsCount()+bookings;
                        booked=true;

                    }
                    if(listOfEvents.getEventList().get(i).getHall().getHallName().equalsIgnoreCase(hallName)&&listDate.equals(DDate)) {
                        System.out.println("event name:" + listOfEvents.getEventList().get(i).getEventName() + " on: " + listOfEvents.getEventList().get(i).getEventDate());
                        bookings = listOfEvents.getEventList().get(i).getHall().BookingsCount()+bookings;
                        booked=true;

                    }

            }
            System.out.println("Total bookings: "+bookings);
            if(!booked)
                throw new NoSuchHallException();


        }catch (NoSuchHallException | ParseException e) {
            System.out.println(e);
        }
    }
}
