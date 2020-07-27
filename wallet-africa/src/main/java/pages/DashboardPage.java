package pages;

import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DashboardPage {

    private WebDriver driver;

    //Side Menu
    private By buyAirtimeMenu = By.xpath("//ul[@class='nav']//li[@class='nav-item']//a[text()='Buy Airtime']");
    private By cardsMenu = By.cssSelector("//ul[@class='nav']//li[@class='nav-item']//a[text()='Cards']");
    private By requestMoneyMenu = By.xpath("//ul[@class='nav']//li[@class='nav-item']//a[text()='Request Money']");
    private By settingsMenu = By.xpath("//ul[@class='nav']//li[@class='nav-item']//a[text()='Settings']");
    private By subWalletsMenu = By.cssSelector("div.sidebar-main>ul>li:nth-child(2)>a");
    private By transactionsMenu = By.xpath("//ul[@class='nav']//li[@class='nav-item']//a[text()='Transactions']");
    //List of WebElements
    private By logout = By.cssSelector("li.logout:nth-child(2) > a:nth-child(1)");
    private By walletBalance = By.xpath("//div[@class='walletBalance']//p[@class='value']");
    private By transactions = By.cssSelector(".table > tbody:nth-child(2) > tr");
    private By transactionsSummary = By.cssSelector(".transactions > p:nth-child(2)");
    private By accountNumber = By.id("accountnumber");
    private By outflow = By.cssSelector("div .amount-spent > p:nth-child(2)");
    private By inflow = By.cssSelector("div .amount-received > p:nth-child(2)");
    private By periodDropDown = By.cssSelector("select#dashboard-chart-select");
    private By profile = By.cssSelector("ul.main-navbar-profile>li.profile>a.image-container > img:nth-child(1)");
    private By getOverdraftBtn = By.cssSelector(".button-container >button:nth-child(1)");
    private By notificationModal = By.cssSelector("div.modal-body");
    private By closeModalBtn = By.cssSelector("div.claim>button:nth-child(4)");
    private By viewMoreBtn = By.xpath("//a[@class='view-more-link']");
    private By fundYourWalletBtn = By.cssSelector(".acc-details>.button-container>.btn-outline-success");
    private By debitCardBtn = By.cssSelector(".cardForm>button:nth-child(2)");
    private By bitCoinBtn = By.cssSelector(".cardForm>button:nth-child(3)");
    private By cardAmountField = By.xpath("//input[@type='number']");
    private By cardNumberField = By.xpath("//input[@formcontrolname='cardNumber']");
    private By expDateField = By.id("cc-exp-date");
    private By cvvField = By.id("cc-cvc");
    private By pinField = By.xpath("//input[@formcontrolname='pin']");
    private By saveCardBox = By.id("saveCard");
    private By amountToFundField = By.cssSelector(".cardForm>div:nth-child(2)>input");
    private By fundWalletBtn = By.xpath("//button[text()='Fund Wallet']");
    private By verifyLink = By.cssSelector(".value>.verify");
    private By verificationMessage = By.cssSelector(".success>small");
    private By copyCryptoBtn = By.cssSelector(".form-group:nth-child(2)>button");
    private By closeBtn = By.cssSelector(".form-group:nth-child(1)>button");
    private By plusSign = By.xpath("//img[@class='fundimg']");




    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public DashboardPage() {

    }

    //Confirm the dashboard URL
    public String getDashboardPageUrl() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, 30);
        //wait until URL is visible
        wait.until(ExpectedConditions.urlToBe("https://devbusiness.wallets.africa/dashboard"));
        Thread.sleep(5000);
        return driver.getCurrentUrl();
    }

    //Fund wallet
    public void clickPlusSign() throws InterruptedException {
        driver.findElement(plusSign).click();
        Thread.sleep(5000);
    }

    //View should contain user balance
    public String getWalletBalance() {
        return driver.findElement(walletBalance).getText();
    }

    //Top 10 recent transactions
    public int getRecentTransactions() {
        List<WebElement> totalTransaction = driver.findElements(transactions);
        //Return the total count of transactions
        return totalTransaction.size();
    }

    //Summary of transactions on the account
    public int getTransactionSummary() {
        //Convert summary value to int
        return Integer.parseInt(driver.findElement(transactionsSummary).getText());
    }

    // Account number
    public String getAccountNumber() {
        return driver.findElement(accountNumber).getText();
    }

    //Toggle transaction summary for today, yesterday and this month
    public void togglePeriod(int period) {
        period -= 1;
        String value = Integer.toString(period);

        Select transactionPeriod = new Select(driver.findElement(periodDropDown));
        transactionPeriod.selectByValue(value);
    }

    //Display outflow
    public String getOutflow() {
        return driver.findElement(outflow).getText();
    }

    //Display inflow
    public String getInflow() {
        return driver.findElement(inflow).getText();
    }

    public TransactionsPage clickViewMore() {
        driver.findElement(viewMoreBtn).click();
        return new TransactionsPage(driver);
    }


    /* Verify overdraft button is present & when you clicked on it, confirm the modal display*/
    public void clickOverdraftButton() throws InterruptedException {
        driver.findElement(getOverdraftBtn).click();
        Thread.sleep(5000);
    }

    public void closeModal() {
        WebElement modal = driver.findElement(notificationModal);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(modal));
        driver.findElement(closeModalBtn).click();
    }

    //User should be directed to the Settings page
    public SettingsPage clickProfile() throws InterruptedException {
        driver.findElement(profile).click();
        Thread.sleep(5000);
        return new SettingsPage(driver);
    }

    public LoginPage logOut() throws InterruptedException {
        /*Upon clicking on the logout button, user should be logged out
        from the account successfully and directed to the sign in page*/
        driver.findElements(logout).get(0).click();
        Thread.sleep(5000);
        return new LoginPage(driver);
    }

    public SubWalletPage subWallets() throws InterruptedException {
        driver.findElement(subWalletsMenu).click();
        Thread.sleep(5000);
        return new SubWalletPage(driver);
    }

    public RequestMoneyPage requestMoney() throws InterruptedException {
        driver.findElement(requestMoneyMenu).click();
        Thread.sleep(5000);
        return new RequestMoneyPage(driver);
    }

    public BuyAirtimePage buyAirtime() throws InterruptedException {
        driver.findElement(buyAirtimeMenu).click();
        Thread.sleep(5000);
        return new BuyAirtimePage(driver);
    }

    public SettingsPage clickSettingsMenu() throws InterruptedException {
        driver.findElement(settingsMenu).click();
        Thread.sleep(5000);
        return new SettingsPage(driver);
    }

    public TransactionsPage clickTransactionsMenu() throws InterruptedException {
        driver.findElement(transactionsMenu).click();
        Thread.sleep(5000);
        return new TransactionsPage(driver);
    }

    public CardsPage clickCardsMenu() throws InterruptedException {
        driver.findElement(cardsMenu).click();
        Thread.sleep(5000);
        return new CardsPage(driver);
    }

    public void clickFundYourWallet() {
        driver.findElement(fundYourWalletBtn).click();
    }

    public void clickDebitCardBtn() {
        driver.findElement(debitCardBtn).click();
    }

    public void clickBitCoinBtn() {
        driver.findElement(bitCoinBtn).click();
    }

    public void enterCardAmount(String amount) {
        driver.findElement(cardAmountField).sendKeys(amount);
    }

    public void enterCardNumber(String cardNumber) {
        driver.findElement(cardNumberField).sendKeys(cardNumber);
    }

    public void enterExpiryDate(String date) {
        driver.findElement(expDateField).sendKeys(date);
    }

    public void enterCVV(String cvv) {
        driver.findElement(cvvField).sendKeys(cvv);
    }

    public void enterPin(String pin) {
        driver.findElement(pinField).sendKeys(pin);
    }

    public void tickSaveCard() {
        driver.findElement(saveCardBox).click();
    }

    public void clickFundWallet() throws InterruptedException {
        driver.findElement(fundWalletBtn).click();
        Thread.sleep(5000);
    }

    public void enterAmountToFund(String amount) {
        driver.findElement(amountToFundField).sendKeys(amount);
    }

    public void clickVerify()
    {
        driver.findElement(verifyLink).click();
    }

    public String getVerificationMsg()
    {
        return driver.findElement(verificationMessage).getText();
    }

    public void clickCopyCryptoBtn()
    {
        driver.findElement(copyCryptoBtn).click();
    }

    public void clickClose() throws InterruptedException
    {
        driver.findElement(closeBtn).click();
        Thread.sleep(5000);
    }

}
