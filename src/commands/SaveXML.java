package commands;

import bg.tu_varna.sit.Event;
import bg.tu_varna.sit.ListOfEvents;
import bg.tu_varna.sit.ListOfHalls;
import exceptions.NoSuchEventException;
import exceptions.NoSuchHallException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.StringWriter;
import java.text.ParseException;

public class SaveXML implements Command{
    @Override
    public void execute(Object[] args) throws NoSuchHallException, NoSuchEventException, JAXBException {
        ListOfEvents listOfEvents = new ListOfEvents();

        try
        {
            JAXBContext jaxbContext = JAXBContext.newInstance(ListOfEvents.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            jaxbMarshaller.marshal(listOfEvents, new File("/Users/aleksandar/IdeaProjects/prject oop1/src/xmlFiles/Events.xml"));

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

}




