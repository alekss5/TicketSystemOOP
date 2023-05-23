package bg.tu_varna.sit;

import exceptions.NoSuchCodeException;

import javax.xml.bind.annotation.*;
import java.util.*;

@XmlRootElement(name = "hall")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Hall {

    private int number;

    private int numberOfRows;

    private int numberOfPlaces;

    private String hallName;

    private String[][]seats;


    public Hall(int number, int numberOfRows, int numberOfPlaces,String hallName) {
        this.number = number;
        this.numberOfRows = numberOfRows;
        this.numberOfPlaces = numberOfPlaces;
        this.hallName = hallName;
        seats = new String[this.numberOfRows][this.numberOfPlaces/this.numberOfRows];
        fillingTheSeats();

    }


    public Hall(){
    }

    @Override
    public String toString() {
        return "Hall{" +
                "number=" + number +
                ", numberOfRows=" + numberOfRows +
                ", numberOfPlaces=" + numberOfPlaces +
                ", hallName='" + hallName + '\'' +
                ", seats=" + Arrays.toString(seats) +
                '}';
    }

    public void printSeats(){
        for(int i = 0;i<this.numberOfRows;i++){
            for(int j = 0;j<this.numberOfPlaces/this.numberOfRows;j++){
                System.out.print(seats[i][j]+"  ");
            }
            System.out.println();
        }

    }
    public void fillingTheSeats(){
        for(int i = 0;i<this.numberOfRows;i++){
            for(int j = 0;j<this.numberOfPlaces/this.numberOfRows;j++){
                seats[i][j]=" free ";
            }

        }
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public void setNumberOfRows(int numberOfRows) {
        this.numberOfRows = numberOfRows;
    }

    public int getNumberOfPlaces() {
        return numberOfPlaces;
    }

    public void setNumberOfPlaces(int numberOfPlaces) {
        this.numberOfPlaces = numberOfPlaces;
    }

    public String[][] getSeats() {
        return seats;
    }

    public void setSeats(String[][] seats) {
        this.seats = seats;
    }
    public void bookSeat(int row,int colum){
        this.seats[row-1][colum-1] = "booked";

    }
   public String ReturnSeatStatus(int row,int colum){
       return this.seats[row-1][colum-1];

   }
    public void UnBookSeat(int row,int colum){
        this.seats[row-1][colum-1] = " free ";

    }
    public void BuyTicket(int row,int colum,String code){
        this.seats[row-1][colum-1] = code;

    }
    public void CheckCode(String code,boolean check)  {

        for(int i = 0;i<this.numberOfRows;i++){
            for(int j = 0;j<this.numberOfPlaces/this.numberOfRows;j++){
                if(seats[i][j].equals(code)){
                    i++;
                    j++;
                    System.out.println("Your row is: "+i+"\nYour seat is: "+j);
                    i--;
                    j--;
                    check=true;

                }
            }
        }


    }
    public int BookingsCount()  {

        String code="booked";
        int booked =0;
        for(int i = 0;i<this.numberOfRows;i++){
            for(int j = 0;j<this.numberOfPlaces/this.numberOfRows;j++){
                if(seats[i][j].equals(code)){
                    booked++;
                }
            }
        }
        return booked;
    }
    public int BoughtCount()  {

        String code="booked";

        int booked =0;
        for(int i = 0;i<this.numberOfRows;i++){
            for(int j = 0;j<this.numberOfPlaces/this.numberOfRows;j++){
                if(!seats[i][j].equals(code)&&!seats[i][j].equals("free")){
                    booked++;
                }
            }
        }
        return booked;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }




    @Override
    public int hashCode() {
        int result = Objects.hash(number, numberOfRows, numberOfPlaces, hallName);
        result = 31 * result + Arrays.hashCode(seats);
        return result;
    }
}
