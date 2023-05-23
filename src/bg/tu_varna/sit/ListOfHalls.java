package bg.tu_varna.sit;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class ListOfHalls {
    private List<Hall> hallList = new ArrayList<>();
    public ListOfHalls() {
        addHalls();
    }
    public void addHalls(){
        hallList.add(new Hall(1,5,75,"Bulgaria hall"));
        hallList.add(new Hall(2,6,36,"Dobudja hall"));
        hallList.add(new Hall(3,5,60,"Central hall"));
    }

    public Hall returnHallByString(String hallName){
        for(int i=0;i<hallList.size();i++){
            if(hallList.get(i).getHallName().equalsIgnoreCase(hallName)){
                 return new Hall(hallList.get(i).getNumber(),hallList.get(i).getNumberOfRows(),hallList.get(i).getNumberOfPlaces(),hallName);

            }
        }
        return null;
    }

    public void printHalls(){
        for (Hall hall : hallList) {
            System.out.println(hall.toString());
        }
    }
    public boolean IsHall(String hallName){

        for (Hall hall : hallList) {
            if (hall.getHallName().equalsIgnoreCase(hallName)) {
                return true;
            }
        }
        return false;

    }
    public List<Hall> getHallList() {
        return hallList;
    }

    public void setHallList(List<Hall> hallList) {
        this.hallList = hallList;
    }
}
