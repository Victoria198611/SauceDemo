package org.example;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("SauceDemo Tests")
@Feature("Products")
@Listeners({io.qameta.allure.testng.AllureTestNg.class})

public class ProductsTest extends org.example.BaseTest {

    @Story("Valid login allows access to products page")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verifica daca utilizatorul poate face login si poate accesa pagina de produse.")
    @Test
    public void TestValidLogin() {
        LoginPage loginPage = new LoginPage(driver, wait);
        ProductsPage productsPage = new ProductsPage(driver, wait);
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(productsPage.isPageOpened());
        Assert.assertEquals(productsPage.getProductsCount(), 6);

    }
@Story("Invalid login shows error message")
@Severity(SeverityLevel.NORMAL)
@Description("Verifica daca un mesaj de eroare apare atunci cand utilizatorul introduce date gresite.")
    @Test
    public void TestInvalidLogin() {
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.open();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("Password123");
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
    }
@Story("Sort products A to Z")
@Severity(SeverityLevel.MINOR)
@Description("Verifica daca sortarea produselor de la A la Z functioneaza corect.")
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
@Story("Sort products Z to A")
@Severity(SeverityLevel.MINOR)
@Description("Verifica sortarea produselor de la Z la A daca functioneaza corect.")
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
@Story("Sort products by price ascending")
@Severity(SeverityLevel.NORMAL)
@Description("Verifica daca sortarea produselor dupa pret(low to high) functioneaza corect.")
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
@Story("Add products to Cart")
@Severity(SeverityLevel.CRITICAL)
@Description("Verifica daca utilizatorul poate adauga un produs in cos.")
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

