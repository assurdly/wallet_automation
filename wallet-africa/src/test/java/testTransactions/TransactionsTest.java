package testTransactions;

import org.testng.annotations.Test;
import testDashboard.DashboardTest;

public class TransactionsTest extends DashboardTest {

    //View a Transaction
    @Test(dependsOnMethods = {"testLogin.LoginTest.userLogin","testDashboard.DashboardTest.clickTransactions"})
    public void viewTransaction() throws InterruptedException
    {
        transactionsPage.clickTransactionReference();
        transactionsPage.clickCloseButton();
    }

    //View all transactions (By confirming the search , date, category fields and search button are present)
    @Test(dependsOnMethods = {"testLogin.LoginTest.userLogin","testDashboard.DashboardTest.clickTransactions"})
    public void viewAllTransactions()
    {
        System.out.println(transactionsPage.checkElementsPresence());
    }

    // Search transaction by category (just one category test is fine)
    @Test(dependsOnMethods = {"testLogin.LoginTest.userLogin","testDashboard.DashboardTest.clickTransactions"},
            dataProviderClass = testData.userTestData.class, dataProvider = "userCategoryData")
    public void searchByCategory(String categoryValue) throws InterruptedException
    {
        transactionsPage.selectTransactionType(categoryValue);
        transactionsPage.clickSearchBtn();
    }

    // Search by Date
    @Test(dependsOnMethods = {"testLogin.LoginTest.userLogin","testDashboard.DashboardTest.clickTransactions"},
            dataProviderClass = testData.userTestData.class, dataProvider = "transactionData")
    public void searchByDate(String startDate, String endDate) throws InterruptedException
    {
        transactionsPage.selectStartDate(startDate);
        transactionsPage.selectEndDate(endDate);
        transactionsPage.clickSearchBtn();
    }

    // Export Transaction History
    @Test(dependsOnMethods = {"testLogin.LoginTest.userLogin","testDashboard.DashboardTest.clickTransactions"})
    public void exportTransaction() throws InterruptedException
    {
        //variables for export format
        int excel = 1, csv =2, pdf = 3;
        transactionsPage.toggleExportDropDown();
        transactionsPage.clickExportFormat(csv);
    }

    //Report a transaction
    @Test(dependsOnMethods = {"testLogin.LoginTest.userLogin","testDashboard.DashboardTest.clickTransactions"},
            dataProviderClass = testData.userTestData.class, dataProvider = "reasonData")
    public void reportTransaction(String reason) throws InterruptedException
    {

        transactionsPage.clickTransactionReference();
        transactionsPage.clickReportButton();
        transactionsPage.enterReason(reason);
        transactionsPage.clickReportButton();
        //Comment this function out if going to dashboard after entering reason
        //transactionsPage.clickCloseButton();
        //Comment these functions below if closing test after entering reason
        transactionsPage.clickGoToDashboard();
        dashboardPage.getDashboardPageUrl();
    }
}
