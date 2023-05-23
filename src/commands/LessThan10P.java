package commands;

import bg.tu_varna.sit.ListOfEvents;
import exceptions.NoSuchEventException;
import exceptions.NoSuchHallException;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LessThan10P implements Command{
    @Override
    public void execute(Object[] args) throws NoSuchHallException, NoSuchEventException, JAXBException {

        System.out.print("This function is still unable.");

//        List<String> list = new ArrayList<>();
//        for(int i = 0;i<Event.getEvents().size();i++){
//            if(Event.getEvents().get(i).getDate().equals(date)){
//                double d =  ((double) Event.getEvents().get(i).counterTickets() / (double) Event.getEvents().get(i).getHall().getNumberOfPlaces()) * 100;
//                if(d < 10.0){
//                    list.add("Event name: "+Event.getEvents().get(i).getName()+" and "+d+" %");
//                }
//            }
//        }
//
//        if(list.isEmpty()){
//            System.out.println("No performances below 10% percent");
//        }
//        else{
//
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("Do you want to download the shows?");
//            System.out.println("Yes/No");
//            System.out.print("Enter: ");
//            String choice = scanner.nextLine();
//            if(choice.equalsIgnoreCase("Yes")){
//                for(String s:list){
//                    System.out.println(s);
//                }
//            }
//        }
    }
}
