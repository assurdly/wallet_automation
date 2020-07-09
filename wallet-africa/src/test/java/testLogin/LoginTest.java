package testLogin;

import base.BasePage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.DashboardPage;

public class LoginTest extends BasePage {
    public static DashboardPage dashboardPage;

    @Test(dataProviderClass = testData.userTestData.class, dataProvider = "signInData")
    public void userLogin(String emailAddress, String password) throws InterruptedException
    {
        //Enter email address
        loginPage.enterUserEmail(emailAddress);
        //Enter Password
        loginPage.enterUserPassword(password);
        //Click Sign In button
        dashboardPage = loginPage.clickSignInButton();
    }

}
