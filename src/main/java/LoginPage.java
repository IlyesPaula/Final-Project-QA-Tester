import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    public WebDriverWait wait;

    public LoginPage(WebDriver driver) {

        super(driver);
        wait = new WebDriverWait(driver, 30);
    }

    @FindBy(css = ".svg-inline--fa.fa-sign-in-alt.fa-w-16")
    private WebElement signInButton;

    public void clickSignInButton() {
        signInButton.click();
    }

    @FindBy(id = "user-name")
    private WebElement userNameField;


    public void enterYourUserName() {
        userNameField.sendKeys("dino");
    }

    @FindBy(id = "user-name")
    private WebElement userNameField2;


    public void enterYourUserName2(String pass) {
        userNameField.sendKeys(pass);
    }

    @FindBy(id = "password")
    private WebElement passwordField;


    public void enterYourPassword(String pass) {
        passwordField.sendKeys(pass);
    }

    @FindBy(css = ".btn.btn-primary")
    private WebElement clickLoginButton;

    public void clickLoginButton() {
        clickLoginButton.click();
    }

    @FindBy(linkText = "dino")
    private WebElement correctName;

    public WebElement getCorrectName() {
        return correctName;
    }

    @FindBy(css = ".error")
    private WebElement loginError;

    public WebElement getLoginError() {
        return loginError;
    }

@FindBy (linkText = "Hello guest! ")
    private WebElement logoutAffirmation;

    public WebElement getLogoutAffirmation() {
        return logoutAffirmation;
    }




}
