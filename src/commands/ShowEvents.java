package commands;

import bg.tu_varna.sit.ListOfEvents;
import exceptions.NoSuchEventException;
import exceptions.NoSuchHallException;

public class ShowEvents implements Command{
    @Override
    public void execute(Object[] args) throws NoSuchHallException, NoSuchEventException {
        ListOfEvents listOfEvents = new ListOfEvents();
        listOfEvents.printEvents();
    }
}
