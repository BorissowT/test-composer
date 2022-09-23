package exceptions;

public class TriggerIsNotCorrectException extends Exception{
    public TriggerIsNotCorrectException() { super(); }
    public TriggerIsNotCorrectException(String message) { super(message); }
    public TriggerIsNotCorrectException(String message, Throwable t) { super(message, t); }
}
