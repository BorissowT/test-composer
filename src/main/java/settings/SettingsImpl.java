package settings;

import commands.AfterCommand;
import commands.ICommand;
import settings.ISettingsSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SettingsImpl implements ISettingsSet {

    List<ICommand> commands = new ArrayList<>();

    @Override
    public void addCommand(ICommand command) {
        commands.add(command);
    }

    @Override
    public void executeCommandByName(String commandName, String arg) {
        commands.forEach((command)->{
            if(Objects.equals(command.getName(), commandName))
                command.execute(arg);
        });
    }
}
