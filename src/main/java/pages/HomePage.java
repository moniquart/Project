package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
   private final WebDriver driver;

   private WebDriverWait wait;

   private final String URL = "http://training.skillo-bg.com:4200/posts/all";

   @FindBy(css = ".btn.btn-primary")
   WebElement followUnfollowBtn;

   @FindBy(css = "i.fas.fa-sign-out-alt.fa-lg")
   WebElement logoutBtn;

   @FindBy (id = "toast-container")
   WebElement toastWindow;


   public HomePage(WebDriver driver) {
      this.driver = driver;
      PageFactory.initElements(driver, this);
      wait = new WebDriverWait(driver, Duration.ofSeconds(5));

   }

   public void navigate() {
      driver.get(URL);
   }

   public void verifyURL() {
      wait.until(ExpectedConditions.urlToBe(URL));

   }

   public void followUnfollow() {
      wait.until(ExpectedConditions.elementToBeClickable(followUnfollowBtn));
      followUnfollowBtn.click();
   }

   public void logout () {
      wait.until(ExpectedConditions.elementToBeClickable(logoutBtn));
      logoutBtn.click();

   }

   public String getUnfollowBtnText() {
      wait.until(ExpectedConditions.visibilityOf(followUnfollowBtn));
      return followUnfollowBtn.getText();
   }

   public void waitForToastWindowToAppear () {
      wait.until(ExpectedConditions.visibilityOf(toastWindow));
   }
}



