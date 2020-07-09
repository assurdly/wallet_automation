package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class BuyAirtimePage {

    private WebDriver driver;
    private By networkProviderDrop = By.id("networkProvider");
    private By phoneNumber = By.cssSelector(".inputanderror:nth-child(3)>input");
    private By amount = By.cssSelector(".inputanderror:nth-child(4)>input");
    private By buyAirtimeBtn = By.cssSelector(".ng-touched>button:nth-child(5)");
    private By proceedBtn = By.cssSelector(".buttonGroup>div:nth-child(2)>.btn-primary");
    private By transactionPinF = By.cssSelector(".form-control");
    private By authorizeTransactionBtn = By.cssSelector(".form-card>button");
    private By goToDashboardBtn = By.xpath("//button[text()='Go to Dashboard']");

    public BuyAirtimePage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void selectNetworkProvider(int id)
    {
        Select networkProvider = new Select(driver.findElement(networkProviderDrop));
        networkProvider.selectByValue(String.valueOf(id - 1));
    }

    public void enterPhoneNumber(String num)
    {
        driver.findElement(phoneNumber).sendKeys(num);
    }

    public void enterAmount(String amt)
    {
        driver.findElement(amount).sendKeys(amt);
    }
    public void clickBuyAirtimeBtn() throws InterruptedException
    {
        driver.findElement(buyAirtimeBtn).click();
        Thread.sleep(3000);
    }

    public void clickProceed() throws InterruptedException
    {
        driver.findElement(proceedBtn).click();
        Thread.sleep(3000);
    }

    public void enterTransactionPin(String pin)
    {
        driver.findElement(transactionPinF).sendKeys(pin);
    }

    public void clickTransactionButton() throws InterruptedException
    {
        driver.findElement(authorizeTransactionBtn).click();
        Thread.sleep(3000);
    }

    public DashboardPage clickGoToDashboard() throws InterruptedException
    {
        driver.findElement(goToDashboardBtn).click();
        Thread.sleep(5000);
        return new DashboardPage(driver);
    }

}
