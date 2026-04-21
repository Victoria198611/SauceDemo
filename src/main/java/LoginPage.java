import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    //Locatorii
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By submitButton = By.id("login-button");
    private By errorMessage = By.cssSelector("h3[data-test='error']");

    //Constructor
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //Deschide pagina
    public void open() {
        driver.get("https://www.saucedemo.com/");
    }

    //Introducem email
    public void enterUsername(String username) {
        type(usernameField, username);
    }

    //Introduce parola
    public void enterPassword(String password) {
        type(passwordField, password);
    }

    // Click pe login
    public void clickLogin() {
        click(submitButton);
    }

    //Metoda completa de login
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    //Metoda pentru mesaj de eroare
        public boolean isErrorMessageDisplayed() {
            return waitForVisible(errorMessage).isDisplayed();
        }
    }

