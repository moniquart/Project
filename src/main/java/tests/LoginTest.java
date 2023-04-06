package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Header;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;

public class LoginTest extends BaseTest {

    @DataProvider(name = "users")
    public Object[][] getData() {
        return new Object[][]{
                {"eleven", "autopass"}
        };
    }

    @Test(dataProvider = "users")
    public void loginTest(String username, String password) {
        System.out.println("1. Navigate to home page");
        HomePage homePage = new HomePage(driver);
        homePage.navigate();

        System.out.println("2. Navigate to login");
        Header header = new Header(driver);
        header.goToLogin();

        System.out.println("3. Check the correct url is opened (login)");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyURL();

        System.out.println("4. Check the Sign In header is displayed");
        String headerText = loginPage.getSignInHeaderText();
        Assert.assertEquals(headerText, "Sign in", "Incorrect Sign in text");

        System.out.println("5. Enter username");
        loginPage.enterUsername(username);

        System.out.println("6. Enter password");
        loginPage.enterPassword(password);

        System.out.println("7. Click Sign In btn");
        loginPage.clickSignIn();

        System.out.println("8. Check the correct url is opened (homepage)");
        homePage.verifyURL();

        System.out.println("9. Navigate to profile page");
        header.goToProfile();

        System.out.println("10. Check the correct url is opened (profile page)");
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.verifyUrl();

        System.out.println("11. Check that the username is displayed correctly");
        String UsernameHeaderText = profilePage.getUsernameHeaderText();
        Assert.assertEquals(UsernameHeaderText, username, "Incorrect username");

    }

}
