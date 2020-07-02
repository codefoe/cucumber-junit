package base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utility.Driver;
import utility.Framework;

public class BasePage {
    public final WebDriver driver = Driver.instance();

    public BasePage(){
        PageFactory.initElements(driver,this);
    }

    public String baseUrl = Framework.get("url");
}
