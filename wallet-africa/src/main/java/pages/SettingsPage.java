package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SettingsPage {

    private WebDriver driver;
    private By editProfileBtn = By.cssSelector("button.btn:nth-child(6)");
    private By businessAddress = By.cssSelector("div.form-group:nth-child(5) > input:nth-child(1)");
    private By city = By.cssSelector("div.form-group:nth-child(6) > input:nth-child(1)");
    private By saveBtn = By.xpath("//button[text()='Save']");
    private By businessAddressProfile = By.xpath("//p[@id='businessAddress']");
    private By cityProfile= By.cssSelector(".d-sm-flex:nth-child(2) > div:nth-child(2) > p:nth-child(2)");
    private By securityTab = By.id("securitySettings-tab");
    private By changePasswordBtn = By.xpath("//button[text()='Change Password']");
    private By oldPasswordField = By.cssSelector(".cardForm>div:nth-child(2)>input");
    private By newPassword1 = By.cssSelector("div.form-group:nth-child(3) > input:nth-child(1)");
    private By newPassword2 = By.cssSelector("div.form-group:nth-child(4) > input:nth-child(1)");
    private By changeBtn = By.cssSelector(".form-group:nth-child(2)>button");
    private By changePinBtn = By.xpath("//button[text()='Change Pin']");
    private By oldPinField = By.cssSelector(".cardForm>div:nth-child(2)>input");
    private By newPinField = By.cssSelector(".cardForm>div:nth-child(3)>input");
    private By reenterNewPinField = By.cssSelector(".cardForm>div:nth-child(4)>input");
    private By acctUpgradeTab = By.id("upgradeSettings-tab");
    private By googlePlayBtn = By.cssSelector(".download-store>a:nth-child(1)>img");
    private By appStoreBtn = By.cssSelector(".download-store>a:nth-child(2)>img");



    public SettingsPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public String getSettingsPageUrl()
    {
        WebDriverWait wait = new WebDriverWait(driver,30);
        //wait until URL is visible
        wait.until(ExpectedConditions.urlToBe("https://devbusiness.wallets.africa/settings"));
        return driver.getCurrentUrl();
    }

    public void clickEditProfile() throws InterruptedException
    {
        driver.findElement(editProfileBtn).click();
        Thread.sleep(3000);
    }

    public void enterBusinessAddress(String address)
    {
        driver.findElement(businessAddress).clear();
        driver.findElement(businessAddress).sendKeys(address);
    }

    public void enterCity(String cityOfBusiness) throws InterruptedException
    {
        driver.findElement(city).clear();
        driver.findElement(city).sendKeys(cityOfBusiness);
        Thread.sleep(3000);
    }

    public void clickSaveBtn() throws InterruptedException
    {
        driver.findElement(saveBtn).click();
        Thread.sleep(7000);
    }

    public String getSetAddress()
    {
        return driver.findElement(businessAddressProfile).getText();
    }

    public String getSetCity()
    {
        return driver.findElement(cityProfile).getText();
    }

    public void clickSecurityTab()
    {
        driver.findElement(securityTab).click();
    }

    public void clickChangePassword() throws InterruptedException
    {
        driver.findElement(changePasswordBtn).click();
        Thread.sleep(3000);
    }

    public void enterOldPassword(String oldPassword)
    {
        driver.findElement(oldPasswordField).clear();
        driver.findElement(oldPasswordField).sendKeys(oldPassword);
    }

    public void enterNewPassword(String newPassword)
    {
        driver.findElement(newPassword1).clear();
        driver.findElement(newPassword1).sendKeys(newPassword);
    }

    public void reenterNewPassword(String newPassword)
    {
        driver.findElement(newPassword2).clear();
        driver.findElement(newPassword2).sendKeys(newPassword);
    }

    public void clickChangeBtn() throws InterruptedException
    {
        driver.findElement(changeBtn).click();
        Thread.sleep(5000);
    }

    public void clickChangePin()
    {
        driver.findElement(changePinBtn).click();
    }

    public void enterOldPin(String oldPin)
    {
        driver.findElement(oldPinField).sendKeys(oldPin);
    }

    public void enterNewPin(String newPin)
    {
        driver.findElement(newPinField).sendKeys(newPin);
    }
    public void reenterNewPin(String newPin)
    {
        driver.findElement(reenterNewPinField).sendKeys(newPin);
    }
    public void clickAccountUpgradeTab(){driver.findElement(acctUpgradeTab).click();}
    public void clickGooglePlayBtn()throws InterruptedException
    {driver.findElement(googlePlayBtn).click();Thread.sleep(3000);}
    public void clickAppStoreBtn()throws InterruptedException
    {driver.findElement(appStoreBtn).click();Thread.sleep(3000);}


}
