package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;

public class RegisterTest extends BaseTest {

    @Test
    public void registerTest() {
        System.out.println("1.Navigate to register page");
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.navigate();

        System.out.println("2. Check the Sign Up header is displayed");
        String headerText = registerPage.getSignUpHeaderText();
        Assert.assertEquals(headerText, "Sign up", "Incorrect Sign up text");

        System.out.println("3. Enter username");
        registerPage.enterUsername("new2_betty");

        System.out.println("4. Enter email");
        registerPage.enterEmail("new2@abv.bg");

        System.out.println("5. Enter password");
        registerPage.enterPassword("pass2_betty");

        System.out.println("6. Confirm password");
        registerPage.verifyPassword("pass2_betty");

        System.out.println("7. Click Sign In btn");
        registerPage.clickSignIn();

        System.out.println("8. Check the correct url is opened (homepage)");
        HomePage homepage = new HomePage(driver);
        homepage.verifyURL();


    }

}
