package machine;

import settings.ISettingsSet;

public interface ITestMachine {
    void inputTestPath(String path);
    void loadSettings(ISettingsSet settings);
    boolean run();

}
