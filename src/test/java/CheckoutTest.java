import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


@Listeners(ExtentTestNGITestListener.class)

public class CheckoutTest extends Hooks {

    public CheckoutPage checkoutPage;
    public WebDriverWait wait;

    @BeforeMethod
    public void SetupPageObject() {
        checkoutPage = new CheckoutPage(driver);
        wait = new WebDriverWait(driver, 10);
    }

    @Test(description = "Testing the Checkout Test functionality")
    public void checkoutTest() throws InterruptedException {
        checkoutPage.clickProductMetalChair();
        checkoutPage.clickAddProductToCartButton();
        checkoutPage.clickShoppingCartIcon();
        checkoutPage.clickCheckoutButton();
        checkoutPage.enterFirstName();
        checkoutPage.enterLastName();
        checkoutPage.enterAddress();
        checkoutPage.getPaymentInformation();
        checkoutPage.clickContinueCheckoutButton();
        checkoutPage.clickCompleteYourOrderButton();
        assertEquals("Thank you for your order!", checkoutPage.getPageTitle().getText());

    }

    @Test(description = "This test verifies the error message for when the user leaves empty the first name field")
    public void checkFirstNameIsMandatory() throws InterruptedException {
        checkoutPage.clickProductMetalChair();
        checkoutPage.clickAddProductToCartButton();
        checkoutPage.clickShoppingCartIcon();
        checkoutPage.clickCheckoutButton();
        checkoutPage.enterLastName();
        checkoutPage.enterAddress();
        checkoutPage.getPaymentInformation();
        checkoutPage.clickContinueCheckoutButton();
        checkoutPage.clickCompleteYourOrderButton();
        assertEquals(checkoutPage.getFieldError().getText(), "First Name is required");
    }

    @Test(description = "This test verifies the error message for when the user leaves empty the last name field")
    public void checkLastNameIsMandatory() {
        checkoutPage.clickProductMetalChair();
        checkoutPage.clickAddProductToCartButton();
        checkoutPage.clickShoppingCartIcon();
        checkoutPage.clickCheckoutButton();
        checkoutPage.enterFirstName();
        checkoutPage.enterAddress();
        checkoutPage.getPaymentInformation();
        checkoutPage.clickContinueCheckoutButton();
        checkoutPage.clickCompleteYourOrderButton();
        assertEquals(checkoutPage.getFieldError().getText(), "Last Name is required");
    }

    @Test(description = "This test verifies the error message for when the user leaves empty the address field")
    public void checkAddressIsMandatory() {
        checkoutPage.clickProductMetalChair();
        checkoutPage.clickAddProductToCartButton();
        checkoutPage.clickShoppingCartIcon();
        checkoutPage.clickCheckoutButton();
        checkoutPage.enterFirstName();
        checkoutPage.enterLastName();
        checkoutPage.getPaymentInformation();
        checkoutPage.clickContinueCheckoutButton();
        checkoutPage.clickCompleteYourOrderButton();
        assertEquals(checkoutPage.getFieldError().getText(), "Address is required");
    }

    @Test(description = "Changing quantity test. Asserting that the price is updated correctly.")
    public void quantityTest() {
        checkoutPage.clickProductMetalChair();
        checkoutPage.clickAddProductToCartButton();
        checkoutPage.clickShoppingCartIcon();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The price of the product is : " + checkoutPage.productPrice());
        double expectedTotal = checkoutPage.productPrice() * 2;
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The price of the product after updating should be : " + expectedTotal);
        checkoutPage.clickPlusQuantity();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The price of the product after updating is: " + checkoutPage.productPrice());
        assertEquals(checkoutPage.productPrice(), expectedTotal);
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The price of the product after updating is matching the expected price");
    }

    @Test(description = "Calculating the price of a product with taxes")
    public void totalPriceCalculationTest() {
        checkoutPage.clickProductMetalChair();
        checkoutPage.clickAddProductToCartButton();
        checkoutPage.clickShoppingCartIcon();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The price of the product is : " + checkoutPage.productPrice());
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The tax of the product is : " + checkoutPage.taxPrice());
        double expectedTotal = checkoutPage.productPrice() + checkoutPage.taxPrice();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The expected total should be : " + expectedTotal);
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The actual total is : " + checkoutPage.totalPrice());
        assertEquals(checkoutPage.totalPrice(), expectedTotal);
    }


    @Test(description = "Calculating the price for two different products")
    public void totalPriceCalculationTestForTwoDifferentProducts() throws InterruptedException {
        checkoutPage.clickAwesomeSoftShirtProduct();
        checkoutPage.clickAddProductToCartButton();
        checkoutPage.clickHomePageButton();
        checkoutPage.clickIncredibleConcreteHatProduct();
        checkoutPage.clickAddProductToCartButton();
        checkoutPage.clickShoppingCartIcon();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The price of the first product is : " + checkoutPage.shirtPrice());
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The price of the second product is : " + checkoutPage.hatPrice());
        double expectedTotal = checkoutPage.shirtPrice() + checkoutPage.hatPrice();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The expected total should be : " + expectedTotal);
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The actual total is : " + checkoutPage.totalPrice1());
        assertEquals(checkoutPage.totalPrice1(), expectedTotal);
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The price of the shirt is not seen by the page, only the hat price is calculated");

    }

    @Test(description = "Testing 'the minus quantity button' functionality")
    public void minusQuantityTest() {
        checkoutPage.clickAwesomeSoftShirtProduct();
        checkoutPage.clickAddProductToCartButton();
        checkoutPage.clickShoppingCartIcon();
        checkoutPage.clickMinusQuantityButton();
        assertEquals("How about adding some products in your cart?", checkoutPage.getTextContainer().getText());
    }
}
