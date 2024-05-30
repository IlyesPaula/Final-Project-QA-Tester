import org.openqa.selenium.By;
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


    public void enterYourUserName(String pass) {
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

    @FindBy(css= ".svg-inline--fa.fa-sign-out-alt.fa-w-16")
    private WebElement logoutButton;

    public void clickLogoutButton(){
        logoutButton.click();
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

    @FindBy(xpath = "//*[@id='responsive-navbar-nav']/div[2]/span/span/span")
    private WebElement logoutAffirmation;

    public WebElement getLogoutAffirmation() {
        return logoutAffirmation;
    }

    @FindBy(css = ".svg-inline--fa.fa-undo.fa-w-16 ")
    private WebElement refreshPageButton;

    public void clickRefreshPageButton() {
        refreshPageButton.click();
    }


}
