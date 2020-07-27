package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WalletFundWithBtcPage {

    private WebDriver driver;
    private By plusSign = By.xpath("//img[@class='fundimg']");
    private By fundWithBtcButton = By.xpath("//button[contains(text(),'Bitcoin')]");
    private By amount = By.xpath("//input[@placeholder='20000']");
    private By fundButton = By.xpath("//button[@class='btn btn-primary btn-block']");




    public void clickBtcBtn ()  {
        driver.findElement(fundWithBtcButton).click();

    }
    public void enterAmount (Integer money) {
        driver.findElement(amount).sendKeys();
        driver.findElement(fundButton).click();
    }
}
