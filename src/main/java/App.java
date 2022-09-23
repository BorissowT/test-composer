import commands.*;
import exceptions.*;
import fileLoader.YamlReaderImpl;
import machine.ITestMachine;
import machine.TestMachineImpl;
import settings.ISettingsSet;
import settings.SettingsImpl;

public class App {
    public static void main(String[] args){
        ITestMachine TestMachine = new TestMachineImpl();
        ISettingsSet Settings = new SettingsImpl();
        Settings.addReader(new YamlReaderImpl());

        Settings.addCommand(new AfterCommand());
        InDirectoryCommand inDirectoryCommand = new InDirectoryCommand();
        WithNameCommand withNameCommand = new WithNameCommand();
        FileCountCommand fileCountCommand = new FileCountCommand();
        Settings.addCommand(inDirectoryCommand);
        Settings.addCommand(fileCountCommand);
        Settings.addCommand(new TriggerIdCommand(withNameCommand, inDirectoryCommand, fileCountCommand));
        Settings.addCommand(withNameCommand);

        TestMachine.loadSettings(Settings);

        try {
            TestMachine.inputTestPath("src/main/java/testCases/test1.yaml");
            System.out.println(TestMachine.run());
        } catch (IncorrectCommandException | RequiredFieldIsNotSpecifiedException | RequiredOptionNotSpecifiedException | TriggerIsNotCorrectException | ConstrainArgumentException | LocationException | ComponentException e) {
            e.printStackTrace();
        }
    }
}
