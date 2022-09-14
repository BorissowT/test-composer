package machine;

import exceptions.IncorrectCommandException;
import exceptions.RequiredFieldIsNotSpecifiedException;
import settings.ISettingsSet;

public interface ITestMachine {
    void inputTestPath(String path) throws RequiredFieldIsNotSpecifiedException;
    void loadSettings(ISettingsSet settings);
    boolean run() throws IncorrectCommandException;

}
