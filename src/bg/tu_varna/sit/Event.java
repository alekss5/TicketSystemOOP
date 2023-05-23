package bg.tu_varna.sit;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
@XmlRootElement(name = "Event")
public class Event {
    private Date eventDate;
    private String eventName;
    private Hall hall ;

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    //    private String hallName;
    private int boughtTickets;

    public Event(String eventDate, String eventName, String hallName) throws ParseException {
        ListOfHalls listOfHalls = new ListOfHalls();

        this.eventDate = new SimpleDateFormat("dd-MM-yyyy").parse(eventDate);

        this.eventName = eventName;

        this.hall = listOfHalls.returnHallByString(hallName);

    }
    public Event(String eventDate, String eventName, Hall event) throws ParseException {
        ListOfHalls listOfHalls = new ListOfHalls();

        this.eventDate = new SimpleDateFormat("dd-MM-yyyy").parse(eventDate);

        this.eventName = eventName;

        this.hall = event;

    }
    public Event(){}
    @XmlElement
    public Hall getHall() {
        return hall;
    }

    @XmlElement
    public Date getDateAsDate(){
        return this.eventDate;

    }
    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public String getEventDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String strDate = dateFormat.format(eventDate);
        return strDate;
    }


    public void setEventDate(String eventDate) throws ParseException {
        this.eventDate = new SimpleDateFormat("dd-MM-yyyy").parse(eventDate);
    }
    @XmlElement
    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
    @XmlElement
    public int getBoughtTickets() {
        return boughtTickets;
    }

    public void setBoughtTickets(int boughtTickets) {
        this.boughtTickets = boughtTickets;
    }
}
