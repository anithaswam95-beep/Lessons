package lessons.utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import lessonsBaseTest.BaseTest;

public class DriversUtility extends BaseTest {

    // =========================================================
    // ELEMENT INTERACTIONS
    // =========================================================

    // Click
    public static void clickOn(WebElement element) {
        element.click();
    }

    // Enter text
    public static void sendText(WebElement element, String text) {
        element.sendKeys(text);
    }

    // Clear text
    public static void clearText(WebElement element) {
        element.clear();
    }

    // Get text
    public static String getText(WebElement element) {
        return element.getText();
    }

    // Get attribute
    public static String getAttribute(WebElement element, String attributeName) {
        return element.getAttribute(attributeName);
    }

    // Check if displayed
    public static boolean isDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    // Check if enabled
    public static boolean isEnabled(WebElement element) {
        return element.isEnabled();
    }

    // Check if selected
    public static boolean isSelected(WebElement element) {
        return element.isSelected();
    }


    // =========================================================
    // BROWSER METHODS
    // =========================================================

    // Maximize browser
    public static void maximizeWindow() {
        driver.manage().window().maximize();
    }

    // Minimize browser
    public static void minimizeWindow() {
        driver.manage().window().minimize();
    }

    // Navigate to URL
    public static void navigateTo(String url) {
        driver.navigate().to(url);
    }

    // Go back
    public static void navigateBack() {
        driver.navigate().back();
    }

    // Go forward
    public static void navigateForward() {
        driver.navigate().forward();
    }

    // Refresh page
    public static void refreshPage() {
        driver.navigate().refresh();
    }

    // Get page title
    public static String getTitle() {
        return driver.getTitle();
    }

    // Get current URL
    public static String getPageURL() {
        return driver.getCurrentUrl();
    }

    // Get page source
    public static String getPageSource() {
        return driver.getPageSource();
    }
    public static void maximize() {
        driver.manage().window().maximize();
    }

    public static void gotoUrl(String url) {
        driver.get(url);
    }

    public static String getPageTitle() {
        return driver.getTitle();
    }

    public static String getPageUrl() {
        return driver.getCurrentUrl();
    }
    
    // =========================================================
    // ACTIONS CLASS METHODS
    // =========================================================

    // Mouse Hover
    public static void mouseHover(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    // Click using Actions class
    public static void actionClick(WebElement element) {
        Actions actions = new Actions(driver);
        actions.click(element).perform();
    }

    // Double Click using Actions class
    public static void actionDoubleClick(WebElement element) {
        Actions actions = new Actions(driver);
        actions.doubleClick(element).perform();
    }

    // Right Click / Context Click using Actions class
    public static void actionRightClick(WebElement element) {
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
    }

    // Drag and Drop using Actions class
    public static void actionDragAndDrop(WebElement source, WebElement target) {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).perform();
    }

    // Scroll to element using Actions
    public static void scrollToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.scrollToElement(element).perform();
    }

    // Scroll by amount using Actions
    public static void scrollByAmount(int x, int y) {
        Actions actions = new Actions(driver);
        actions.scrollByAmount(x, y).perform();
    }


    // =========================================================
    // DROPDOWN METHODS
    // =========================================================

    // Select by visible text
    public static void selectByVisibleText(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    // Select by value
    public static void selectByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }
    
    // Select by index
    public static void selectByIndex(WebElement element, int index) {
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    // Deselect all
    public static void deselectAll(WebElement element) {
        Select select = new Select(element);
        select.deselectAll();
    }

    // Get dropdown options
    public static List<WebElement> getDropdownOptions(WebElement element) {
        Select select = new Select(element);
        return select.getOptions();
    }


    // =========================================================
    // ALERT METHODS
    // =========================================================

    // Accept alert
    public static void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    // Dismiss alert
    public static void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    // Enter text into alert
    public static void alertSendKeys(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    // Get alert text
    public static String getAlertText() {
        return driver.switchTo().alert().getText();
    }


    // =========================================================
    // FRAME METHODS
    // =========================================================

    // Switch to frame using index
    public static void switchToFrameByIndex(int index) {
        driver.switchTo().frame(index);
    }

    // Switch to frame using name or ID
    public static void switchToFrameByNameOrId(String nameOrId) {
        driver.switchTo().frame(nameOrId);
    }

    // Switch to frame using WebElement
    public static void switchToFrameByElement(WebElement element) {
        driver.switchTo().frame(element);
    }

    // Switch back to main page
    public static void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }


    // =========================================================
    // WINDOW HANDLING
    // =========================================================

    // Get current window handle
    public static String getWindowHandle() {
        return driver.getWindowHandle();
    }

    // Get all window handles
    public static Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    // Switch to window
    public static void switchToWindow(String windowHandle) {
        driver.switchTo().window(windowHandle);
    }


    // =========================================================
    // EXPLICIT WAIT METHODS
    // =========================================================

    // Wait for element visibility
    public static WebElement waitForVisibility(WebElement element, int seconds) {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(seconds));

        return wait.until(
                ExpectedConditions.visibilityOf(element));
    }

    // Wait for element clickable
    public static WebElement waitForClickability(WebElement element, int seconds) {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(seconds));

        return wait.until(
                ExpectedConditions.elementToBeClickable(element));
    }
    public static void setImplicitlyWait(int seconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    // =========================================================
    // JAVASCRIPT METHODS
    // =========================================================

    // Click using JavaScript
    public static void clickByJS(WebElement element) {

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript("arguments[0].click();", element);
    }

    // Scroll element into view using JavaScript
    public static void scrollIntoViewJS(WebElement element) {

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript(
                "arguments[0].scrollIntoView(true);",
                element);
    }
 // Scroll directly to a target element using Actions
    public static void scrollToElement1(WebElement element) {
        Actions actions = new Actions(driver);
        actions.scrollToElement(element).perform();
    }
 
    // WINDOWS AND TABS

  

   public static void openNewTab() {
        driver.switchTo().newWindow(WindowType.TAB);
    }

    public static void openNewWindow() {
        driver.switchTo().newWindow(WindowType.WINDOW);
    }
    
    // =========================================================
    // SCREENSHOT
    // =========================================================

    public static void takeScreenshot(String fileName) {

        TakesScreenshot screenshot =
                (TakesScreenshot) driver;

        File source =
                screenshot.getScreenshotAs(OutputType.FILE);

        File destination =
                new File(
                    System.getProperty("user.dir")
                    + "/Screenshots/"
                    + fileName
                    + ".png"
                );

        try {

            FileUtils.copyFile(source, destination);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

	public static void typeValue(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}

	public static void click(WebElement element) {
		element.click();
	}

	public void tearDown() {
        DriversUtility.quitBrowser();
    }

	public static void quitBrowser() {
		if (driver != null) {
			driver.quit();
		}
	}

	 
		
	}
