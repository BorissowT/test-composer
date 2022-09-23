package commands;

import exceptions.ConstrainArgumentException;
import exceptions.IncorrectCommandException;

import java.io.File;

public class FileCountCommand implements ICommand{

    String name = "file_count";
    InDirectoryCommand inDirectoryDependency;
    String argCount = null;

    public FileCountCommand(InDirectoryCommand inDirectoryDependency) {
        this.inDirectoryDependency = inDirectoryDependency;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean execute(String arg) throws IncorrectCommandException, ConstrainArgumentException {
        String path = inDirectoryDependency.getPath();
        if(path==null)
            throw new IncorrectCommandException("path not specified");
        File directory=new File("src/"+path);
        int fileCount=directory.list().length;
        return fileCount == Integer.parseInt(argCount);
    }

    @Override
    public void load(String arg) throws ConstrainArgumentException {
        validateArg(arg);
        argCount = arg;
    }

    private void validateArg(String argCount) throws ConstrainArgumentException {
        validateCast(argCount);
        validateConstrains(argCount);
    }

    private void validateConstrains(String argCount) throws  ConstrainArgumentException {
        int number = Integer.parseInt(argCount);
        if(number<0)
            throw new ConstrainArgumentException("negative argument for 'file count'");
    }

    private void validateCast(String argCount) throws ConstrainArgumentException {
        try {
            Integer.parseInt(argCount);
        }
        catch (java.lang.NumberFormatException e){
            throw new ConstrainArgumentException("wrong argument for 'file count'");
        }
    }
}
