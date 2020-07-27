package testWalletFundwithBtc;

import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.WalletFundWithBtcPage;
import testDashboard.DashboardTest;
import testLogin.LoginTest;

public class WalletFundWithBtcTest extends LoginTest {


    @Test (dependsOnMethods = {"testLogin.LoginTest.userLogin"})
    public void fundWithBtc() throws InterruptedException {
       DashboardPage hello = new DashboardPage();
       hello.clickPlusSign();




    }
}
