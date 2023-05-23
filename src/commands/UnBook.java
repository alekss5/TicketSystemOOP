package commands;

import bg.tu_varna.sit.ListOfEvents;
import exceptions.NoSuchEventException;
import exceptions.NoSuchHallException;
import exceptions.SeatIsNotBookedException;

import java.util.Objects;
import java.util.Scanner;

public class UnBook implements Command{
    @Override
    public void execute(Object[] args) throws NoSuchHallException, NoSuchEventException {


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

        boolean buy = false;

        try {

            for(int i = 0;i<listOfEvents.getEventList().size();i++){
                if(listOfEvents.getEventList().get(i).getEventName().equalsIgnoreCase(name)&&listOfEvents.getEventList().get(i).getEventDate().equalsIgnoreCase(date)){
                    if(!Objects.equals(listOfEvents.getEventList().get(i).getHall().ReturnSeatStatus(Integer.parseInt(row), Integer.parseInt(seat)), "booed"))
                    {
                        throw new SeatIsNotBookedException();
                    }
                        listOfEvents.getEventList().get(i).getHall().UnBookSeat(Integer.parseInt(row), Integer.parseInt(seat));
                    buy=true;
                        System.out.println("Event is Unbooked\n");
                        break;
                }
            }
            if(!buy){
                throw new NoSuchEventException();
            }

        }catch (NoSuchEventException|SeatIsNotBookedException e){
            System.out.println(e);
        }

    }
}
