import fileLoader.YamlReaderImpl;
import machine.ITestMachine;
import machine.TestMachineImpl;
import settings.ISettingsSet;
import settings.SettingsImpl;

public class App {
    public static void main(String[] args) {
        ITestMachine TestMachine = new TestMachineImpl(new YamlReaderImpl());
        ISettingsSet Settings = new SettingsImpl();

        TestMachine.loadSettings(Settings);
        TestMachine.inputTestPath("src/testSamples/test1.yaml");
        TestMachine.run();
    }
}
