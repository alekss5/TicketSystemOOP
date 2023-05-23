package commands;

import bg.tu_varna.sit.Event;
import bg.tu_varna.sit.ListOfEvents;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.text.ParseException;

public class OpenXML implements Command{
    @Override
    public void execute(Object[] args) {
        ListOfEvents listOfEvents = new ListOfEvents();
        try {
            JAXBContext context = JAXBContext.newInstance(ListOfEvents.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            ListOfEvents list = (ListOfEvents) unmarshaller.unmarshal(new File("/Users/aleksandar/IdeaProjects/prject oop1/src/xmlFiles/Events.xml"));


            int size = listOfEvents.getEventList().size()-listOfEvents.getEventList().size();

            for (int i = 0;i<size;i++){
                listOfEvents.addEvent(new Event(list.getEventList().get(i).getEventDate(),list.getEventList().get(i).getEventName(),list.getEventList().get(i).getHall().getHallName()));
            }
            System.out.print("Data is loaded\n");

        } catch (JAXBException|ParseException e) {
            System.out.println(e);

        }
    }
}
