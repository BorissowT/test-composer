package exceptions;

public class LocationException extends Exception{
    public LocationException() { super(); }
    public LocationException(String message) { super(message); }
    public LocationException(String message, Throwable t) { super(message, t); }
}
