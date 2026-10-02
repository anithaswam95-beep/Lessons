package lessons.TestScripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import lessons.PageObjects.LoginPage;
import lessons.utilities.DriversUtility;
import lessons.utilities.ListenersUtility;
import lessonsBaseTest.BaseTest;

@Listeners(ListenersUtility.class)
public class LoginTest extends BaseTest {

    private LoginPage page;

    @BeforeMethod
    public void setup() {

        BaseTest.setupBrowser("Chrome");

        DriversUtility.maximizeWindow();

        DriversUtility.navigateTo(
                "https://www.saucedemo.com/");

        page = new LoginPage();
    }

    @AfterMethod
    public void tearDown() {

        DriversUtility.quitBrowser();
    }

    @Test(priority = 1)
    public void verifyTitle() {

        String expectedTitle = "Swag Labs";
        String actualTitle = DriversUtility.getTitle();

        Assert.assertEquals(
                actualTitle,
                expectedTitle,
                "Title Mismatched");
    }

    @Test(priority = 2)
    public void verifyUrl() {

        String expectedUrl =
                "https://www.saucedemo.com/";

        String actualUrl =
                DriversUtility.getPageURL();

        Assert.assertEquals(
                actualUrl,
                expectedUrl,
                "Url is mismatched");
    }

    @Test(priority = 3)
    public void verifyUrls() {

        int actualLinkSize = page.allLinks();

        int expectedLinkSize = 0;

        Assert.assertEquals(
                actualLinkSize,
                expectedLinkSize,
                "Total page links mismatch");
    }

    @Test(priority = 4)
    public void verifyLogin() {

        page.usernameField("standard_user");

        page.passwordField("secret_sauce");

        page.loginButtonField();

        String actualUrl =
                DriversUtility.getPageURL();

        String expectedUrl =
                "https://www.saucedemo.com/inventory.html";

        Assert.assertEquals(
                actualUrl,
                expectedUrl,
                "Login redirection URL mismatched");
    }
}