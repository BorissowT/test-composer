import commands.*;
import exceptions.*;
import fileLoader.YamlReaderImpl;
import machine.ITestMachine;
import machine.TestMachineImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import settings.ISettingsSet;
import settings.SettingsImpl;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FileTests {
    ITestMachine TestMachine;
    ISettingsSet Settings;

    @BeforeAll
    public void setup() {
        TestMachine = new TestMachineImpl();
        this.Settings = new SettingsImpl();
        Settings.addReader(new YamlReaderImpl());

        Settings.addCommand(new AfterCommand());
        InDirectoryCommand inDirectoryCommand = new InDirectoryCommand();
        WithNameCommand withNameCommand = new WithNameCommand();
        FileCountCommand fileCountCommand = new FileCountCommand();
        Settings.addCommand(fileCountCommand);
        Settings.addCommand(inDirectoryCommand);
        Settings.addCommand(new TriggerIdCommand(withNameCommand, inDirectoryCommand, fileCountCommand));
        Settings.addCommand(withNameCommand);

        TestMachine.loadSettings(Settings);
    }

    @Test
    public void testFail() throws IncorrectCommandException, RequiredFieldIsNotSpecifiedException, RequiredOptionNotSpecifiedException, TriggerIsNotCorrectException, ConstrainArgumentException, LocationException, ComponentException {
        TestMachine.inputTestPath("tests/samplesToTest/testFalse.yaml");
        Assertions.assertFalse(TestMachine.run());
    }

    // 2 files in folder
    @Test
    public void testSuccessful() throws IncorrectCommandException, RequiredFieldIsNotSpecifiedException, RequiredOptionNotSpecifiedException, TriggerIsNotCorrectException, ConstrainArgumentException, LocationException, ComponentException {
        TestMachine.inputTestPath("tests/samplesToTest/test1.yaml");
        Assertions.assertTrue(TestMachine.run());
    }

    @Test
    public void fileCreatedHasNoRequiredFieldsTest(){
        Assertions.assertThrows(RequiredFieldIsNotSpecifiedException.class, ()->{TestMachine.inputTestPath("tests/samplesToTest/FileCreatedHasNoRequiredFieldsTest.yaml");});
    }

    @Test
    public void fileCountHasNoRequiredFieldsTest() {
        Assertions.assertThrows(RequiredFieldIsNotSpecifiedException.class, ()->{TestMachine.inputTestPath("tests/samplesToTest/FileCountHasNoRequiredFieldsTest.yaml");});
    }

    @Test
    public void noWhenOptionTest() {

        Assertions.assertThrows(RequiredOptionNotSpecifiedException.class, ()->{TestMachine.inputTestPath("tests/samplesToTest/NoWhenOption.yaml");});
    }

    @Test
    public void noThenOptionTest() {
        Assertions.assertThrows(RequiredOptionNotSpecifiedException.class, ()->{TestMachine.inputTestPath("tests/samplesToTest/NoThenOption.yaml");});
    }

    @Test
    public void notCorrectTriggerIdTest() {

        Assertions.assertThrows(TriggerIsNotCorrectException.class, ()->{TestMachine.inputTestPath("tests/samplesToTest/NotCorrectTriggerId.yaml");});
    }

    @Test
    public void notCorrectTriggerIdTest2() throws RequiredFieldIsNotSpecifiedException, RequiredOptionNotSpecifiedException {

        Assertions.assertThrows(TriggerIsNotCorrectException.class, ()->{TestMachine.inputTestPath("tests/samplesToTest/NotCorrectTriggerId2.yaml");});
    }

    @Test
    public void notCorrectTriggerIdTest3() throws RequiredFieldIsNotSpecifiedException, RequiredOptionNotSpecifiedException {

        Assertions.assertThrows(TriggerIsNotCorrectException.class, ()->{TestMachine.inputTestPath("tests/samplesToTest/NotCorrectTriggerId3.yaml");});
    }

    @Test
    public void notCorrectTriggerIdTest4() throws RequiredFieldIsNotSpecifiedException, RequiredOptionNotSpecifiedException {

        Assertions.assertThrows(TriggerIsNotCorrectException.class, ()->{TestMachine.inputTestPath("tests/samplesToTest/NotCorrectTriggerId4.yaml");});
    }

    @Test
    public void incorrectCommandsTest() throws RequiredFieldIsNotSpecifiedException, RequiredOptionNotSpecifiedException, TriggerIsNotCorrectException, ComponentException {
        TestMachine.inputTestPath("tests/samplesToTest/IncorrectCommands.yaml");
        Assertions.assertThrows(IncorrectCommandException.class, ()->{TestMachine.run();});
    }

    @Test
    public void fileCountMinusParameterTest() throws RequiredFieldIsNotSpecifiedException, RequiredOptionNotSpecifiedException, TriggerIsNotCorrectException, ComponentException {
        TestMachine.inputTestPath("tests/samplesToTest/FileCountMinusParameter.yaml");
        Assertions.assertThrows(ConstrainArgumentException.class, ()->{TestMachine.run();});
    }

    @Test
    public void directoryNotExistsTest() throws RequiredFieldIsNotSpecifiedException, RequiredOptionNotSpecifiedException, TriggerIsNotCorrectException, ComponentException {
        TestMachine.inputTestPath("tests/samplesToTest/DirectoryNotExists.yaml");
        Assertions.assertThrows(LocationException.class, ()->{TestMachine.run();});
    }

    @Test
    public void directoryNotExistsTest2() throws RequiredFieldIsNotSpecifiedException, RequiredOptionNotSpecifiedException, TriggerIsNotCorrectException, ComponentException {
        TestMachine.inputTestPath("tests/samplesToTest/DirectoryNotExists2.yaml");
        Assertions.assertThrows(LocationException.class, ()->{TestMachine.run();});
    }

    @Test
    public void afterTooBigParameterTest() throws RequiredFieldIsNotSpecifiedException, RequiredOptionNotSpecifiedException, TriggerIsNotCorrectException, ComponentException {
        TestMachine.inputTestPath("tests/samplesToTest/AfterTooBigParameter.yaml");
        Assertions.assertThrows(ConstrainArgumentException.class, ()->{TestMachine.run();});
    }

    @Test
    public void afterMinusParameterTest() throws RequiredFieldIsNotSpecifiedException, RequiredOptionNotSpecifiedException, TriggerIsNotCorrectException, ComponentException {
        TestMachine.inputTestPath("tests/samplesToTest/AfterMinusParameter.yaml");
        Assertions.assertThrows(ConstrainArgumentException.class, ()->{TestMachine.run();});
    }
}
