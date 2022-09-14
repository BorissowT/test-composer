package machine;

import exceptions.IncorrectCommandException;
import exceptions.RequiredFieldIsNotSpecifiedException;
import exceptions.RequiredOptionNotSpecifiedException;
import exceptions.TriggerIsNotCorrectException;
import settings.ISettingsSet;

public interface ITestMachine {
    void inputTestPath(String path) throws RequiredFieldIsNotSpecifiedException, RequiredOptionNotSpecifiedException, TriggerIsNotCorrectException;
    void loadSettings(ISettingsSet settings);
    boolean run() throws IncorrectCommandException;

}
