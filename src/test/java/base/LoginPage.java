package base;


import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utility.Framework;

public class LoginPage extends BasePage {

    @FindBy(css = "a[href='/login']")
    public WebElement signIn;
    @FindBy(name="login")
    public WebElement username;

    @FindBy(name="password")
    public WebElement password;
    @FindBy(name="commit")
    public WebElement submit;

    public void login() {
        driver.get(baseUrl);
        String title = driver.getTitle();
        Assert.assertTrue(signIn.isDisplayed());
        signIn.click();
        Assert.assertTrue(username.isDisplayed());
        Assert.assertTrue(password.isDisplayed());
        Assert.assertTrue(submit.isEnabled());
        username.sendKeys(Framework.get("githubCreds.username"));
        password.sendKeys(Framework.get("githubCreds.password"));
        submit.click();
    }

    public void login(String url) {
        driver.get(url);
        String title = driver.getTitle();
        Assert.assertTrue(signIn.isDisplayed());
        signIn.click();
        Assert.assertTrue(username.isDisplayed());
        Assert.assertTrue(password.isDisplayed());
        Assert.assertTrue(submit.isEnabled());
        username.sendKeys(Framework.get("githubCreds.username"));
        password.sendKeys(Framework.get("githubCreds.password"));
        submit.click();
        driver.get(url);

    }

}
