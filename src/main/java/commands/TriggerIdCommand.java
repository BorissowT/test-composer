package commands;

import exceptions.ConstrainArgumentException;
import exceptions.IncorrectCommandException;

public class TriggerIdCommand implements ICommand{
    String name = "triggerId";
    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean execute(String arg) throws IncorrectCommandException, ConstrainArgumentException {
        //TODO
        return true;
    }
}
