package machine;

import exceptions.*;
import settings.ISettingsSet;

public interface ITestMachine {
    void inputTestPath(String path) throws RequiredFieldIsNotSpecifiedException, RequiredOptionNotSpecifiedException, TriggerIsNotCorrectException;
    void loadSettings(ISettingsSet settings);
    boolean run() throws IncorrectCommandException, ConstrainArgumentException;

}
