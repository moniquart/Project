package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private final String URL = "http://training.skillo-bg.com:4200/users/login";

    private final WebDriver driver;
    WebDriverWait wait;

    @FindBy(css = "form .h4")
    WebElement signInHeader;

    @FindBy(name = "usernameOrEmail")
    WebElement usernameField;

    @FindBy(name = "password")
    WebElement passwordField;

    @FindBy(id = "sign-in-button")
    WebElement signInBtn;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(usernameField));
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.sendKeys(password);
    }

    public void clickSignIn() {
        wait.until(ExpectedConditions.elementToBeClickable(signInBtn));
        signInBtn.click();
    }

    public String getSignInHeaderText() {
        wait.until(ExpectedConditions.visibilityOf(signInHeader));
        return signInHeader.getText();
    }

    public void verifyURL() {
        wait.until(ExpectedConditions.urlToBe(URL));
    }
    public void login (String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickSignIn();
    }

}

