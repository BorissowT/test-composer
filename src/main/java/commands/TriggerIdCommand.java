package commands;

import exceptions.ConstrainArgumentException;
import exceptions.IncorrectCommandException;
import exceptions.LocationException;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class TriggerIdCommand implements ICommand{

    String name = "triggerId";
    String createType = "File Created";
    String countType = "File Count";

    WithNameCommand withNameCommand = null;
    InDirectoryCommand inDirectoryCommand = null;
    FileCountCommand fileCountCommand = null;


    public TriggerIdCommand() {
    }
    public TriggerIdCommand(WithNameCommand withNameCommandArg, InDirectoryCommand inDirectoryCommandArg, FileCountCommand fileCountCommandArg) {
        // File Created
        withNameCommand = withNameCommandArg;
        inDirectoryCommand = inDirectoryCommandArg;
        fileCountCommand = fileCountCommandArg;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean execute(String arg) throws IncorrectCommandException, ConstrainArgumentException {
        if(Objects.equals(arg, createType))
            return createFileCustom();
        if(Objects.equals(arg, countType))
            return countFiles();
        return false;
    }

    @Override
    public void load(String arg) throws ConstrainArgumentException, LocationException {

    }

    private boolean countFiles() throws IncorrectCommandException {
        String path = inDirectoryCommand.getPath();
        if(path==null)
            throw new IncorrectCommandException("path not specified");
        File directory=new File("src/"+path);
        int fileCount=directory.list().length;
        return fileCount == Integer.parseInt(fileCountCommand.getArgCount());
    }

    private boolean createFileCustom() throws ConstrainArgumentException {
        String fileName = null;
        String filePath = null;
        try {
            fileName = withNameCommand.getFileName();
            filePath = inDirectoryCommand.getPath();
        }
        catch (java.lang.NullPointerException e){
            throw new ConstrainArgumentException("path or name of file are not specified");
        }
        try {
            File myObj = new File("src/"+filePath+"/"+fileName);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return true;
    }
}
