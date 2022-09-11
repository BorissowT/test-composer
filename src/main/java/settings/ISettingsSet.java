package settings;

import commands.ICommand;
import fileLoader.IFileReader;

public interface ISettingsSet {
    void addCommand(ICommand command);
    void addReader(IFileReader reader);
    IFileReader getReader();
    void executeCommandByName(String commandName, String arg);
}
