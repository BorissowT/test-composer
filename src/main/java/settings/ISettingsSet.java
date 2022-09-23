package settings;

import commands.ICommand;
import exceptions.ConstrainArgumentException;
import exceptions.IncorrectCommandException;
import exceptions.LocationException;
import fileLoader.IFileReader;

public interface ISettingsSet {
    void addCommand(ICommand command);
    void addReader(IFileReader reader);
    IFileReader getReader();
    boolean executeCommandByName(String commandName,String arg) throws IncorrectCommandException, ConstrainArgumentException, LocationException;

    void loadArguments(String key, String valueOf) throws ConstrainArgumentException, LocationException, IncorrectCommandException;
}
