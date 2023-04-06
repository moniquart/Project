package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Header;
import pages.HomePage;
import pages.LoginPage;

public class LogoutTest extends BaseTest {

    @DataProvider(name = "users")
    public Object[][] getData() {
        return new Object[][]{
                {"eleven", "autopass"}
        };
    }

    @Test(dataProvider = "users")
    public void logoutTest (String username, String password) {
        System.out.println("1.Open homepage");
        HomePage homepage = new HomePage(driver);
        homepage.navigate();

        System.out.println("2.Navigate to login page");
        Header header = new Header(driver);
        header.goToLogin();

        System.out.println("3. Login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        System.out.println("4. Check the correct url is opened (homepage)");
        homepage.verifyURL();

        System.out.println("5. Click on Logout btn");
        homepage.logout();

        System.out.println("6. Check the correct url is opened (login)");
        loginPage.verifyURL();


    }

}
