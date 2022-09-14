package commands;

import java.util.*;

public class BaseTestImpl implements IBaseTest {
    public WhenImpl When;
    public ThenImpl Then;

    Map<String, Object> commandsWhen = new HashMap<String, Object>();
    Map<String, Object> commandsThen = new HashMap<String, Object>();

    @Override
    public void validate() {

    }

    @Override
    public void load(LinkedHashMap<String, Map<String, Object>> commandsMap) {
        commandsWhen = commandsMap.get("When");
        commandsThen = commandsMap.get("Then");
    }

    @Override
    public Map<String, Object> getWhenCommands() {
        return commandsWhen;
    }

    @Override
    public Map<String, Object> getThenCommands() {
        System.out.println("dd");
        return commandsThen;
    }
}
