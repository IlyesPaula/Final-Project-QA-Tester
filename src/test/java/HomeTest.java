import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Listeners(ExtentTestNGITestListener.class)

public class HomeTest extends Hooks {

    public HomePage homePage;
    public WebDriverWait wait;


    @BeforeMethod
    public void SetupPageObject() {
        homePage = new HomePage(driver);
        wait = new WebDriverWait(driver, 30);
    }

    @Test(description = "Testing the 'HomePage button' functionality")
    public void homePageButton() {
        homePage.clickAwesomeSoftShirtProduct();
        homePage.clickAddProductToCartButton();
        homePage.clickShoppingCartIcon();
        homePage.clickHomePageButton();
        assertEquals(homePage.getHomePageTitle().getText(), "Products");
    }
    @Test(description = "Testing the 'Help button' functionality")
    public void helpButonTest() throws InterruptedException {
        homePage.clickHelpButton();
        wait.until(ExpectedConditions.visibilityOf(homePage.getHelpTitle()));
        assertEquals(homePage.getHelpTitle().getText(), "Help");
    }

    @Test(description = "Testing the 'search box' functionality with the full name of one product")
    public void searchBoxTest() throws InterruptedException {
        homePage.clickSearchBox();
        homePage.enterObjectToSearch("Awesome Metal Chair");
        homePage.clickSearchButton();
        assertEquals(homePage.getAwesomeMetalChairProduct().getText(), "Awesome Metal Chair");
    }

    @Test(description = "Testing the 'search box' functionality with partial text from one product")
    public void partialSearchBoxTest() throws InterruptedException {
        homePage.clickSearchBox();
        homePage.enterObjectToSearch("Chips");
        homePage.clickSearchButton();
        assertEquals(homePage.getAwesomeGraniteChipsProduct().getText(), "Awesome Granite Chips");
    }

    @Test(description = "Adding one product to cart and resetting the page to see if the shopping cart counter badge is still having the product the user add")
    public void resetPageButtonTest() throws InterruptedException {
        homePage.clickAwesomeSoftShirtProduct();
        homePage.clickAddProductToCartButton();
        homePage.clickResetPageButton();
        try {
            WebElement element = driver.findElement(By.cssSelector(".fa-layers-counter.shopping_cart_badge"));

            Assert.assertFalse(element.isDisplayed(), "The element should not be visible.");
        } catch (org.openqa.selenium.NoSuchElementException e) {
            Assert.assertTrue(true, "The element is not present in the DOM, so it is not visible.");
        }
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The page resets and the counter badge is not having the product that has been add");
    }


    @Test(description = "This test verifies the sorting box functionality from A to Z produce")
    public void checkSortingProductsFromAtoZ() throws InterruptedException {
        homePage.selectOption(homePage.gertSortProductsDropDown(), "Sort by name (A to Z)");
        assertEquals(homePage.getOptionAtoZ().getText(), "Sort by name (A to Z)");
    }

    @Test(description = "This test verifies the sorting box functionality from Z to A produce")
    public void checkSortingProductsFromZtoA() throws InterruptedException {
        homePage.selectOption(homePage.gertSortProductsDropDown(), "Sort by name (Z to A)");
        assertEquals(homePage.getOptionZtoA().getText(), "Sort by name (Z to A)");
    }

    @Test(description = "This test verifies the sorting box functionality from Low to High price")
    public void checkSortingProductsFromLowToHigh() throws InterruptedException {
        homePage.selectOption(homePage.gertSortProductsDropDown(), "Sort by price (low to high)");
        assertEquals(homePage.getOptionLowToHigh().getText(), "Sort by price (low to high)");
    }

    @Test(description = "This test verifies the sorting box functionality from High to Low price")
    public void checkSortingProductsFromHighToLow() throws InterruptedException {
        homePage.selectOption(homePage.gertSortProductsDropDown(), "Sort by price (high to low)");
        assertEquals(homePage.getOptionHighToLow().getText(), "Sort by price (high to low)");
    }


    @Test(description = "Testing the 'search box' functionality")
    public void searchBoxTest2() throws InterruptedException {
        homePage.clickSearchBox();
        homePage.enterObjectToSearch("Awesome Soft Shirt");
        homePage.clickSearchButton();
        assertEquals(homePage.getAwesomeSoftShirtProduct().getText(), "Awesome Soft Shirt");
    }

    @Test(description = "Testing the 'search box' functionality")
    public void searchBoxTest3() throws InterruptedException {
        homePage.clickSearchBox();
        homePage.enterObjectToSearch("Awesome Granit Chips");
        homePage.clickSearchButton();
        assertEquals(homePage.getAwesomeGraniteChipsProduct().getText(), "Awesome Granit Chips");
    }

    @Test(description = "Testing the 'search box' functionality")
    public void searchBoxTest4() throws InterruptedException {
        homePage.clickSearchBox();
        homePage.enterObjectToSearch("Gorgeous Soft Pizza");
        homePage.clickSearchButton();
        assertEquals(homePage.getGorgeousSoftPizzaProduct().getText(), "Gorgeous Soft Pizza");
    }

    @Test(description = "Testing the 'search box' functionality")
    public void searchBoxTest5() throws InterruptedException {
        homePage.clickSearchBox();
        homePage.enterObjectToSearch("Incredible Concrete Hat");
        homePage.clickSearchButton();
        assertEquals(homePage.getIncredibleConcreteHatProduct().getText(), "Incredible Concrete Hat");
    }

    @Test(description = "Testing the 'search box' functionality")
    public void searchBoxTest6() throws InterruptedException {
        homePage.clickSearchBox();
        homePage.enterObjectToSearch("Licensed Steel Gloves");
        homePage.clickSearchButton();
        assertEquals(homePage.getLicensedSteelGlovesProduct().getText(), "Licensed Steel Gloves");
    }

    @Test(description = "Testing the 'search box' functionality")
    public void searchBoxTest7() throws InterruptedException {
        homePage.clickSearchBox();
        homePage.enterObjectToSearch("Practical Metal Mouse");
        homePage.clickSearchButton();
        assertEquals(homePage.getPracticalMetalMouseProduct().getText(), "Practical Metal Mouse");
    }


    @Test(description = "Testing the 'search box' functionality")
    public void searchBoxTest8() throws InterruptedException {
        homePage.clickSearchBox();
        homePage.enterObjectToSearch("Practical Wooden Bacon");
        homePage.clickSearchButton();
        assertEquals(homePage.getPracticalWoodenBacon().getText(), "Practical Wooden Bacon");
    }


    @Test(description = "Testing the 'search box' functionality")
    public void searchBoxTest9() throws InterruptedException {
        homePage.clickSearchBox();
        homePage.enterObjectToSearch("Refined Frozen Mouse");
        homePage.clickSearchButton();
        assertEquals(homePage.getRefinedFrozenMouseProduct().getText(), "Refined Frozen Mouse");
    }

}
