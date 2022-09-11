package settings;

import commands.ICommand;
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
    public void executeCommandByName(String commandName, String arg) {
        commands.forEach((command)->{
            if(Objects.equals(command.getName(), commandName))
                command.execute(arg);
        });
    }
}
