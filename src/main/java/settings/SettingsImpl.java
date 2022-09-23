package settings;

import commands.ICommand;
import exceptions.ConstrainArgumentException;
import exceptions.IncorrectCommandException;
import exceptions.LocationException;
import fileLoader.IFileReader;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SettingsImpl implements ISettingsSet {

    List<ICommand> commands = new ArrayList<>();
    IFileReader reader;

    @Override
    public void addCommand(ICommand command) {
        commands.add(command);
    }

    @Override
    public void addReader(IFileReader readerArg) {
        this.reader = readerArg;
    }

    @Override
    public IFileReader getReader() {
        return reader;
    }

    @Override
    public boolean executeCommandByName(String commandName, String arg) throws IncorrectCommandException, ConstrainArgumentException, LocationException {

        for(ICommand command : commands){
            if(Objects.equals(command.getName(), commandName))
                return command.execute(arg);
        }
        throw new IncorrectCommandException("command " + commandName + " does not registered as a command");
    }

    @Override
    public void loadArguments(String commandName, String arg) throws ConstrainArgumentException, LocationException {
        for(ICommand command : commands){
            if(Objects.equals(command.getName(), commandName))
                 command.load(arg);
        }
    }
}
