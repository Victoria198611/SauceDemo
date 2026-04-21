import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
 protected WebDriver driver;
 protected WebDriverWait wait;

 //Constructorul care primeste driver + wait de BaseTest
    public BasePage(WebDriver driver, WebDriverWait wait){
       this.driver=driver;
       this.wait=wait;
    }

    //Asteapta ca un element sa fie vizibil
public WebElement waitForVisible(By locator) {
    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
}

//Click normal
    public void click(By locator){
        waitForVisible(locator).click();
    }

    //Scrie text intr-un input
    public void type(By locator,String text){
        waitForVisible(locator).sendKeys(text);
    }

    //Scroll pina la element
    public void scroll(WebElement element){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",element);
    }

    //Facem click pe element folosind Javascript
    public void jsClick(WebElement element){
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
    }
}
