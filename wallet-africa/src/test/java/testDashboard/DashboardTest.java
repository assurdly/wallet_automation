package testDashboard;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import testLogin.LoginTest;

import static org.testng.Assert.assertEquals;

public class DashboardTest extends LoginTest {
    //Page handlers
    public static BuyAirtimePage buyAirtimePage;
    public static RequestMoneyPage requestMoneyPage;
    public static SettingsPage settingsPage;
    public static SubWalletPage subWalletPage;
    public static TransactionsPage transactionsPage;


    //Set the test to depend on the login method
    @Test (dependsOnMethods = {"testLogin.LoginTest.userLogin"})
    public void viewDashboard() throws InterruptedException
    {
        //Confirm that user is in dashboard using URL
        String dashboardUrl = "https://devbusiness.wallets.africa/dashboard";
        assertEquals(dashboardPage.getDashboardPageUrl(),dashboardUrl,"You are not on user dashboard");
        //Display wallet balance
        String walletBalance = dashboardPage.getWalletBalance();
        System.out.println("Users available balance: " + walletBalance);
        //Display count of users recent transactions
        int recentTransactions = dashboardPage.getRecentTransactions();
        System.out.println("Count of recent transactions: " + recentTransactions);
        //Display count of total transactions
        int transactionSummary = dashboardPage.getTransactionSummary();
        System.out.println("Transaction summary count: " + transactionSummary);
        //Display users account number
        String accountNumber = dashboardPage.getAccountNumber();
        System.out.println("User Account Number: " + accountNumber);

        /*Fail test if recent transactions is greater than 10*/
        int maxRecentTransactions = 10;
        if (recentTransactions > maxRecentTransactions)
        {
            Assert.fail("The total number of transactions cannot be lower than the recent transactions");
        }
    }

    @Test(dependsOnMethods = {"testLogin.LoginTest.userLogin"})
    public void viewTransactionSummary()
    {
        //Enter 1 for Today, 2 for Yesterday & 3 for This month
        int period = 3;
        //Select transaction period
        dashboardPage.togglePeriod(period);

        //Transaction count based on transaction period
        int transactionSummary = dashboardPage.getTransactionSummary();
        System.out.println("Transaction summary count: " + transactionSummary);

        //Display Inflow based on selected period
        String inflow = dashboardPage.getInflow();
        System.out.println("Inflow: "+ inflow);

        //Display Outflow based on selected period
        String outflow = dashboardPage.getOutflow();
        System.out.println("Outflow: "+ outflow);
    }

    @Test(dependsOnMethods = {"testLogin.LoginTest.userLogin"})
    public void getOverdraft() throws InterruptedException
    {
        //Click over draft button
        dashboardPage.clickOverdraftButton();
        //Click close button
        dashboardPage.closeModal();
    }

    //View more transactions
    @Test (dependsOnMethods = {"testLogin.LoginTest.userLogin"})
    public void clickViewMoreButton()
    {
        transactionsPage = dashboardPage.clickViewMore();
        String actualUrl = transactionsPage.viewAllTransactions();
        String expectedUrl = "https://devbusiness.wallets.africa/transactions";
        assertEquals(actualUrl,expectedUrl, "This is not the transactions page");
    }

    @Test (dependsOnMethods = {"testLogin.LoginTest.userLogin"})
    public void viewProfile() throws InterruptedException
    {
        settingsPage = dashboardPage.clickProfile();
        //Verify that user is on Settings page
        String settingsPageURL = "https://devbusiness.wallets.africa/settings";
        assertEquals(settingsPage.getSettingsPageUrl(),settingsPageURL,"You are not on the Settings page");
    }

    @Test (dependsOnMethods = {"testLogin.LoginTest.userLogin"})
    public void logout() throws InterruptedException
    {
        //Log user out
        loginPage = dashboardPage.logOut();
        //Confirm user is in sign in page
        String signInPageUrl = "https://devbusiness.wallets.africa/login";
        assertEquals(loginPage.getLoginPageUrl(),signInPageUrl,"You are not on the sign in page");
    }

    @Test
    public void clickSubWalletsMenu() throws InterruptedException
    {
      subWalletPage = dashboardPage.subWallets();
    }

    @Test
    public void clickRequestMoneyPage() throws InterruptedException
    {
        requestMoneyPage = dashboardPage.requestMoney();
    }

    @Test
    public void clickBuyAirtimePage() throws InterruptedException
    {
        buyAirtimePage = dashboardPage.buyAirtime();
    }

    @Test
    public void clickSettings() throws InterruptedException
    {
        settingsPage = dashboardPage.clickSettingsMenu();
    }

    @Test
    public void clickTransactions() throws InterruptedException
    {
        transactionsPage = dashboardPage.clickTransactionsMenu();
    }

    //--------User Tests--------
    //Fund wallet with debit card
    @Test (dependsOnMethods = {"testLogin.LoginTest.userLogin"})
    public void fundWalletDebitCard() throws InterruptedException
    {
        String amount = "5000";
        String cardNumber = "5288422204274926";
        String date = "062020";
        String cvv = "293";
        String pin = "1234";
        dashboardPage.clickFundYourWallet();
        dashboardPage.clickDebitCardBtn();
        dashboardPage.enterCardAmount(amount);
        dashboardPage.enterCardNumber(cardNumber);
        dashboardPage.enterExpiryDate(date);
        dashboardPage.enterCVV(cvv);
        dashboardPage.enterPin(pin);
        dashboardPage.tickSaveCard();
        dashboardPage.clickFundWallet();
    }

    //Fund Wallet BitCoin
    @Test (dependsOnMethods = {"testLogin.LoginTest.userLogin"})
    public void fundWalletBitCoin() throws InterruptedException
    {
        String amount = "5000";
        dashboardPage.clickFundYourWallet();
        dashboardPage.clickBitCoinBtn();
        dashboardPage.enterAmountToFund(amount);
        dashboardPage.clickFundWallet();
        dashboardPage.clickVerify();
        System.out.println(dashboardPage.getVerificationMsg());
        dashboardPage.clickCopyCryptoBtn();
        dashboardPage.clickClose();
    }
}
