package commands;

import bg.tu_varna.sit.Event;
import bg.tu_varna.sit.ListOfEvents;
import exceptions.NoSuchCodeException;
import exceptions.NoSuchEventException;
import exceptions.NoSuchHallException;

import java.security.SecureRandom;
import java.util.Scanner;

public class CheckCode implements Command{
    @Override
    public void execute(Object[] args) throws NoSuchHallException, NoSuchEventException {

        ListOfEvents listOfEvents = new ListOfEvents();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Code: >");
        String code = scanner.nextLine();
        boolean check = false;


        //грешка за копуване на вече заето мясно
        //грешка за копуване на несъществуващо място


        try {

            for (int i = 0; i < listOfEvents.getEventList().size(); i++) {
                listOfEvents.getEventList().get(i).getHall().CheckCode(code,check);
                check = true;
                }

            if(!check){
                throw new NoSuchCodeException();
            }

        }catch( NoSuchCodeException e){
        System.out.println(e);
        }
    }
}