package commands;

import exceptions.ConstrainArgumentException;
import exceptions.IncorrectCommandException;
import exceptions.LocationException;

public class WithNameCommand implements ICommand{

    String name = "with_name";
    String fileName = null;

    public String getFileName() {
        return fileName;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean execute(String arg) {

        return true;
    }

    @Override
    public void load(String arg) throws ConstrainArgumentException, LocationException {
        fileName = arg;
    }
}
