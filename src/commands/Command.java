package commands;

import exceptions.NoSuchEventException;
import exceptions.NoSuchHallException;

import javax.xml.bind.JAXBException;

public interface Command {
    void execute(Object[] args) throws NoSuchHallException, NoSuchEventException, JAXBException;
}
