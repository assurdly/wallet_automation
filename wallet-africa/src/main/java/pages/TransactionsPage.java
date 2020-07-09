package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TransactionsPage{

    private WebDriver driver;
    private By exportDropDown = By.id("exportDropdownMenu");
    private By exportDropDownMenu = By.cssSelector(".btns>div:nth-child(2)");
    private By excelReport = By.cssSelector(".btns>.dropdown-menu>button:nth-child(1)");
    private By csvReport = By.cssSelector(".btns>.dropdown-menu>button:nth-child(2)");
    private By PDFReport = By.cssSelector(".btns>.dropdown-menu>button:nth-child(3)");
    private By searchBar = By.cssSelector(".search-bar>input.form-control:nth-child(1)");
    private By startDateField = By.cssSelector(".search-bar>input.form-control:nth-child(2)");
    private By endDateField = By.cssSelector(".search-bar>input.form-control:nth-child(3)");
    private By categoryDropDown = By.id("transactiontypr");
    private By searchBtn = By.xpath("//button[text()='Search']");
    private By trReference = By.cssSelector("tbody>tr:nth-child(1)>.reference");
    private By closeBtn = By.cssSelector(".form-group:nth-child(1)>button");
    private By reportBtn = By.xpath("//button[text()='Report']");
    private By reasonField = By.xpath("//textarea[@formcontrolname='messageBox']");
    private By goToDashboardBtn = By.xpath("//button[text()='Go to Dashboard']");




    public TransactionsPage(WebDriver driver)
    {
        this.driver = driver;
    }

    //Confirm user is on All transactions page
    public String viewAllTransactions()
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlToBe("https://devbusiness.wallets.africa/transactions"));
        return driver.getCurrentUrl();
    }

    public void toggleExportDropDown()
    {
        driver.findElement(exportDropDown).click();
    }

    public void clickExportFormat(int report) throws InterruptedException
    {
        WebElement dropDownMenu = driver.findElement(exportDropDownMenu);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(dropDownMenu));

        switch (report)
        {
            case 1:
                driver.findElement(excelReport).click();
                Thread.sleep(10000);
                break;
            case 2:
                driver.findElement(csvReport).click();
                Thread.sleep(10000);
                break;
            case 3:
                driver.findElement(PDFReport).click();
                Thread.sleep(10000);
                break;
            default: System.out.println("Value entered is incorrect");
                Thread.sleep(10000);
                break;
        }
    }

    public String checkElementsPresence()
    {
        String message = null;
        if(driver.findElement(searchBar).isDisplayed() &&
        driver.findElement(startDateField).isDisplayed() &&
        driver.findElement(endDateField).isDisplayed() &&
        driver.findElement(categoryDropDown).isDisplayed() &&
        driver.findElement(searchBtn).isDisplayed())
        {

            message = "All required elements are present";
        }
        else {message = "Not all element required are present";}

        return message;
    }

    public void selectTransactionType(String category)
    {
        Select transactionType = new Select(driver.findElement(categoryDropDown));
        transactionType.selectByValue(category);
    }

    public void clickSearchBtn() throws InterruptedException
    {
        driver.findElement(searchBtn).click();
        Thread.sleep(5000);
    }

    public void searchTransaction(String transactionReference)
    {
        driver.findElement(searchBar).sendKeys(transactionReference);
    }

    public void selectStartDate(String date)
    {
        driver.findElement(startDateField).click();
        driver.findElement(startDateField).sendKeys(date);
    }

    public void selectEndDate(String date)
    {
        driver.findElement(endDateField).click();
        driver.findElement(endDateField).sendKeys(date);
    }

    public void clickTransactionReference() throws InterruptedException
    {
        driver.findElement(trReference).click();
        Thread.sleep(5000);
    }

    public void clickCloseButton() throws InterruptedException
    {
        driver.findElement(closeBtn).click();
        Thread.sleep(5000);
    }

    public void clickReportButton() throws InterruptedException
    {
        driver.findElement(reportBtn).click();
        Thread.sleep(5000);
    }

    public void enterReason(String reason)
    {
        driver.findElement(reasonField).sendKeys(reason);
    }

    public DashboardPage clickGoToDashboard()
    {
        driver.findElement(goToDashboardBtn).click();
        return new DashboardPage(driver);
    }

}
