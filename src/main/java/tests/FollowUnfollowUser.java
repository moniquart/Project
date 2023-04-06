package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Header;
import pages.HomePage;
import pages.LoginPage;

public class FollowUnfollowUser extends BaseTest {

    @DataProvider(name = "users")
    public Object[][] getData() {
        return new Object[][]{
                {"eleven", "autopass"}
        };
    }

    @Test(dataProvider = "users")
    public void followUnfollowUser(String username, String password) {
        System.out.println("1.Open homepage");
        HomePage homePage = new HomePage(driver);
        homePage.navigate();

        System.out.println("2.Navigate to login page");
        Header header = new Header(driver);
        header.goToLogin();

        System.out.println("3.Login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        System.out.println("4.Check the correct url is opened (homepage)");
        homePage.verifyURL();

        System.out.println("5.Click on FOLLOW button on the first post");
        homePage.followUnfollow();

        System.out.println("6.Click on unfollow button on the first post");
        homePage.followUnfollow();

        System.out.println("7.Toast message window appear");
        homePage.waitForToastWindowToAppear();

    }

}
