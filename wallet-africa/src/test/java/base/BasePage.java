package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import pages.LoginPage;
import pages.SignUpPage;

import java.util.concurrent.TimeUnit;

public class BasePage {
    private static WebDriver driver;
    public static LoginPage loginPage;
    private static SignUpPage signUpPage;
    String chromePath = "src/main/resources/chromedriver.exe";
    String firefoxPath = "src/main/resources/geckodriver.exe";
    String url ="https://devbusiness.wallets.africa/login";

    @BeforeSuite
    public void setUp() throws Exception
    {
        //Browser added for sake of test, remove after complete test
        String browser;
        browser = "chrome";
        //browser = "firefox";

       if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver",firefoxPath);
            driver = new FirefoxDriver();
        }
        else if (browser.equalsIgnoreCase("chrome")) {
        System.setProperty("webdriver.chrome.driver",chromePath);
        driver = new ChromeDriver();
        }
        else{
            //If no browser passed throw exception
            throw new Exception ("Browser entered is not correct");
        }
        //open and maximize browser
        driver.manage().window().maximize();
        //Go to Website
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @BeforeClass
    public static void pageHandler()
    {
        loginPage = new LoginPage(driver);
        signUpPage = new SignUpPage(driver);
    }


    @AfterSuite
    public void tearDown()
    {
        driver.quit();
    }
}
