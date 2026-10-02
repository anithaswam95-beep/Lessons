package lessons.utilities;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    // Create Extent Report
    public static ExtentReports getInstance() {

        if (extent == null) {

            String reportPath =
                    System.getProperty("user.dir")
                    + File.separator
                    + "Reports"
                    + File.separator
                    + "ExtentReport.html";

            ExtentSparkReporter sparkReporter =
                    new ExtentSparkReporter(reportPath);

            sparkReporter.config().setTheme(Theme.DARK);
            sparkReporter.config().setDocumentTitle("Automation Test Report");
            sparkReporter.config().setReportName("Selenium Automation Results");

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);

            extent.setSystemInfo("Project", "Lessons");
            extent.setSystemInfo("Tester", "Anitha");
            extent.setSystemInfo("Environment", "QA");
        }

        return extent;
    }

    // Create a test
    public static synchronized ExtentTest createTest(
            String testName, String description) {

        ExtentTest extentTest =
                getInstance().createTest(testName, description);

        test.set(extentTest);

        return extentTest;
    }

    // Get current test
    public static ExtentTest getTest() {
        return test.get();
    }

    // Log INFO
    public static void logInfo(String message) {
        getTest().log(Status.INFO, message);
    }

    // Log PASS
    public static void logPass(String message) {
        getTest().log(Status.PASS, message);
    }

    // Log FAIL
    public static void logFail(String message) {
        getTest().log(Status.FAIL, message);
    }

    // Log SKIP
    public static void logSkip(String message) {
        getTest().log(Status.SKIP, message);
    }

    // Attach Screenshot
    public static void attachScreenshot(
            String screenshotPath, String title) {

        getTest().addScreenCaptureFromPath(
                screenshotPath, title);
    }

    // Save report
    public static void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}