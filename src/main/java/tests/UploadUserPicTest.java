package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Header;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;

import java.io.File;

public class UploadUserPicTest extends BaseTest {

    @DataProvider(name = "getData")
    public Object[][] getData() {
        return new Object[][]{
                {"tester12", "tester", new File("src/main/resources/Upload/White_paper.jpg"),}
        };
    }

    @Test(dataProvider = "getData")
    public void testUploadUserPic (String username, String password, File file ){
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

        System.out.println("6.Verify upload profile pic field is visible");
        profilePage.waitForUploadProfilePicFieldToAppear();

        System.out.println("7.Click on upload profile pic field");
        profilePage.clickUploadProfilePicField();

        System.out.println("8.Upload a new picture");
        profilePage.uploadImg(file);


    }

}
