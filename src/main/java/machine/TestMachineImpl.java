package machine;

import commands.BaseTestImpl;
import commands.IBaseTest;
import exceptions.*;
import fileLoader.IFileReader;
import settings.ISettingsSet;

import java.util.LinkedHashMap;
import java.util.Map;

public class TestMachineImpl implements ITestMachine {

    IBaseTest actualTest = new BaseTestImpl();
    ISettingsSet settings;


    @Override
    public void inputTestPath(String path) throws RequiredFieldIsNotSpecifiedException, RequiredOptionNotSpecifiedException, TriggerIsNotCorrectException {
        LinkedHashMap<String, Map<String, Object>> testResult =  settings.getReader().read(path);
        // TODO validate
        actualTest.load(testResult);
    }

    @Override
    public void loadSettings(ISettingsSet settings) {
        this.settings = settings;
    }

    @Override
    public boolean run() throws IncorrectCommandException, ConstrainArgumentException {
        runSection(actualTest.getWhenCommands());
        runSection(actualTest.getThenCommands());
        return true;
    }

    public boolean runSection(Map<String, Object> commands) throws IncorrectCommandException, ConstrainArgumentException {
        for (String key : commands.keySet()) {
            if(!settings.executeCommandByName(key,String.valueOf(commands.get(key))))
                return false;
        }
        return true;
    };
}
