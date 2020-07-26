package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
    private WebDriver driver;
    private By select_for_personal_use = By.xpath("//p[contains(text(),'Wallet for your personal use.')]");


    public SignUpPage(WebDriver driver)
    {
        this.driver = driver;
    }



    //Select for Personal Use
    public void selectPersonalUseButton() throws InterruptedException {
        driver.findElement(select_for_personal_use).click();
        Thread.sleep(5000);


    }

    }



