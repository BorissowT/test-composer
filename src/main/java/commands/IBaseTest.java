package commands;

import java.util.HashMap;
import java.util.List;

public interface IBaseTest {
    void validate();
    void load();
    HashMap<String, String> getWhenCommands();
    HashMap<String, String> getThenCommands();
}
