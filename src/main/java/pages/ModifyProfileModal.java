package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ModifyProfileModal {

    private final WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = ".modal-dialog")
    WebElement modifyProfileModal;

    @FindBy(css = "app-edit-profile-modal h4")
    WebElement modifyYourProfileHeader;

    @FindBy(css = "input[formcontrolname='username']")
    WebElement usernameField;

    @FindBy(css = "input[formcontrolname='email']")
    WebElement emailField;

    @FindBy(css = "input[formcontrolname='password']")
    WebElement passwordField;

    @FindBy(css = "input[formcontrolname='confirmPassword']")
    WebElement confirmPasswordField;

    @FindBy(css = "textarea[formcontrolname='publicInfo']")
    WebElement publicInfoField;

    @FindBy(css = "button.btn-primary")
    WebElement saveBtn;

    public ModifyProfileModal(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void waitForModifyModalToAppear() {
        wait.until(ExpectedConditions.visibilityOf(modifyProfileModal));
    }

    public String getModifyYourProfileHeaderText() {
        wait.until(ExpectedConditions.visibilityOf(modifyYourProfileHeader));
        return modifyYourProfileHeader.getText();
    }

    public void clearUsernameField () {
        wait.until(ExpectedConditions.visibilityOf(usernameField));
        usernameField.clear();
    }

    public void enterNewUsername (String newUserName) {
        wait.until(ExpectedConditions.visibilityOf(usernameField));
        usernameField.sendKeys(newUserName);
    }

    public void enterNewPassword (String newPassword) {
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.sendKeys(newPassword);
    }

    public void confirmNewPassword (String newPassword) {
        wait.until(ExpectedConditions.visibilityOf(confirmPasswordField));
        confirmPasswordField.sendKeys(newPassword);
    }

    public void clickSaveBtn () {
        wait.until(ExpectedConditions.visibilityOf(saveBtn));
        saveBtn.click();
    }


}