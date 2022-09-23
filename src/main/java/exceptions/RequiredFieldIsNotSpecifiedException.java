package exceptions;

public class RequiredFieldIsNotSpecifiedException extends Exception{
    public RequiredFieldIsNotSpecifiedException() { super(); }
    public RequiredFieldIsNotSpecifiedException(String message) { super(message); }
    public RequiredFieldIsNotSpecifiedException(String message, Throwable t) { super(message, t); }
}
