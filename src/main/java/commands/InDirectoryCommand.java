package commands;

import exceptions.IncorrectCommandException;

public class InDirectoryCommand implements ICommand {

    String name = "in_directory";
    String path = null;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean execute(String arg) throws IncorrectCommandException {
        //TODO check if exists
        return false;
    }

    public String getPath(){
        return path;
    }
}
