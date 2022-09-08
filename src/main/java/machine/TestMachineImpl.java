package machine;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import commands.BaseTestImpl;
import settings.ISettingsSet;

import java.io.File;
import java.io.IOException;

public class TestMachineImpl implements ITestMachine {
    @Override
    public void readTestFile(String path) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        BaseTestImpl order = null;
        try {
            order = mapper.readValue(new File(path), BaseTestImpl.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void loadSettings(ISettingsSet settings) {

    }

    @Override
    public void run() {

    }
}
