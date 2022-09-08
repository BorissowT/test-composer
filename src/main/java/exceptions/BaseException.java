package exceptions;

public class BaseException extends Exception{
    public BaseException() { super(); }
    public BaseException(String message) { super(message); }
    public BaseException(String message, Throwable t) { super(message, t); }
}
