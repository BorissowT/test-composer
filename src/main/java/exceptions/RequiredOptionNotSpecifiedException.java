package exceptions;

public class RequiredOptionNotSpecifiedException extends Exception{
    public RequiredOptionNotSpecifiedException() { super(); }
    public RequiredOptionNotSpecifiedException(String message) { super(message); }
    public RequiredOptionNotSpecifiedException(String message, Throwable t) { super(message, t); }
}
