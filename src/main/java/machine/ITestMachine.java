package machine;

import exceptions.IncorrectCommandException;
import settings.ISettingsSet;

public interface ITestMachine {
    void inputTestPath(String path);
    void loadSettings(ISettingsSet settings);
    boolean run() throws IncorrectCommandException;

}
