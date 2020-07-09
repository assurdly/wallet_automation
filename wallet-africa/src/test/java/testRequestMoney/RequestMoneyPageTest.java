package testRequestMoney;

import org.testng.annotations.Test;
import testDashboard.DashboardTest;

public class RequestMoneyPageTest extends DashboardTest {

    //Create new request
    @Test(dependsOnMethods = {"testLogin.LoginTest.userLogin", "clickRequestMoneyPage"},
            dataProviderClass = testData.userTestData.class, dataProvider = "requestMoneyData")
    public void createNewRequest(String name, String link,String amount, String note, String description) throws InterruptedException
    {
        requestMoneyPage.clickNewRequest();
        requestMoneyPage.enterRequestName(name);
        requestMoneyPage.enterPaymentLink(link);
        requestMoneyPage.tickFixedAmtBox();
        requestMoneyPage.enterFixedAmt(amount);
        requestMoneyPage.enterThankYouNote(note);
        requestMoneyPage.enterDescription(description);
        requestMoneyPage.clickCreateLink();
        System.out.println(requestMoneyPage.validateRequest(name));
    }

    //Copy Link
    @Test(dependsOnMethods = {"testLogin.LoginTest.userLogin", "clickRequestMoneyPage"},
            dataProviderClass = testData.userTestData.class, dataProvider = "requestLinkData")
    public void clickCopy(int requestLinkId)
    {
        requestMoneyPage.clickLinkBtn(requestLinkId);
        requestMoneyPage.clickCopyLink();
    }

    //Delete List
    @Test(dependsOnMethods = {"testLogin.LoginTest.userLogin", "clickRequestMoneyPage"},
            dataProviderClass = testData.userTestData.class, dataProvider = "requestLinkData")
    public void clickDelete(int requestLinkId) throws InterruptedException
    {
        requestMoneyPage.clickLinkBtn(requestLinkId);
        requestMoneyPage.clickDeleteList();
    }

    //Visit Link
    @Test(dependsOnMethods = {"testLogin.LoginTest.userLogin", "clickRequestMoneyPage"},
            dataProviderClass = testData.userTestData.class, dataProvider = "requestLinkData")
    public void clickVisit(int requestLinkId)
    {
        requestMoneyPage.clickLinkBtn(requestLinkId);
        requestMoneyPage.clickVisitLink();
    }

}
