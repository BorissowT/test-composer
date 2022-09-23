package machine;

import exceptions.*;
import settings.ISettingsSet;

public interface ITestMachine {
    void inputTestPath(String path) throws RequiredFieldIsNotSpecifiedException, RequiredOptionNotSpecifiedException, TriggerIsNotCorrectException, ComponentException;
    void loadSettings(ISettingsSet settings);
    boolean run() throws IncorrectCommandException, ConstrainArgumentException, LocationException;

}
