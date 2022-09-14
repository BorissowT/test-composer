package exceptions;

public class IncorrectCommandException extends Exception{
    public IncorrectCommandException() { super(); }
    public IncorrectCommandException(String message) { super(message); }
    public IncorrectCommandException(String message, Throwable t) { super(message, t); }
}
