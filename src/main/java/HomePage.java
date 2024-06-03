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

    public void enterObjectToSearch(String pass) {
        inputSearch.sendKeys(pass);
    }

    @FindBy(css = ".btn.btn-light.btn-sm")
    private WebElement searchButton;

    public void clickSearchButton() {
        searchBox.click();
    }

    @FindBy(linkText = "Awesome Metal Chair")
    private WebElement awesomeMetalChairProduct;

    public WebElement getAwesomeMetalChairProduct() {
        return awesomeMetalChairProduct;
    }

    @FindBy(linkText = "Awesome Granite Chips")
    private WebElement awesomeGraniteChipsProduct;

    public WebElement getAwesomeGraniteChipsProduct() {
        return awesomeGraniteChipsProduct;
    }

    @FindBy(linkText = "Awesome Soft Shirt")
    private WebElement awesomeSoftShirtProduct;

    public void clickAwesomeSoftShirtProduct() {
        awesomeSoftShirtProduct.click();
    }

    public WebElement getAwesomeSoftShirtProduct() {
        return awesomeSoftShirtProduct;
    }


    @FindBy(css = ".svg-inline--fa.fa-cart-plus.fa-w-18.fa-3x")
    private WebElement addProductToCartButton;

    public void clickAddProductToCartButton() {
        addProductToCartButton.click();
    }

    @FindBy(css = ".shopping-cart-icon.fa-layers.fa-fw")
    private WebElement shoppingCartIcon;

    public void clickShoppingCartIcon() {
        shoppingCartIcon.click();
    }

    @FindBy(css = ".svg-inline--fa.fa-shopping-bag.fa-w-14.fa-3x.brand-logo")
    private WebElement homePageButton;

    public void clickHomePageButton() {
        homePageButton.click();
    }

    @FindBy(css = ".subheader-container")
    private WebElement homePageTitle;

    public WebElement getHomePageTitle() {
        return homePageTitle;
    }


    @FindBy(linkText = "Gorgeous Soft Pizza")
    private WebElement gorgeousSoftPizzaProduct;

    public WebElement getGorgeousSoftPizzaProduct() {
        return gorgeousSoftPizzaProduct;
    }

    @FindBy(linkText = "Incredible Concrete Hat")
    private WebElement incredibleConcreteHatProduct;

    public WebElement getIncredibleConcreteHatProduct() {
        return incredibleConcreteHatProduct;
    }

    @FindBy(linkText = "Licensed Steel Gloves")
    private WebElement licensedSteelGlovesProduct;

    public WebElement getLicensedSteelGlovesProduct() {
        return licensedSteelGlovesProduct;
    }

    @FindBy(linkText = "Practical Metal Mouse")
    private WebElement practicalMetalMouseProduct;

    public WebElement getPracticalMetalMouseProduct() {
        return practicalMetalMouseProduct;
    }

    @FindBy(linkText = "Practical Wooden Bacon")
    private WebElement practicalWoodenBaconProduct;

    public WebElement getPracticalWoodenBacon() {
        return practicalWoodenBaconProduct;
    }


    @FindBy(linkText = "Refined Frozen Mouse")
    private WebElement refinedFrozenMouseProduct;

    public WebElement getRefinedFrozenMouseProduct() {
        return refinedFrozenMouseProduct;
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

    @FindBy(css = ".svg-inline--fa.fa-question.fa-w-12 ")
    private WebElement helpButton;

    public void clickHelpButton() {
        helpButton.click();
    }

    @FindBy(css = ".modal-title.h4")
    private WebElement helpTitle;

    public WebElement getHelpTitle() {
        return helpTitle;
    }


    @FindBy(css = ".svg-inline--fa.fa-undo.fa-w-16 ")
    private WebElement resetPageButton;

    public void clickResetPageButton() {
        resetPageButton.click();
    }

    @FindBy(css=".fa-layers-counter.shopping_cart_badge")
    private WebElement shoppingCartCounterBadge;

    public WebElement getShoppingCartCounterBadge(){
        return shoppingCartCounterBadge;
    }

    public void selectOption(WebElement element, String option) {
        Select optionSelect = new Select(element);
        optionSelect.selectByVisibleText(option);
    }
}