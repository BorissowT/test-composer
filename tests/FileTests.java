import commands.AfterCommand;
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
        TestMachine.loadSettings(Settings);
    }

    @Test
    public void testSuccessful() throws IncorrectCommandException, RequiredFieldIsNotSpecifiedException, RequiredOptionNotSpecifiedException {
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
    public void notCorrectTriggerIdTest() throws RequiredFieldIsNotSpecifiedException, RequiredOptionNotSpecifiedException {
        TestMachine.inputTestPath("tests/samplesToTest/NotCorrectTriggerId.yaml");
        Assertions.assertThrows(TriggerIsNotCorrectException.class, ()->{TestMachine.run();});
    }

    @Test
    public void notCorrectTriggerIdTest2() throws RequiredFieldIsNotSpecifiedException, RequiredOptionNotSpecifiedException {
        TestMachine.inputTestPath("tests/samplesToTest/NotCorrectTriggerId2.yaml");
        Assertions.assertThrows(TriggerIsNotCorrectException.class, ()->{TestMachine.run();});
    }

    @Test
    public void notCorrectTriggerIdTest3() throws RequiredFieldIsNotSpecifiedException, RequiredOptionNotSpecifiedException {
        TestMachine.inputTestPath("tests/samplesToTest/NotCorrectTriggerId3.yaml");
        Assertions.assertThrows(TriggerIsNotCorrectException.class, ()->{TestMachine.run();});
    }

    @Test
    public void notCorrectTriggerIdTest4() throws RequiredFieldIsNotSpecifiedException, RequiredOptionNotSpecifiedException {
        TestMachine.inputTestPath("tests/samplesToTest/NotCorrectTriggerId4.yaml");
        Assertions.assertThrows(TriggerIsNotCorrectException.class, ()->{TestMachine.run();});
    }

    @Test
    public void incorrectCommandsTest() throws RequiredFieldIsNotSpecifiedException, RequiredOptionNotSpecifiedException {
        TestMachine.inputTestPath("tests/samplesToTest/IncorrectCommands.yaml");
        Assertions.assertThrows(IncorrectCommandException.class, ()->{TestMachine.run();});
    }

    @Test
    public void fileCountMinusParameterTest() throws RequiredFieldIsNotSpecifiedException, RequiredOptionNotSpecifiedException {
        TestMachine.inputTestPath("tests/samplesToTest/FileCountMinusParameter.yaml");
        Assertions.assertThrows(ConstrainArgumentException.class, ()->{TestMachine.run();});
    }

    @Test
    public void directoryNotExistsTest() throws RequiredFieldIsNotSpecifiedException, RequiredOptionNotSpecifiedException {
        TestMachine.inputTestPath("tests/samplesToTest/DirectoryNotExists.yaml");
        Assertions.assertThrows(LocationException.class, ()->{TestMachine.run();});
    }

    @Test
    public void directoryNotExistsTest2() throws RequiredFieldIsNotSpecifiedException, RequiredOptionNotSpecifiedException {
        TestMachine.inputTestPath("tests/samplesToTest/DirectoryNotExists2.yaml");
        Assertions.assertThrows(LocationException.class, ()->{TestMachine.run();});
    }

    @Test
    public void afterTooBigParameterTest() throws RequiredFieldIsNotSpecifiedException, RequiredOptionNotSpecifiedException {
        TestMachine.inputTestPath("tests/samplesToTest/AfterTooBigParameter.yaml");
        Assertions.assertThrows(ConstrainArgumentException.class, ()->{TestMachine.run();});
    }

    @Test
    public void afterMinusParameterTest() throws RequiredFieldIsNotSpecifiedException, RequiredOptionNotSpecifiedException {
        TestMachine.inputTestPath("tests/samplesToTest/AfterMinusParameter.yaml");
        Assertions.assertThrows(ConstrainArgumentException.class, ()->{TestMachine.run();});
    }
}
