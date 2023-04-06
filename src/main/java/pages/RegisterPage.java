package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {
    private final String URL = "http://training.skillo-bg.com:4200/users/register";

    private final WebDriver driver;
    WebDriverWait wait;

    @FindBy(css = ".mb-4")
    WebElement signUpHeader;

    @FindBy(name = "username")
    WebElement usernameField;

    @FindBy(css = "input[formcontrolname='email']")
    WebElement emailField;

    @FindBy (name = "password")
    WebElement passwordField;

    @FindBy (name = "verify-password")
    WebElement verifyPasswordField;

    @FindBy(id = "sign-in-button")
    WebElement signInBtn;

    @FindBy(id = "toast-container")
    WebElement toastNotification;


    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void navigate() {
        driver.get(URL);
    }

    public String getSignUpHeaderText() {
        wait.until(ExpectedConditions.visibilityOf(signUpHeader));
        return signUpHeader.getText();

    }

    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(usernameField));
        usernameField.sendKeys(username);
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.sendKeys(email);

    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.sendKeys(password);

    }

    public void verifyPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(verifyPasswordField));
        verifyPasswordField.sendKeys(password);

    }

    public void clickSignIn() {
        wait.until(ExpectedConditions.elementToBeClickable(signInBtn));
        signInBtn.click();

    }

    public void waitForToastNotification() {
        wait.until(ExpectedConditions.visibilityOf(toastNotification));
    }


}

