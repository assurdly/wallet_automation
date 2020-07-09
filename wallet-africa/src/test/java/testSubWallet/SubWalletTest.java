package testSubWallet;

import org.testng.annotations.Test;
import testDashboard.DashboardTest;

public class SubWalletTest extends DashboardTest {

    @Test (dependsOnMethods = {"testLogin.LoginTest.userLogin"})
    public void clickSubWalletsMenu() throws InterruptedException
    {
        subWalletPage = dashboardPage.subWallets();
    }

    //Create a sub wallet
    @Test(dependsOnMethods = {"testLogin.LoginTest.userLogin", "clickSubWalletsMenu"},
            dataProviderClass = testData.userTestData.class, dataProvider = "subWalletData")
    public void createNewSubWallet(String firstName, String lastName, String email ,String dob) throws InterruptedException
    {
        subWalletPage.clickNewSubWallet();
        subWalletPage.enterFirstName(firstName);
        subWalletPage.enterLastName(lastName);
        subWalletPage.enterEmail(email);

        subWalletPage.enterDOB(dob);
        Thread.sleep(5000);
        subWalletPage.clickAddSubWallet();

        /* Condition 1. unusable data because - unable to assert test because
        page does not reload after wallet has been created
        String expAccHolder = subWalletPage.getAccountHoldersName();*/
        subWalletPage.clickViewUsers();

        /* Refer to condition 1 above
        String acctHolder = subWalletPage.getAccountHoldersName2();
        assertEquals(acctHolder,expAccHolder,"account holder does not match");*/
    }

    //View a subWallet
    @Test(dependsOnMethods = {"testLogin.LoginTest.userLogin", "clickSubWalletsMenu"})
    public void viewASubWallet() throws InterruptedException
    {
        subWalletPage.clickSubWallet();
    }

    //Fund Sub wallet
    @Test(dependsOnMethods = {"testLogin.LoginTest.userLogin", "clickSubWalletsMenu"},
            dataProviderClass = testData.userTestData.class, dataProvider = "fundWalletData")
    public void fundWallet(String amount , String pin) throws InterruptedException
    {
        subWalletPage.clickSubWallet();
        String oldWalletBalance = subWalletPage.getWalletBalance();
        subWalletPage.clickFundButton();
        subWalletPage.enterDepositAmount(amount);
        subWalletPage.clickFundUserBtn();
        subWalletPage.enterTransactionPin(pin);
        subWalletPage.clickAuthorizeBtn();
        String newWalletBalance = subWalletPage.getWalletBalance();

        System.out.println("Previous balance: "+oldWalletBalance+"\nCurrent balance: "+newWalletBalance);
    }

    //Withdraw from Sub Wallet
    @Test(dependsOnMethods = {"testLogin.LoginTest.userLogin", "clickSubWalletsMenu"},
            dataProviderClass = testData.userTestData.class, dataProvider = "withdrawFromWalletData")
    public void withdrawFromSubWallet(String amount) throws InterruptedException
    {
        subWalletPage.clickSubWallet();
        String oldWalletBalance = subWalletPage.getWalletBalance();
        subWalletPage.clickWithdrawBtn();
        subWalletPage.enterWithdrawalAmt(amount);
        subWalletPage.clickWithdraw();
        String newWalletBalance = subWalletPage.getWalletBalance();
        System.out.println("Previous balance: "+oldWalletBalance+"\nCurrent balance: "+newWalletBalance);
    }
}
