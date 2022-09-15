package commands;

import exceptions.IncorrectCommandException;

public class AfterCommand implements ICommand{

    String name = "after";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean execute(String arg) throws IncorrectCommandException {
        validateArg(arg);
        arg = arg.replace("s","");
        int time = Integer.parseInt(arg);
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

    public void validateArg(String arg) throws IncorrectCommandException {
        String pattern = "(\\d)(\\d|s)";
        if(!arg.matches(pattern))
            throw new IncorrectCommandException("wrong argument");
    }
}
