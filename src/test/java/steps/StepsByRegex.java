package steps;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class StepsByRegex {
    @Given("^browser launches (.*)$")
    public void browser_logs_in_to_Google_com(String str) {
        System.out.println(str);
    }

    @And("^responseBody([\\.\\w]*) ==(?:[ ]*)([^ ].*)$")
    public void responsebodyUrlBody(String valueOf, String expected) {
        System.out.println(valueOf + "\n" + expected);

    }
}


