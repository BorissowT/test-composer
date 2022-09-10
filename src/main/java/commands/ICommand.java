package commands;

public interface ICommand {
    String getName();
    boolean execute(String arg);
}
