package SignUp;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.SignUpPage;

public class SignUpTest extends BasePage{

    SignUpPage hello = new SignUpPage(WebDriver driver);
    @Test
    public void userSignUp() throws InterruptedException {
        loginPage.clickSignUpButton();



    }



    }



}



