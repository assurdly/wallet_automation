package testBuyAirtime;

import org.testng.annotations.Test;
import testDashboard.DashboardTest;


import static org.testng.Assert.assertEquals;

public class BuyAirtimeTest extends DashboardTest {

    //Buy valid airtime successfully
    @Test(dependsOnMethods = {"testLogin.LoginTest.userLogin", "clickBuyAirtimePage"},
            dataProviderClass = testData.userTestData.class, dataProvider = "buyAirtimeData")
    public void BuyAirtime(int provider,String phoneNum,String amount,String pin) throws InterruptedException
    {
        buyAirtimePage.selectNetworkProvider(provider);
        buyAirtimePage.enterPhoneNumber(phoneNum);
        buyAirtimePage.enterAmount(amount);
        buyAirtimePage.clickBuyAirtimeBtn();
        buyAirtimePage.clickProceed();
        buyAirtimePage.enterTransactionPin(pin);
        buyAirtimePage.clickTransactionButton();
        dashboardPage = buyAirtimePage.clickGoToDashboard();
        //Confirm user is on the dashboard page
        String dashboardUrl = "https://devbusiness.wallets.africa/dashboard";
        assertEquals(dashboardPage.getDashboardPageUrl(),dashboardUrl,"You are not on user dashboard");
    }
}
