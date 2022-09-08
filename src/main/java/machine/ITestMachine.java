package machine;

import settings.ISettingsSet;

public interface ITestMachine {
    void readTestFile(String path);
    void loadSettings(ISettingsSet settings);
    void run();

}
