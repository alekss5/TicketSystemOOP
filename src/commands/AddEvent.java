package commands;

import bg.tu_varna.sit.Event;
import bg.tu_varna.sit.ListOfEvents;
import bg.tu_varna.sit.ListOfHalls;
import exceptions.NoSuchEventException;
import exceptions.NoSuchHallException;

import java.text.ParseException;
import java.util.Scanner;

public class AddEvent implements Command{

    ListOfHalls listOfHalls = new ListOfHalls();
    ListOfEvents listOfEvents = new ListOfEvents();
    @Override
    public void execute(Object[] args) throws NoSuchHallException {


        Scanner scanner = new Scanner(System.in);
        System.out.print("Event date: >");
        String eventDate = scanner.nextLine();

        System.out.print("Event name: >");
        String eventName= scanner.nextLine();

        System.out.print("Hall name: >");
        String hallName= scanner.nextLine();

        try {

        if(listOfHalls.IsHall(hallName)) {//проверява за зала със същото име
            listOfEvents.addEvent(new Event(eventDate, eventName, hallName));

            System.out.println("Event is added\n");


        }
        else {throw new NoSuchHallException();}


        }catch (NoSuchHallException | ParseException e){
         System.out.println(e);
        }
    }
}
















//            int ha = 0;
//        for(int i =0;i<listOfEvents.getEventList().size();i++){
//            if (listOfEvents.getEventList().get(i).getHall().getHallName().equalsIgnoreCase(hallName)) {
//                if(!listOfEvents.getEventList().get(i).getEventDate().equalsIgnoreCase(eventDate)){
//                    listOfEvents.addEvent(new Event(eventDate, eventName, hallName));
//
//                    System.out.println("Event is added\n");
//
//                }
//                ha = 1;
//
//            }
//
//
//        }
//        if (ha==0){
//            throw new NoSuchHallException();
//        }
//        if (ha==1) {
//            throw new NoSuchEventException();
//
//        }