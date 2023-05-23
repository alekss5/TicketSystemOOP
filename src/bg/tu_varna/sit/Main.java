package bg.tu_varna.sit;

import commands.Command;
import commands.CommandFactory;
import exceptions.NoSuchEventException;
import exceptions.NoSuchHallException;

import javax.xml.bind.JAXBException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchHallException, NoSuchEventException, JAXBException {


        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("Enter your command: \n >");
            String userInput = scanner.nextLine();

            String[] splitedInput = userInput.split("[ ]+");

            String commandName = splitedInput[0];
            Object[] commandArgs = new String[splitedInput.length-1];
            System.arraycopy(splitedInput,1,commandArgs,0,commandArgs.length);

            Command command = CommandFactory.getCommand(commandName);
            if(command!=null)
                command.execute(commandArgs);
            else
                System.out.println("Invalid command. Try again or use help.");
        }
    }
}