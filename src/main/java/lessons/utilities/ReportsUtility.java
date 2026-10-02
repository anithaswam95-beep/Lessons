package lessons.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportsUtility {

    public static ExtentReports generateReports() {

        String reportPath =
                System.getProperty("user.dir")
                + "/Reports/ExtentReport.html";

        ExtentSparkReporter spark =
                new ExtentSparkReporter(reportPath);

        spark.config().setDocumentTitle("Automation Execution Report");
        spark.config().setReportName("Selenium Test Automation Results");
        spark.config().setTheme(Theme.DARK);

        ExtentReports extent = new ExtentReports();

        extent.attachReporter(spark);

        // System Information
        extent.setSystemInfo("OS",
                System.getProperty("os.name"));

        extent.setSystemInfo("Java Version",
                System.getProperty("java.version"));

        extent.setSystemInfo("Environment",
                "QA");

        extent.setSystemInfo("Browser",
                "Chrome");

        return extent;
    }
}