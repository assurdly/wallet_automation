package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CardsPage {

    private WebDriver driver;
    private By newPhysicalCardBtn = By.cssSelector(".btns>button:nth-child(1)");
    private By newVirtualCardBtn = By.cssSelector(".btns>button:nth-child(2)");

    public CardsPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void clickNewPhysicalCard() throws InterruptedException
    {
        driver.findElement(newPhysicalCardBtn).click();
        Thread.sleep(3000);
    }

    public void clickNewVirtualCard() throws InterruptedException
    {
       driver.findElement(newVirtualCardBtn).click();
        Thread.sleep(3000);
    }
}
