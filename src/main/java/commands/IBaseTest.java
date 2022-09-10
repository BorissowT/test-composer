package commands;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public interface IBaseTest {
    void validate();
    void load(LinkedHashMap<String, Map<String, String>> testMap);
    Map<String, String> getWhenCommands();
    Map<String, String> getThenCommands();
}
