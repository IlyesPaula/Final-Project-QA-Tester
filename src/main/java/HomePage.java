import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    public WebDriverWait wait;

    public HomePage(WebDriver driver) {

        super(driver);
        wait = new WebDriverWait(driver, 30);
    }

    @FindBy(css = ".mr-auto.form-control.form-control-sm")
    private WebElement searchBox;

    public void clickSearchBox() {
        searchBox.click();
    }

    @FindBy(id = "input-search")
    private WebElement inputSearch;

    public void enterObjectToSearch() {
        inputSearch.sendKeys("Awesome Metal Chair");
    }

    @FindBy(css = ".btn.btn-light.btn-sm")
    private WebElement searchButton;

    public void clickSearchButton() {
        searchBox.click();
    }

    @FindBy(linkText = "Awesome Metal Chair")
    private WebElement productName;

    public WebElement getProductName(){
        return productName;
    }


    @FindBy(css = ".sort-products-select.form-control.form-control-sm")
    private WebElement sortProductsDropDown;

    public WebElement gertSortProductsDropDown() {
        return sortProductsDropDown;
    }

    @FindBy(css = "option[value='az']")
    private WebElement optionAtoZ;

    public WebElement getOptionAtoZ() {
        return optionAtoZ;
    }

    @FindBy(css = "option[value='za']")
    private WebElement optionZtoA;

    public WebElement getOptionZtoA() {
        return optionZtoA;
    }

    @FindBy(css = "option[value='lohi']")
    private WebElement optionLowToHigh;

    public WebElement getOptionLowToHigh() {
        return optionLowToHigh;
    }

    @FindBy(css = "option[value='hilo']")
    private WebElement optionHighToLow;

    public WebElement getOptionHighToLow() {
        return optionHighToLow;
    }


    public void selectOption(WebElement element, String option) {
        Select optionSelect = new Select(element);
        optionSelect.selectByVisibleText(option);
    }
}