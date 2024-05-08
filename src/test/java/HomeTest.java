import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
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

    @Test(description = "Testing the search box functionality")
    public void homeTest() throws InterruptedException {
        homePage.clickSearchBox();
        homePage.enterObjectToSearch();
        homePage.clickSearchButton();
       assertEquals("Awesome Metal Chair", homePage.getProductName().getText());
    }

    @Test(description = "This test verifies the sorting box functionality from A to Z produce")
    public void checkSortingProductsFromAtoZ() throws InterruptedException {
        homePage.selectOption(homePage.gertSortProductsDropDown(), "Sort by name (A to Z)");
        assertEquals("Sort by name (A to Z)", homePage.getOptionAtoZ().getText());
    }


    @Test(description = "This test verifies the sorting box functionality from Z to A produce")
    public void checkSortingProductsFromZtoA() throws InterruptedException {
        homePage.selectOption(homePage.gertSortProductsDropDown(), "Sort by name (Z to A)");
        assertEquals("Sort by name (Z to A)", homePage.getOptionZtoA().getText());
    }


    @Test(description = "This test verifies the sorting box functionality from Low to High price")
    public void checkSortingProductsFromLowToHigh() throws InterruptedException {
        homePage.selectOption(homePage.gertSortProductsDropDown(), "Sort by price (low to high)");
        assertEquals("Sort by price (low to high)", homePage.getOptionLowToHigh().getText());
    }

    @Test(description = "This test verifies the sorting box functionality from High to Low price")
    public void checkSortingProductsFromHighToLow() throws InterruptedException {
        homePage.selectOption(homePage.gertSortProductsDropDown(), "Sort by price (high to low)");
        assertEquals("Sort by price (high to low)", homePage.getOptionHighToLow().getText());
    }

}
