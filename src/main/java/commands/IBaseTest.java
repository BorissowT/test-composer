package commands;

import exceptions.RequiredFieldIsNotSpecifiedException;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public interface IBaseTest {
    void validate() throws RequiredFieldIsNotSpecifiedException;
    void load(LinkedHashMap<String, Map<String, Object>> testMap) throws RequiredFieldIsNotSpecifiedException;
    Map<String, Object> getWhenCommands();
    Map<String, Object> getThenCommands();
}
