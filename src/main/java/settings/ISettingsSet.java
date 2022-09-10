package settings;

import commands.ICommand;

public interface ISettingsSet {
    void addCommand(ICommand command);
    void executeCommandByName(String commandName, String arg);
}
