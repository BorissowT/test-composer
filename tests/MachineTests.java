import machine.ITestMachine;
import machine.TestMachineImpl;
import org.junit.Test;
import settings.ISettingsSet;
import settings.SettingsImpl;

public class MachineTests {
    @Test
    public void testSuccessful(){
        ITestMachine TestMachine = new TestMachineImpl();
        ISettingsSet Settings = new SettingsImpl();

        TestMachine.loadSettings(Settings);
        TestMachine.readTestFile("tests/samplesToTest/test1.yaml");
        TestMachine.run();
    }
}
