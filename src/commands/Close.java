package commands;

import bg.tu_varna.sit.ListOfEvents;
import exceptions.NoSuchEventException;
import exceptions.NoSuchHallException;

import javax.xml.bind.JAXBException;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Close implements Command{

    @Override
    public void execute(Object[] args) throws NoSuchHallException, NoSuchEventException, JAXBException {
        ListOfEvents listOfEvents = new ListOfEvents();
        listOfEvents.getEventList().removeAll(listOfEvents.getEventList());
        System.out.println("File is closed!");

    }
}
