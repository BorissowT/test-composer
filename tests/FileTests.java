import fileLoader.YamlReaderImpl;
import machine.ITestMachine;
import machine.TestMachineImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import settings.ISettingsSet;
import settings.SettingsImpl;

public class FileTests {
    ITestMachine TestMachine;
    ISettingsSet Settings;

    @BeforeAll
    public void setup() {
        this.TestMachine = new TestMachineImpl(new YamlReaderImpl());
        this.Settings = new SettingsImpl();
        TestMachine.loadSettings(Settings);
    }

    @Test
    public void testSuccessful(){
        TestMachine.inputTestPath("tests/samplesToTest/test1.yaml");

        Assert.assertTrue(TestMachine.run());
    }
}
