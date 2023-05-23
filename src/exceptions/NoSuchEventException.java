package exceptions;

public class NoSuchEventException extends Exception{
    public NoSuchEventException() {
        System.out.println("No such event!");
    }
}
