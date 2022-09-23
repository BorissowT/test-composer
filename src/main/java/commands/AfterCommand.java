package commands;

import exceptions.ConstrainArgumentException;
import exceptions.IncorrectCommandException;

public class AfterCommand implements ICommand{

    String name = "after";
    private int time;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean execute(String arg) throws  ConstrainArgumentException {

        for (int i = 0; i<time; i++){
            try {
                Thread.sleep(1000);
                System.out.println("Wait 1sec.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return true;
    }

    @Override
    public void load(String arg) throws ConstrainArgumentException {
        validateArg(arg);
        arg = arg.replace("s","");
        this.time = Integer.parseInt(arg);
    }

    public void validateArg(String arg) throws  ConstrainArgumentException {
        validateFormOfArgument(arg);
        validateConstrainsInArg(arg);
    }

    private void validateConstrainsInArg(String arg) throws ConstrainArgumentException {
        arg = arg.replace("s","");
        int number = Integer.parseInt(arg);
        if(number<0)
            throw new ConstrainArgumentException("negative argument for 'after'");
        if(number>10)
            throw new ConstrainArgumentException("negative argument for 'after'");
    }

    private void validateFormOfArgument(String arg) throws ConstrainArgumentException {
        String pattern = "(\\d)(\\d|s)";
        if(!arg.matches(pattern))
            throw new ConstrainArgumentException("wrong argument");
    }
}
