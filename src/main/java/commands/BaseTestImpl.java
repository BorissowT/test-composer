package commands;

import exceptions.RequiredFieldIsNotSpecifiedException;
import exceptions.RequiredOptionNotSpecifiedException;
import exceptions.TriggerIsNotCorrectException;

import java.util.*;

public class BaseTestImpl implements IBaseTest {
    Map<String, Object> commandsWhen = new HashMap<String, Object>();
    Map<String, Object> commandsThen = new HashMap<String, Object>();

    @Override
    public void load(LinkedHashMap<String, Map<String, Object>> commandsMap) throws RequiredFieldIsNotSpecifiedException, RequiredOptionNotSpecifiedException, TriggerIsNotCorrectException {
        commandsWhen = commandsMap.get("When");
        commandsThen = commandsMap.get("Then");
        validate();
    }

    @Override
    public Map<String, Object> getWhenCommands() {
        return commandsWhen;
    }

    @Override
    public Map<String, Object> getThenCommands() {
        return commandsThen;
    }

    @Override
    public void validate() throws RequiredFieldIsNotSpecifiedException, RequiredOptionNotSpecifiedException, TriggerIsNotCorrectException {
        checkWhenAndThenOptions();//1
        checkIfTriggersAreCorrect();
        checkFileCreatedFields();
        checkFileCountFields();
    }

    private void checkIfTriggersAreCorrect() throws TriggerIsNotCorrectException {
        if(commandsWhen.get("triggerId")==null||commandsThen.get("triggerId")==null)
            throw new TriggerIsNotCorrectException("trigger id is not specified");
        if(commandsWhen.get("triggerId")!=null){
            if(!Objects.equals(String.valueOf(commandsWhen.get("triggerId")), "File Count")
                    &&!Objects.equals(String.valueOf(commandsWhen.get("triggerId")), "File Created"))
                throw new TriggerIsNotCorrectException("trigger id is not correct");
        }
        if(commandsThen.get("triggerId")!=null){
            if(!Objects.equals(String.valueOf(commandsThen.get("triggerId")), "File Count")
                    &&!Objects.equals(String.valueOf(commandsThen.get("triggerId")), "File Created"))
                throw new TriggerIsNotCorrectException("trigger id is not correct");
        }

    }

    private void checkWhenAndThenOptions() throws RequiredOptionNotSpecifiedException {
        if (commandsWhen == null||commandsThen==null)
            throw new RequiredOptionNotSpecifiedException("required option whn or then is not specified");
    }

    private void checkFileCountFields() throws RequiredFieldIsNotSpecifiedException {
        String[] requiredFields = {"file_count", "in_directory"};
        if(Objects.equals(String.valueOf(commandsWhen.get("triggerId")), "File Count"))
            validateRequiredFields(commandsWhen, requiredFields);
        else if(Objects.equals(String.valueOf(commandsThen.get("triggerId")), "File Count"))
            validateRequiredFields(commandsThen, requiredFields);
    }

    private void checkFileCreatedFields() throws RequiredFieldIsNotSpecifiedException {
        String[] requiredFields = {"with_name", "in_directory"};
        if(Objects.equals(String.valueOf(commandsWhen.get("triggerId")), "File Created"))
            validateRequiredFields(commandsWhen, requiredFields);
        else if(Objects.equals(String.valueOf(commandsThen.get("triggerId")), "File Created"))
            validateRequiredFields(commandsThen, requiredFields);
    }

    private void validateRequiredFields(Map<String, Object> commands, String[] requiredFields) throws RequiredFieldIsNotSpecifiedException {
        for(String requiredCommand: requiredFields){
            if(commands.get(requiredCommand)==null)
                throw new RequiredFieldIsNotSpecifiedException("required field is not specified");
        }
    }


}
