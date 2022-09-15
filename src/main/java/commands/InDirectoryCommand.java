package commands;

import exceptions.IncorrectCommandException;
import exceptions.LocationException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class InDirectoryCommand implements ICommand {

    String name = "in_directory";
    String path = null;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean execute(String arg) throws IncorrectCommandException, LocationException {
        validateIfPathExists(arg);
        return false;
    }

    private void validateIfPathExists(String arg) throws LocationException {
        Path path = Paths.get(arg);
        if(!Files.exists(path))
            throw new LocationException("directory does not exist");
    }

    public String getPath(){
        return path;
    }
}
