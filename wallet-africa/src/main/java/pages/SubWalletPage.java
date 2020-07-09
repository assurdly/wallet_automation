package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SubWalletPage {
    private WebDriver driver;
    private By newSubWalletBtn = By.cssSelector("div.btns>button:nth-child(1)");
    private By firstName= By.cssSelector(".cardForm >div:nth-child(2)>input");
    private By lastName = By.cssSelector(".cardForm >div:nth-child(3)>input");
    private By email = By.cssSelector(".cardForm >div:nth-child(4)>input");
    private By dob= By.xpath("//input[@formcontrolname='dob']");
    private By addSubWalletBtn = By.cssSelector("div.form-group>button.btn");
    private By viewUsersBtn =By.cssSelector(".form-group>button.btn-primary:nth-child(1)");
    private By accountName = By.cssSelector("div.col-6:nth-child(1) > p:nth-child(2)");
    private By accountName2 = By.cssSelector("tbody>tr:nth-child(1)>td:nth-child(1)");
    private By firstSubWallet = By.cssSelector("tr:nth-child(1)>td:nth-child(1)");
    private By walletBalance = By.cssSelector("div.balance>p.value");
    private By fundBtn = By.cssSelector(".buttonGroup>div:nth-child(1)>button");
    private By dAmtField =By.xpath("//input[@formcontrolname='amount']");
    private By fundUserBtn = By.xpath("//button[text()='Fund user']");
    private By trFieldPin = By.xpath("//input[@placeholder='Transaction PIN']");
    private By authTransBtn = By.cssSelector("button.btn:nth-child(3)");
    private By withdrawBtn = By.cssSelector(".buttonGroup>div:nth-child(2)>button");
    private By wAmtField = By.xpath("//input[@formcontrolname='amount']");
    private By withdrawButton= By.cssSelector(".cardForm>button:nth-child(3)");


    public SubWalletPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void clickNewSubWallet(){
        driver.findElement(newSubWalletBtn).click();
    }
    public void enterFirstName(String sFirstName)
    {
        driver.findElement(firstName).sendKeys(sFirstName);
    }

    public void enterLastName(String sLastName)
    {
        driver.findElement(lastName).sendKeys(sLastName);
    }

    public void enterEmail(String sEmail)
    {
        driver.findElement(email).sendKeys(sEmail);
    }

    public void enterDOB(String sDOB)
    {
        driver.findElement(dob).click();
        driver.findElement(dob).sendKeys(sDOB);
    }

    public void clickAddSubWallet()
    {
        driver.findElement(addSubWalletBtn).click();
    }

    public String getAccountHoldersName()
    {
        return driver.findElement(accountName).getText();
    }

    public void clickViewUsers()
    {
        driver.findElement(viewUsersBtn).click();
    }

    //Account holders name that displays on user table after page reloads
    public String getAccountHoldersName2()
    {
        return driver.findElement(accountName2).getText();
    }

    public void clickSubWallet() throws InterruptedException
    {
        driver.findElement(firstSubWallet).click();
        Thread.sleep(5000);
    }

    public String getWalletBalance()
    {
        return driver.findElement(walletBalance).getText();
    }

    public void clickFundButton()
    {
        driver.findElement(fundBtn).click();
    }

    public void enterDepositAmount(String amount) throws InterruptedException
    {
        driver.findElement(dAmtField).sendKeys(amount);
        Thread.sleep(3000);
    }

    public void clickFundUserBtn()
    {
        driver.findElement(fundUserBtn).click();
    }

    public void enterTransactionPin(String pin)
    {
        driver.findElement(trFieldPin).sendKeys(pin);
    }

    public void clickAuthorizeBtn() throws InterruptedException
    {
        driver.findElement(authTransBtn).click();
        Thread.sleep(5000);
    }

    public void clickWithdrawBtn() throws InterruptedException
    {
        driver.findElement(withdrawBtn).click();
        Thread.sleep(3000);
    }

    public void enterWithdrawalAmt(String amount)
    {
        driver.findElement(wAmtField).sendKeys(amount);
    }

    public void clickWithdraw() throws InterruptedException
    {
        driver.findElement(withdrawButton).click();
        Thread.sleep(3000);
    }
}
