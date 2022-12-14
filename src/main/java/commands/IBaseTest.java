package commands;

import exceptions.RequiredFieldIsNotSpecifiedException;
import exceptions.RequiredOptionNotSpecifiedException;
import exceptions.TriggerIsNotCorrectException;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public interface IBaseTest {
    void validate() throws RequiredFieldIsNotSpecifiedException, RequiredOptionNotSpecifiedException, TriggerIsNotCorrectException;
    void load(LinkedHashMap<String, Map<String, Object>> testMap) throws RequiredFieldIsNotSpecifiedException, RequiredOptionNotSpecifiedException, TriggerIsNotCorrectException;
    Map<String, Object> getWhenCommands();
    Map<String, Object> getThenCommands();
}
