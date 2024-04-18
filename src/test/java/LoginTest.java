import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Listeners(ExtentTestNGITestListener.class)

public class LoginTest extends Hooks {

    public LoginPage loginPage;
    public WebDriverWait wait;

    @BeforeMethod
    public void SetupPageObject() {
        loginPage = new LoginPage(driver);
        wait = new WebDriverWait(driver, 10);
    }

    @Test(description = "Testing login functionality using test data provided")
    public void loginTest() throws InterruptedException {
        loginPage.clickSignInButton();
        loginPage.enterYourUserName();
        loginPage.enterYourPassword("choochoo");
        loginPage.clickLoginButton();
        assertEquals("dino", loginPage.getCorrectName().getText());
    }

    @Test(description = "Testing the login functionality without username")
    public void negativeLoginTest01() {
        loginPage.clickSignInButton();
        loginPage.enterYourPassword("choochoo");
        loginPage.clickLoginButton();
        assertEquals(loginPage.getLoginError().getText(), "Please fill in the username!");
    }

    @Test(description = "Testing the login functionality with a wrong username")
    public void negativeLoginTest02() throws InterruptedException {
        loginPage.clickSignInButton();
        loginPage.enterYourUserName2("Lorena");
        loginPage.enterYourPassword("choochoo");
        loginPage.clickLoginButton();
        assertEquals(loginPage.getLoginError().getText(),"Incorrect username or password!");
    }


}
