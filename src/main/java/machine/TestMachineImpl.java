package machine;

import commands.BaseTestImpl;
import commands.IBaseTest;
import exceptions.*;
import fileLoader.IFileReader;
import settings.ISettingsSet;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class TestMachineImpl implements ITestMachine {

    IBaseTest actualTest = new BaseTestImpl();
    ISettingsSet settings;


    @Override
    public void inputTestPath(String path) throws RequiredFieldIsNotSpecifiedException, RequiredOptionNotSpecifiedException, TriggerIsNotCorrectException, ComponentException {
        ifReaderRegistered();
        LinkedHashMap<String, Map<String, Object>> testResult =  settings.getReader().read(path);
        // TODO validate
        actualTest.load(testResult);
    }

    private void ifReaderRegistered() throws ComponentException {
            if (settings.getReader()==null)
                throw new ComponentException("Reader is not specified");

    }

    @Override
    public void loadSettings(ISettingsSet settings) {
        this.settings = settings;
    }

    @Override
    public boolean run() throws IncorrectCommandException, ConstrainArgumentException, LocationException {
        loadArgs();
        boolean response = runSection(actualTest.getWhenCommands()) && runSection(actualTest.getThenCommands());
        return response;
    }

    private void loadArgs() throws ConstrainArgumentException, LocationException, IncorrectCommandException {
        loadOneOption(actualTest.getWhenCommands());
        loadOneOption(actualTest.getThenCommands());
    }

    private void loadOneOption(Map<String, Object> commands) throws ConstrainArgumentException, LocationException, IncorrectCommandException {
        for (String key : commands.keySet()) {
            settings.loadArguments(key, String.valueOf(commands.get(key)));
        }

    }

    public boolean runSection(Map<String, Object> commands) throws IncorrectCommandException, ConstrainArgumentException, LocationException {
        for (String key : commands.keySet()) {
            if(!settings.executeCommandByName(key, String.valueOf(commands.get(key))))
                return false;
        }
        return true;
    };
}
