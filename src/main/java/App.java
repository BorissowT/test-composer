import machine.ITestMachine;
import machine.TestMachineImpl;
import settings.ISettingsSet;
import settings.SettingsImpl;

public class App {
    public static void main(String[] args) {
        ITestMachine TestMachine = new TestMachineImpl();
        ISettingsSet Settings = new SettingsImpl();

        TestMachine.loadSettings(Settings);
        TestMachine.readTestFile("src/testSamples/test1.yaml");
        TestMachine.run();
    }
}
