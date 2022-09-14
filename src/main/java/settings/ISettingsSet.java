package settings;

import commands.ICommand;
import exceptions.IncorrectCommandException;
import fileLoader.IFileReader;

public interface ISettingsSet {
    void addCommand(ICommand command);
    void addReader(IFileReader reader);
    IFileReader getReader();
    boolean executeCommandByName(String commandName, String arg) throws IncorrectCommandException;
}
