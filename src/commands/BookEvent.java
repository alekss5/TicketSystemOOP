package commands;

import bg.tu_varna.sit.*;
import exceptions.NoSuchEventException;
import exceptions.NoSuchHallException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BookEvent implements Command{
    @Override
    public void execute(Object[] args) throws NoSuchEventException {

        ListOfEvents listOfEvents = new ListOfEvents();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Row: >");
        String row = scanner.nextLine();

        System.out.print("Seat: >");
        String seat= scanner.nextLine();

        System.out.print("Date: >");
        String date= scanner.nextLine();

        System.out.print("Event name: >");
        String name= scanner.nextLine();

        System.out.print("note: >");
        String note= scanner.nextLine();
        boolean buy = false;

        try {
                for(int i = 0;i<listOfEvents.getEventList().size();i++){
                    if(listOfEvents.getEventList().get(i).getEventName().equalsIgnoreCase(name)&&listOfEvents.getEventList().get(i).getEventDate().equalsIgnoreCase(date)){

                        listOfEvents.getEventList().get(i).getHall().bookSeat(Integer.parseInt(row),Integer.parseInt(seat));
                        System.out.println("Event is booked");
                        buy=true;
                        break;
                    }
                }
            if(!buy)
                throw new NoSuchEventException();
        }catch (NoSuchEventException e){
            System.out.println(e);


        }
    }
}
