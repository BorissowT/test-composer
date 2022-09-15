package commands;

import exceptions.ConstrainArgumentException;
import exceptions.IncorrectCommandException;

public class WithNameCommand implements ICommand{

    String name = "with_name";

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
