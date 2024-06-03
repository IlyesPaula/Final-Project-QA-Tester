import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
        loginPage.enterYourUserName("dino");
        loginPage.enterYourPassword("choochoo");
        loginPage.clickLoginButton();
        assertEquals("dino", loginPage.getCorrectName().getText());
    }


    @Test(description = "Login with the test data provided and resetting the page to see if the user is still connected to his account")
    public void loginAndRefreshPageTest() throws InterruptedException {
        loginPage.clickSignInButton();
        loginPage.enterYourUserName("dino");
        loginPage.enterYourPassword("choochoo");
        loginPage.clickLoginButton();
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.resetPageButton()));
        loginPage.clickResetPageButton();
        assertEquals(loginPage.getLogoutAffirmation().getText(), "Hello guest!");
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The page resets and the user is disconnected");

    }

    @Test(description = "Testing the 'locked out' functionality")
    public void lockedUserLogin(){
        loginPage.clickSignInButton();
        loginPage.enterYourUserName("locked");
        loginPage.enterYourPassword("choochoo");
        loginPage.clickLoginButton();
        assertEquals(loginPage.getLoginError().getText(), "The user has been locked out.");
    }

    @Test(description = "Testing the login functionality without username")
    public void loginTestWithoutUsername() {
        loginPage.clickSignInButton();
        loginPage.enterYourPassword("choochoo");
        loginPage.clickLoginButton();
        assertEquals(loginPage.getLoginError().getText(), "Please fill in the username!");
    }

    @Test(description = "Testing the login functionality with a wrong username")
    public void loginTestWithWrongUsername() throws InterruptedException {
        loginPage.clickSignInButton();
        loginPage.enterYourUserName("Lorena");
        loginPage.enterYourPassword("choochoo");
        loginPage.clickLoginButton();
        assertEquals(loginPage.getLoginError().getText(), "Incorrect username or password!");
    }
    @Test(description = "Testing the login functionality with a wrong password")
    public void loginTestWithWrongPassword() throws InterruptedException {
        loginPage.clickSignInButton();
        loginPage.enterYourUserName("dino");
        loginPage.enterYourPassword("chocho");
        loginPage.clickLoginButton();
        assertEquals(loginPage.getLoginError().getText(), "Incorrect username or password!");
    }

    @Test(description = "Testing the login functionality without password")
    public void loginTestWithoutPassword() throws InterruptedException {
        loginPage.clickSignInButton();
        loginPage.enterYourUserName("dino");
        loginPage.clickLoginButton();
        assertEquals(loginPage.getLoginError().getText(), "Please fill in the password!");
    }

    @Test(description = "Testing the functionality of disconnecting from the account")
    public void logoutTest() throws InterruptedException {
        loginPage.clickSignInButton();
        loginPage.enterYourUserName("dino");
        loginPage.enterYourPassword("choochoo");
        loginPage.clickLoginButton();
        loginPage.clickLogoutButton();
        assertEquals(loginPage.getLogoutAffirmation().getText(),"Hello guest!");
    }


}
