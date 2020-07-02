package utility;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    @After
    public void asdf(Scenario scenario) {
        System.out.println("Steps by second after");
        if(scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.instance()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());

        }else{

        }
        Driver.closeDriver();
    }
}
