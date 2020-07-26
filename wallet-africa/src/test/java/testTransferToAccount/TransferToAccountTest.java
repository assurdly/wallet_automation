package testTransferToAccount;

import org.testng.annotations.Test;
import testDashboard.DashboardTest;

public class TransferToAccountTest extends DashboardTest {
    //Buy valid airtime successfully
    @Test(dependsOnMethods = {"testLogin.LoginTest.userLogin", "clickBuyAirtimePage"},
            dataProviderClass = testData.userTestData.class, dataProvider = "buyAirtimeData")
    public void BuyAirtime(int provider, String phoneNum, String amount, String pin) throws InterruptedException {
        buyAirtimePage.selectNetworkProvider(provider);
    }
}
