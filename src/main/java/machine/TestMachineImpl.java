package machine;

import commands.BaseTestImpl;
import commands.IBaseTest;
import fileLoader.IFileLoader;
import settings.ISettingsSet;

import java.util.LinkedHashMap;
import java.util.Map;

public class TestMachineImpl implements ITestMachine {
    IFileLoader fileLoader;
    IBaseTest actualTest = new BaseTestImpl();
    ISettingsSet settings;

    public TestMachineImpl(IFileLoader fileLoader) {
        this.fileLoader = fileLoader;
    }

    @Override
    public void inputTestPath(String path) {
        LinkedHashMap<String, Map<String, String>> testResult =  fileLoader.read(path);
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
