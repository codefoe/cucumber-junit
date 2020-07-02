package utility;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    @Before
    public void setup(Scenario scenario) {
        // Anything that you want to run before each Scenario]

        ExtentReport.startTest(scenario.getName());
    }
    @After
    public void asdf(Scenario scenario) {
        System.out.println("Steps by second after");
        if(scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.instance()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
            ExtentReport.fail();
        }else{
            ExtentReport.pass();
        }
        Driver.closeDriver();
    }
}
