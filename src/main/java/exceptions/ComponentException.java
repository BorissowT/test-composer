package exceptions;

public class ComponentException  extends Exception{
    public ComponentException() { super(); }
    public ComponentException(String message) { super(message); }
    public ComponentException(String message, Throwable t) { super(message, t); }
}
