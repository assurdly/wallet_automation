package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
    private WebDriver driver;
    private By create_account = By.xpath("//a[contains(text(),'Create an account')]");
    private By select_for_personal_use = By.xpath("//p[contains(text(),'Wallet for your personal use.')]");


    public SignUpPage(WebDriver driver)
    {
        this.driver = driver;
    }

    //Select create account


    public void setCreate_account(By create_account) {
        this.create_account = create_account;
        driver.findElement(create_account).click();
    }

    public void setSelect_for_personal_use(By select_for_personal_use){
        this.select_for_personal_use = select_for_personal_use;
        driver.findElement(select_for_personal_use).click();
    }


    }



