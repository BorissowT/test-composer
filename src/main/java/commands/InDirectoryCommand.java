package commands;

import exceptions.ConstrainArgumentException;
import exceptions.IncorrectCommandException;
import exceptions.LocationException;

import java.io.File;
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
    public void load(String arg) throws LocationException {
        validateIfPathExists(arg);
        path=arg;
    }

    @Override
    public boolean execute(String arg) {
        return true;
    }

    private void validateIfPathExists(String arg) throws LocationException {
        Path path = Paths.get("src/"+arg);
        if(!Files.exists(path))
            throw new LocationException("directory does not exist");
    }

    public String getPath(){
        return path;
    }
}
