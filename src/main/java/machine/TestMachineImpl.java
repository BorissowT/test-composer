package machine;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import commands.BaseTestImpl;
import commands.IBaseTest;
import fileLoader.IFileLoader;
import settings.ISettingsSet;

import java.io.File;
import java.io.IOException;

public class TestMachineImpl implements ITestMachine {
    IFileLoader fileLoader;
    IBaseTest actualTest;

    public TestMachineImpl(IFileLoader fileLoader) {
        this.fileLoader = fileLoader;
    }

    @Override
    public void inputTestPath(String path) {
        IBaseTest testResult = fileLoader.read(path);
        testResult.validate();
        actualTest = testResult;
    }

    @Override
    public void loadSettings(ISettingsSet settings) {

    }

    @Override
    public boolean run() {
        return true;
    }
}
