package commands;

import exceptions.ConstrainArgumentException;
import exceptions.IncorrectCommandException;

public interface ICommand {
    String getName();
    boolean execute(String arg) throws IncorrectCommandException, ConstrainArgumentException;
}
