package commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BaseTestImpl implements IBaseTest {
    public WhenImpl When;
    public ThenImpl Then;

    HashMap<String, String> commandsWhen = new HashMap<String, String>();
    HashMap<String, String> commandsThen = new HashMap<String, String>();

    @Override
    public void validate() {

    }

    @Override
    public void load() {
        commandsWhen.put("with_name", When.with_name);
        commandsWhen.put("in_directory",When.in_directory);
        commandsWhen.put("triggerId",When.triggerId);

        commandsThen.put("after",Then.after);
        commandsThen.put("file_count",Then.file_count);
        commandsThen.put("in_directory",Then.in_directory);
        commandsThen.put("triggerId",Then.triggerId);
    }

    @Override
    public HashMap<String, String> getWhenCommands() {
        return commandsWhen;
    }

    @Override
    public HashMap<String, String> getThenCommands() {
        return commandsThen;
    }
}
