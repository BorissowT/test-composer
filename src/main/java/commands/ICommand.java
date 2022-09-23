package commands;

import exceptions.ConstrainArgumentException;
import exceptions.IncorrectCommandException;
import exceptions.LocationException;

public interface ICommand {
    String getName();
    boolean execute(String arg) throws IncorrectCommandException, ConstrainArgumentException, LocationException;

    void load(String arg) throws ConstrainArgumentException, LocationException;
}
