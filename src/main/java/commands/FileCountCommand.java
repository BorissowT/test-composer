package commands;

import exceptions.ConstrainArgumentException;
import exceptions.IncorrectCommandException;

import java.io.File;

public class FileCountCommand implements ICommand{

    String name = "file_count";
    InDirectoryCommand inDirectoryDependency;

    public FileCountCommand(InDirectoryCommand inDirectoryDependency) {
        this.inDirectoryDependency = inDirectoryDependency;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean execute(String argCount) throws IncorrectCommandException, ConstrainArgumentException {
        validateArg(argCount);
        String path = inDirectoryDependency.getPath();
        if(path==null)
            throw new IncorrectCommandException("path not specified");
        File directory=new File(path);
        int fileCount=directory.list().length;
        return fileCount == Integer.parseInt(argCount);
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
