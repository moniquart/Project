package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;

public class ModifyProfileTest extends BaseTest {

    @DataProvider(name = "users")
    public Object[][] getData() {
        return new Object[][]{
                {"tester12", "tester"},

        };
    }

    @Test(dataProvider = "users")
    public void testModifyProfile (String username, String password) {
        System.out.println("1.Open homepage");
        HomePage homePage = new HomePage(driver);
        homePage.navigate();

        System.out.println("2.Navigate to login page");
        Header header = new Header(driver);
        header.goToLogin();

        System.out.println("3.Login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        System.out.println("4.Go to profile page");
        header.goToProfile();

        System.out.println("5.Check the correct url is opened (profile)");
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.verifyUrl();

        System.out.println("6.Verify edit user icon is visible");
        profilePage.waitForEditUserIconToAppear();

        System.out.println("7.Click on edit user icon");
        profilePage.clickEditUserIcon();

        System.out.println("8.Verify modify profile modal is displayed");
        ModifyProfileModal modifyProfileModal = new ModifyProfileModal(driver);
        modifyProfileModal.waitForModifyModalToAppear();

        System.out.println("9.Check the Modify your profile header is displayed");
        String headerText = modifyProfileModal.getModifyYourProfileHeaderText();
        Assert.assertEquals(headerText, "Modify Your Profile", "Incorrect Sign in text");

        System.out.println("10.Clear the username");
        modifyProfileModal.clearUsernameField();

        System.out.println("11.Enter new username");
        modifyProfileModal.enterNewUsername("tester13");

        System.out.println("12.Enter new password");
        modifyProfileModal.enterNewPassword("tester13");

        System.out.println("13.Confirm new password");
        modifyProfileModal.confirmNewPassword("tester13");

        System.out.println("13.Click on Save button");
        modifyProfileModal.clickSaveBtn();

        // Тук има бъг и юзерът не може да промени данните си!//

        System.out.println("14. Toast window - Profile Updated - appear");
        profilePage.waitForToastWindowToAppear();

    }
}
