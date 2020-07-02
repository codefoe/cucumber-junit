package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import utility.ExtentReport;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
        "pretty", "html:target/cucumber.html",
        "json:target/cucumber.json","extent:target/report.html"
        },
        features = "src/test/resources/features",
        glue = "steps")
public class ParallelRunner {
        @AfterClass
        public static void tearDown(){
                ExtentReport.endReport();
        }
}