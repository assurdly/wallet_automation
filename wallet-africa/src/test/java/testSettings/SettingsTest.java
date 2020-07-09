package testSettings;

import org.testng.annotations.Test;
import testDashboard.DashboardTest;

import static org.testng.Assert.assertEquals;

public class SettingsTest extends DashboardTest {


    //Edit a profile business address
    @Test(dependsOnMethods = {"testLogin.LoginTest.userLogin","testDashboard.DashboardTest.clickSettings"},
    dataProviderClass = testData.userTestData.class, dataProvider = "userProfileData")
    public void editBusinessAddress(String address, String city) throws InterruptedException
    {
        settingsPage.clickEditProfile();
        settingsPage.enterBusinessAddress(address);
        settingsPage.enterCity(city);
        settingsPage.clickSaveBtn();
        assertEquals(settingsPage.getSetAddress(),address,"The address don't match");
        assertEquals(settingsPage.getSetCity(),city,"The cities don't match");
    }

    //Change Password
    @Test(dependsOnMethods = {"testLogin.LoginTest.userLogin","testDashboard.DashboardTest.clickSettings"},
            dataProviderClass = testData.userTestData.class, dataProvider = "userPasswordData")
    public void changePassword(String oldPassword, String newPassword1, String newPassword2) throws InterruptedException
    {
        settingsPage.clickSecurityTab();
        settingsPage.clickChangePassword();
        settingsPage.enterOldPassword(oldPassword);
        settingsPage.enterNewPassword(newPassword1);
        settingsPage.reenterNewPassword(newPassword2);
        settingsPage.clickChangeBtn();
        //Success message too fast, difficult to get and assert the message
    }

    //Change PIN
    @Test(dependsOnMethods = {"testLogin.LoginTest.userLogin","testDashboard.DashboardTest.clickSettings"},
            dataProviderClass = testData.userTestData.class, dataProvider = "userPinData")
    public void changePin(String oldPin, String newPin, String newPin2) throws InterruptedException
    {
        settingsPage.clickSecurityTab();
        settingsPage.clickChangePin();
        settingsPage.enterOldPin(oldPin);
        settingsPage.enterNewPin(newPin);
        settingsPage.reenterNewPin(newPin2);
        settingsPage.clickChangeBtn();
        //Success message too fast, difficult to get and assert the message
    }

    //Get Wallet Africa on Play store
    @Test(dependsOnMethods = {"testLogin.LoginTest.userLogin","testDashboard.DashboardTest.clickSettings"})
    public void getItOnGoogle() throws InterruptedException
    {
        settingsPage.clickAccountUpgradeTab();
        settingsPage.clickGooglePlayBtn();
    }

    //Get Wallet Africa on app store
    @Test(dependsOnMethods = {"testLogin.LoginTest.userLogin","testDashboard.DashboardTest.clickSettings"})
    public void getItOnAppStore() throws InterruptedException
    {
        settingsPage.clickAccountUpgradeTab();
        settingsPage.clickAppStoreBtn();
    }

}
