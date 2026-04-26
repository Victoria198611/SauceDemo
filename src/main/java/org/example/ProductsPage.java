package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends BasePage {

    //Locatori pentru titlu
    private By title = By.className("title");

    //Locatori pentru lista de produse
    private By productsList = By.className("inventory_item");

    //Locatori pentru dropdown-ul de sortare
    private By sortDropdown = By.className("product_sort_container");

    //Locatori pentru titlurile produselor
    private By productTitles = By.className("inventory_item_name");

    //Locatori pentru preturile produselor
    private By productPrices = By.className("inventory_item_price");

    //Constructor
    public ProductsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //Verificam ca suntem pe pagina products
    public boolean isPageOpened() {
        return waitForVisible(title).isDisplayed();
    }

    //Numarul de produse
    public int getProductsCount() {
        return driver.findElements(productsList).size();
    }

    public void selectSortOptions(String option) {
        WebElement dropdown = waitForVisible(sortDropdown);
        Select select = new Select(dropdown);
        select.selectByVisibleText(option);
    }

    public List<String> getProductTitles() {
        List<WebElement> elementList = driver.findElements(productTitles);
        List<String> titles = new ArrayList<>();
        for (WebElement el : elementList) {
            titles.add(el.getText());
        }
        return titles;
    }

    public List<Double> getProductPrices() {
        List<WebElement> priceElements = driver.findElements(productPrices);
        List<Double> prices = new ArrayList<>();
        for (WebElement el : priceElements) {
            String text = el.getText().replace("$", "");
            prices.add(Double.parseDouble(text));
        }
        return prices;
    }
    public void addProductToCart(String productName) {
        By addToCartButton = By.id("add-to-cart-sauce-labs-backpack");
        click(addToCartButton);
    }
}
