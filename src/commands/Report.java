package commands;

import bg.tu_varna.sit.ListOfEvents;
import exceptions.NoSuchEventException;
import exceptions.NoSuchHallException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Report implements Command{

    @Override
    public void execute(Object[] args) throws NoSuchHallException, NoSuchEventException {

        ListOfEvents listOfEvents = new ListOfEvents();

        Scanner scanner = new Scanner(System.in);
        System.out.print("From date: >");
        String fromDate = scanner.nextLine();

        System.out.print("To date: >");
        String toDate= scanner.nextLine();

        System.out.print("Hall name: >");
        String hallName= scanner.nextLine();
        boolean booked = false;


        try {
            Date FDate = new SimpleDateFormat("dd-MM-yyyy").parse(fromDate);
            Date Tdate = new SimpleDateFormat("dd-MM-yyyy").parse(toDate);



            for(int i = 0;i<listOfEvents.getEventList().size();i++){
                if(hallName.isEmpty()){
                    Date listDate = listOfEvents.getEventList().get(i).getDateAsDate();

                    if (listDate.after(FDate) && listDate.before(Tdate)) {
                        System.out.println("event name:" + listOfEvents.getEventList().get(i).getEventName() + " on: " + listOfEvents.getEventList().get(i).getEventDate());
                        System.out.println(listOfEvents.getEventList().get(i).getBoughtTickets());
                        booked=true;
                    }
                }
                 if(listOfEvents.getEventList().get(i).getHall().getHallName().equalsIgnoreCase(hallName)) {
                    Date listDate = listOfEvents.getEventList().get(i).getDateAsDate();

                    if (listDate.after(FDate) && listDate.before(Tdate)) {
                        System.out.println("event name:" + listOfEvents.getEventList().get(i).getEventName() + " on: " + listOfEvents.getEventList().get(i).getEventDate());
                        System.out.println(listOfEvents.getEventList().get(i).getBoughtTickets());
                        booked=true;
                    }
                }

            }
            if(!booked){
                throw new NoSuchHallException();
            }

        }catch (NoSuchHallException|ParseException e) {
            System.out.println(e);
        }
    }
}
