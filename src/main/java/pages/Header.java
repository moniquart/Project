package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Header {

        private final WebDriver driver;
        private WebDriverWait wait;

        @FindBy(id = "homeIcon")
        WebElement homeIcon;

        @FindBy(css = "#nav-link-login")
        WebElement  loginLink;

        @FindBy(linkText = "Profile")
        WebElement profileLink;

        public Header(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
            wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        }

        public void goToLogin() {
            wait.until(ExpectedConditions.elementToBeClickable(loginLink));
            loginLink.click();
        }

        public void goToHome() {
            wait.until(ExpectedConditions.elementToBeClickable(homeIcon));
            homeIcon.click();
        }

        public void goToProfile() {
            wait.until(ExpectedConditions.elementToBeClickable(profileLink));
            profileLink.click();
        }
    }


