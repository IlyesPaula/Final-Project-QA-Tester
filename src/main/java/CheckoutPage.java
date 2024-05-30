import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CheckoutPage extends BasePage {

    public WebDriverWait wait;

    public CheckoutPage(WebDriver driver) {

        super(driver);
        wait = new WebDriverWait(driver, 30);
    }

    @FindBy(linkText = "Awesome Metal Chair")
    private WebElement productMetalChair;

    public void clickProductMetalChair() {
        productMetalChair.click();
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

    @FindBy(css = ".btn.btn-success")
    private WebElement checkoutButton;

    public void clickCheckoutButton() {
        checkoutButton.click();
    }

    @FindBy(id = "first-name")
    private WebElement firstNameField;

    public WebElement getFirstNameField() {
        return firstNameField;
    }

    public void enterFirstName() {
        firstNameField.sendKeys("Margareta");
    }

    @FindBy(id = "last-name")
    private WebElement lastNameField;

    public WebElement getLastNameField() {
        return lastNameField;
    }

    public void enterLastName() {
        lastNameField.sendKeys("Daniela");
    }

    @FindBy(id = "address")
    private WebElement addressField;

    public WebElement getAddressField() {
        return addressField;
    }

    public void enterAddress() {
        addressField.sendKeys("strada Lalelor nr 25 jud. Cluj");
    }

    @FindBy(css = ".error")
    private WebElement fieldError;

    public WebElement getFieldError() {
        return fieldError;
    }

    @FindBy(css = ".form-check")
    private WebElement paymentInformation;

    public void getPaymentInformation() {
        paymentInformation.click();
    }

    @FindBy(css = ".btn.btn-success")
    private WebElement continueCheckoutButton;

    public void clickContinueCheckoutButton() {
        continueCheckoutButton.click();
    }

    @FindBy(css = ".btn.btn-success")
    private WebElement completeYourOrderButton;

    public void clickCompleteYourOrderButton() {
        completeYourOrderButton.click();
    }

    @FindBy(css = ".text-center")
    private WebElement pageTitle;

    public WebElement getPageTitle() {
        return pageTitle;
    }


    @FindBy(xpath = "(//td[@class='amount'])[1]")
    private WebElement itemPrice;
    @FindBy(xpath = "(//td[@class='amount'])[2]")
    private WebElement taxPrice;
    @FindBy(xpath = "(//td[@class='amount'])[3]")
    private WebElement totalPrice;


    public double productPrice() {
        String amountValue = itemPrice.getText();
        String cleanAmountValue = amountValue.replace("$", "");
        return Double.parseDouble(cleanAmountValue);
    }


    public double taxPrice() {
        String taxValue = taxPrice.getText();
        String cleanTaxValue = taxValue.replace("$", "");
        return Double.parseDouble(cleanTaxValue);
    }

    public double totalPrice() {
        String totalValue = totalPrice.getText();
        String cleanTotalValue = totalValue.replace("$", "");
        return Double.parseDouble(cleanTotalValue);
    }

    @FindBy(css = ".svg-inline--fa.fa-plus-circle.fa-w-16 ")
    private WebElement plusQuantity;

    public void clickPlusQuantity() {
        plusQuantity.click();
    }

    @FindBy(linkText = "Awesome Soft Shirt")
    private WebElement awesomeSoftShirtProduct;

    public void clickAwesomeSoftShirtProduct() {
        awesomeSoftShirtProduct.click();
    }

    public WebElement getAwesomeSoftShirtProduct() {
        return awesomeSoftShirtProduct;
    }

    @FindBy(linkText = "Incredible Concrete Hat")
    private WebElement incredibleConcreteHatProduct;

    public void clickIncredibleConcreteHatProduct() {
        incredibleConcreteHatProduct.click();
    }

    @FindBy(css = ".svg-inline--fa.fa-shopping-bag.fa-w-14.fa-3x.brand-logo")
    private WebElement homePageButton;

    public void clickHomePageButton() {
        homePageButton.click();
    }


    @FindBy(xpath = "(//td[@class='amount'])[1]")
    private WebElement shirtProduct;

    @FindBy(xpath = "(//td[@class='amount'])[1]")
    private WebElement hatProduct;

    @FindBy(xpath = "(//td[@class='amount'])[3]")
    private WebElement totalPrice1;

    public double shirtPrice() {
        String amountValue = shirtProduct.getText();
        String cleanAmountValue = amountValue.replace("$", "");
        return Double.parseDouble(cleanAmountValue);
    }

    public double hatPrice() {
        String amountValue = hatProduct.getText();
        String cleanAmountValue = amountValue.replace("$", "");
        return Double.parseDouble(cleanAmountValue);
    }

    public double totalPrice1() {
        String totalValue = totalPrice1.getText();
        String cleanTotalValue = totalValue.replace("$", "");
        return Double.parseDouble(cleanTotalValue);
    }

    @FindBy(css = ".svg-inline--fa.fa-minus-circle.fa-w-16 ")
    private WebElement minusQuantity;

    public void clickMinusQuantityButton() {
        minusQuantity.click();
    }

    @FindBy(css = ".svg-inline--fa.fa-trash.fa-w-14 ")
    private WebElement trashBinButton;

    public void clickTrashBinButton() {
        trashBinButton.click();
    }

    @FindBy(css = ".text-center.container")
    private WebElement textContainer;

    public WebElement getTextContainer() {
        return textContainer;
    }


    @FindBy(css = ".svg-inline--fa.fa-heart.fa-w-16.fa-3x ")
    private WebElement heartIcon;

    public void clickHeartIcon() {
        heartIcon.click();
    }

    @FindBy(css = ".svg-inline--fa.fa-heart.fa-w-16 ")
    private WebElement wishlistIcon;

    public void clickWishlistIcon() {
        wishlistIcon.click();
    }

    @FindBy(css = ".text-muted")
    private WebElement wishlistTitle;

    public WebElement getWishlistTitle() {
        return wishlistTitle;
    }

    @FindBy(css = ".svg-inline--fa.fa-heart-broken.fa-w-16.fa-2x ")
    private WebElement heartButton;

    public void clickHeartButton() {
        heartButton.click();
    }


    @FindBy(css=".fa-layers-counter.shopping_cart_badge")
    private WebElement wishlistCounterBadge;

    public WebElement getWishlistCounterBadge(){
        return wishlistCounterBadge;
    }
    @FindBy(css = ".svg-inline--fa.fa-undo.fa-w-16 ")
    private WebElement refreshPageButton;

    public void clickRefreshPageButton() {
        refreshPageButton.click();
    }
}
