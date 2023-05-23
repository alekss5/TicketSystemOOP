package exceptions;

public class SeatIsNotBookedException extends Exception{
    public SeatIsNotBookedException(){
        System.out.print("This seat is not booked!");
    }

}
