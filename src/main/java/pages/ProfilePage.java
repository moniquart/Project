package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class ProfilePage {
    private final WebDriver driver;

    private WebDriverWait wait;
    private final String BASE_URL = "http://training.skillo-bg.com:4200/users/";

    @FindBy(css = ".profile-user-settings > h2")
    WebElement usernameHeader;

    @FindBy(css = "i.fa-user-edit")
    WebElement editUserIcon;

    @FindBy(id = "toast-container")
    WebElement toastWindowProfileUpdated;

    @FindBy(css = ".image-container")
    WebElement uploadProfilePicField;

    @FindBy (id = "upload-img")
    WebElement fileUploadImg;


    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    public String getUsernameHeaderText () {
        wait.until(ExpectedConditions.visibilityOf(usernameHeader));
        return usernameHeader.getText();
    }

    public void verifyUrl() {
        wait.until(ExpectedConditions.urlContains(BASE_URL));
    }

    public void waitForEditUserIconToAppear () {
        wait.until(ExpectedConditions.visibilityOf(editUserIcon));
    }

    public void clickEditUserIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(editUserIcon));
        editUserIcon.click();
    }

    public void waitForToastWindowToAppear () {
        wait.until(ExpectedConditions.visibilityOf(toastWindowProfileUpdated));
    }

    public void waitForUploadProfilePicFieldToAppear () {
        wait.until(ExpectedConditions.visibilityOf(uploadProfilePicField));
    }

    public void clickUploadProfilePicField() {
        wait.until(ExpectedConditions.elementToBeClickable(uploadProfilePicField));
        uploadProfilePicField.click();
    }


    public void uploadImg (File file) {
        fileUploadImg.sendKeys(file.getAbsolutePath());
    }

    public void waitForProfilePicToAppear () {
        wait.until(ExpectedConditions.visibilityOf(uploadProfilePicField));
    }

}
