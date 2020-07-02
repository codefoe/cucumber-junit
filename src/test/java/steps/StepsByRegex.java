package steps;


import base.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utility.Driver;


public class StepsByRegex {
    LoginPage loginPage = new LoginPage();
    @Given("I launch {string}")
    public void launch(String url) {
       Driver.instance().get("https://"+ url);
        String title = Driver.instance().getTitle();
        Assert.assertTrue(url.contains(title));
    }

    @Given("^browser launches (.*)$")
    public void browserLaunches(String str) throws InterruptedException {
       loginPage.login("https://"+str);
    }

    @And("^responseBody([\\.\\w]*) ==(?:[ ]*)([^ ].*)$")
    public void responsebodyUrlBody(String valueOf, String expected) throws InterruptedException {
       loginPage.login();
    }


    @Given("I am authorized")
    public void iAmAuthorized() {

    }
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


