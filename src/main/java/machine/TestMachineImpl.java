package machine;

import commands.BaseTestImpl;
import commands.IBaseTest;
import fileLoader.IFileReader;
import settings.ISettingsSet;

import java.util.LinkedHashMap;
import java.util.Map;

public class TestMachineImpl implements ITestMachine {

    IBaseTest actualTest = new BaseTestImpl();
    ISettingsSet settings;


    @Override
    public void inputTestPath(String path) {
        LinkedHashMap<String, Map<String, String>> testResult =  settings.getReader().read(path);
        // TODO validate
        //testResult.validate();
        actualTest.load(testResult);
    }

    @Override
    public void loadSettings(ISettingsSet settings) {
        this.settings = settings;
    }

    @Override
    public boolean run() {
        actualTest.getWhenCommands().forEach((key, value)->{
            settings.executeCommandByName(key,value);
        });
        // TODO crushes here on casting
        actualTest.getThenCommands().forEach((key, value)->{
            settings.executeCommandByName(key,value);
        });
        return true;
    }
}
