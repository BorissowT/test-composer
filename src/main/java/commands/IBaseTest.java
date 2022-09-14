package commands;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public interface IBaseTest {
    void validate();
    void load(LinkedHashMap<String, Map<String, Object>> testMap);
    Map<String, Object> getWhenCommands();
    Map<String, Object> getThenCommands();
}
