package exceptions;

public class ConstrainArgumentException extends Exception{
    public ConstrainArgumentException() { super(); }
    public ConstrainArgumentException(String message) { super(message); }
    public ConstrainArgumentException(String message, Throwable t) { super(message, t); }
}
