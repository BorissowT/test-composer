package machine;

import exceptions.IncorrectCommandException;
import exceptions.RequiredFieldIsNotSpecifiedException;
import exceptions.RequiredOptionNotSpecifiedException;
import settings.ISettingsSet;

public interface ITestMachine {
    void inputTestPath(String path) throws RequiredFieldIsNotSpecifiedException, RequiredOptionNotSpecifiedException;
    void loadSettings(ISettingsSet settings);
    boolean run() throws IncorrectCommandException;

}
