package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RequestMoneyPage {

    private WebDriver driver;
    private By newRequestBtn = By.cssSelector(".main-content>div:nth-child(1)>div:nth-child(2)>button");
    private By requestNameF = By.cssSelector(".cardForm>div:nth-child(2)>input");
    private By paymentLink = By.id("basic-url");
    private By fixedAmtCheck = By.id("fixedAmountCheck");
    private By fixedAmtField = By.cssSelector("#FixedAmountDiv > input:nth-child(1)");
    private By thankYouNoteF = By.cssSelector("div.form-group:nth-child(5)>.form-control");
    private By descriptionF = By.cssSelector("div.form-group:nth-child(6)>.form-control");
    private By createLinkBtn = By.cssSelector("button.btn:nth-child(7)");
    private By requestName = By.xpath("//p[@class='linkName']");
    private By linkBtn = By.cssSelector("div.dropdown-toggle > i");
    private By visitLink = By.cssSelector(".show>.dropdown-menu>a");
    private By copyLink = By.cssSelector(".show>button:nth-child(2)");
    private By deleteListLink = By.cssSelector(".show>button:nth-child(3)");
    private By deleteBtn = By.cssSelector(".buttonGroup > div:nth-child(2) > button");

    public RequestMoneyPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void clickNewRequest() throws InterruptedException
    {
        driver.findElement(newRequestBtn).click();
        Thread.sleep(3000);
    }

    public void enterRequestName(String name)
    {
        driver.findElement(requestNameF).sendKeys(name);
    }

    public void enterPaymentLink(String link)
    {
        driver.findElement(paymentLink).sendKeys(link);
    }

    public void tickFixedAmtBox()
    {
        driver.findElement(fixedAmtCheck).click();
    }

    public void enterFixedAmt(String amount)
    {
        driver.findElement(fixedAmtField).sendKeys(amount);
    }

    public void enterThankYouNote(String note)
    {
        driver.findElement(thankYouNoteF).sendKeys(note);
    }

    public void enterDescription(String description)
    {
        driver.findElement(descriptionF).sendKeys(description);
    }

    public void clickCreateLink() throws InterruptedException
    {
        driver.findElement(createLinkBtn).click();
        Thread.sleep(5000);
    }

    //Check that request was created successfully
    public String validateRequest(String request)
    {
        List <WebElement> listOfRequests = driver.findElements(requestName);
        String rName, message = "";
        int i = 0;

        for(WebElement requestNames: listOfRequests)
        {
            rName = requestNames.getText();
            if(request.equalsIgnoreCase(rName) )
            {
                message = "The request named "+request+" was created successfully";
                break;
            }
            else if(i == listOfRequests.size() && (!request.equalsIgnoreCase(rName)))
            {
                message = "The request was not created successfully";
                break;
            }
            i++;
        }
        return message;
    }

    public void clickLinkBtn(int reqId)
    {
        driver.findElements(linkBtn).get(reqId).click();
    }

    public void clickVisitLink()
    {
        driver.findElement(visitLink).click();
    }

    public void clickCopyLink()
    {
        driver.findElement(copyLink).click();
    }

    public void clickDeleteList() throws InterruptedException
    {
        driver.findElement(deleteListLink).click();
        Thread.sleep(3000);
        driver.findElement(deleteBtn).click();
        Thread.sleep(5000);
    }
}
