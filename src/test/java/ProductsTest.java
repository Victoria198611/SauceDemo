
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductsTest extends BaseTest {

    @Test
    public void TestValidLogin() {
        LoginPage loginPage = new LoginPage(driver, wait);
        ProductsPage productsPage = new ProductsPage(driver, wait);
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(productsPage.isPageOpened());
        Assert.assertEquals(productsPage.getProductsCount(), 6);

    }

    @Test
    public void TestInvalidLogin() {
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.open();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("Password123");
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
    }

    @Test
//Sortez produsele de la A la Z
    public void testSortProductsAtoZ() {
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        ProductsPage productsPage = new ProductsPage(driver, wait);
        productsPage.selectSortOptions("Name (A to Z)");
        List<String> titles = productsPage.getProductTitles();
        List<String> sortedTitles = new ArrayList<>(titles);
        Collections.sort(sortedTitles);
        Assert.assertEquals(titles, sortedTitles);
    }

    @Test
//Sortez produsele de la Z la A
    public void testSortByNameDescending() {
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        ProductsPage productsPage = new ProductsPage(driver, wait);
        productsPage.selectSortOptions("Name (Z to A)");
        List<String> titles = productsPage.getProductTitles();
        List<String> sorted = new ArrayList<>(titles);
        sorted.sort(Comparator.reverseOrder());
        Assert.assertEquals(titles, sorted);
    }

    @Test
//Sortez produsele low-high
    public void testProductsByPriceAscending() {
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        ProductsPage productsPage = new ProductsPage(driver, wait);
        productsPage.selectSortOptions("Price (low to high)");
        List<Double> prices = productsPage.getProductPrices();
        List<Double> sorted = new ArrayList<>(prices);
        Collections.sort(sorted);
        Assert.assertEquals(prices, sorted);
    }

    @Test
//Adaugarea unui produs in cos
    public void addProductToCart() {
        LoginPage loginPage=new LoginPage(driver, wait);
        loginPage.open();
        loginPage.login("standard_user","secret_sauce");
        ProductsPage productsPage = new ProductsPage(driver, wait);
        productsPage.addProductToCart ("Sauce Labs Backpack");
    }
}

