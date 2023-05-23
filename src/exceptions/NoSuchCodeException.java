package exceptions;

public class NoSuchCodeException extends Exception{
    public NoSuchCodeException() {
        System.out.println("No such code!");
    }
}
