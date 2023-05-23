package commands;

import bg.tu_varna.sit.ListOfEvents;
import exceptions.NoSuchEventException;
import exceptions.NoSuchHallException;

import java.security.SecureRandom;
import java.util.Scanner;

public class BuyTicket implements Command{
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

        System.out.print("note: >");
        String note= scanner.nextLine();

        //generating code
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++)
        {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }
        String code = sb.toString();
        boolean buy = false;

        try {

            for(int i = 0;i<listOfEvents.getEventList().size();i++){
                if(listOfEvents.getEventList().get(i).getEventName().equalsIgnoreCase(name)&&listOfEvents.getEventList().get(i).getEventDate().equalsIgnoreCase(date)){
                    listOfEvents.getEventList().get(i).getHall().BuyTicket(Integer.parseInt(row),Integer.parseInt(seat),code);
                    listOfEvents.getEventList().get(i).setBoughtTickets(listOfEvents.getEventList().get(i).getBoughtTickets()+1);

                    System.out.println("You bought ticket!");
                    buy=true;
                    break;

                }

            }if(!buy)
                throw new NoSuchEventException();

        }catch (NoSuchEventException e){
            System.out.println(e);
        }

    }
}
