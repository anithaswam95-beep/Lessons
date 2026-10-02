package lessons.PageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lessons.utilities.DriversUtility;
import lessonsBaseTest.BaseTest;

public class LoginPage extends BaseTest {

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    private WebElement userNameBox;

    @FindBy(id = "password")
    private WebElement passwordBox;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(tagName = "a")
    private List<WebElement> atags;

    public void usernameField(String value) {
        DriversUtility.typeValue(userNameBox, value);
        System.out.println("Username entered: " + userNameBox.getAttribute("value"));
    }

    public void passwordField(String value) {
        DriversUtility.typeValue(passwordBox, value);
        System.out.println("Password entered: " + passwordBox.getAttribute("value"));
    }

    public void loginButtonField() {
        System.out.println("Login button displayed: " + loginButton.isDisplayed());
        System.out.println("Login button enabled: " + loginButton.isEnabled());

        DriversUtility.click(loginButton);
    }

    public int allLinks() {
        System.out.println("Number of <a> tags found: " + atags.size());
        return atags.size();
    }
}