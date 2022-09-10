package commands;

import java.util.*;

public class BaseTestImpl implements IBaseTest {
    public WhenImpl When;
    public ThenImpl Then;

    Map<String, String> commandsWhen = new HashMap<String, String>();
    Map<String, String> commandsThen = new HashMap<String, String>();

    @Override
    public void validate() {

    }

    @Override
    public void load(LinkedHashMap<String, Map<String, String>> commandsMap) {
        commandsWhen = commandsMap.get("When");
        commandsThen = commandsMap.get("Then");
    }

    @Override
    public Map<String, String> getWhenCommands() {
        return commandsWhen;
    }

    @Override
    public Map<String, String> getThenCommands() {
        return commandsThen;
    }
}
