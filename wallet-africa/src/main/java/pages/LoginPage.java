package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By email_field = By.xpath("//input[@formcontrolname = 'email']");
    private By password_field = By.xpath("//input[@formcontrolname = 'password']");
    private By sign_in = By.xpath("//div[@class='login-form']//button[text()='Sign In']");

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    //Locate email field and enter user email address
    public void enterUserEmail(String emailAddress)
    {
        driver.findElement(email_field).sendKeys(emailAddress);
    }

    //Locate the password field and enter user password
    public void enterUserPassword(String password)
    {
        driver.findElement(password_field).sendKeys(password);
    }

    //Click on Sign in button
    public DashboardPage clickSignInButton() throws InterruptedException
    {
        driver.findElement(sign_in).click();
        Thread.sleep(5000);
        return new DashboardPage(driver);
    }

    //Confirm user is in Sign in page
    public String getLoginPageUrl()
    {
        return driver.getCurrentUrl();
    }
}
