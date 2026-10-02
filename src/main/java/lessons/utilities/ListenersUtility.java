package lessons.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersUtility implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        ExtentManager.getInstance();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentManager.createTest(
                result.getMethod().getMethodName(),
                "Automation Test"
        );
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentManager.logPass(
                "Test Passed: " + result.getMethod().getMethodName()
        );
    }

    @Override
    public void onTestFailure(ITestResult result) {

        ExtentManager.logFail(
                "Test Failed: " + result.getThrowable()
        );
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentManager.logSkip(
                "Test Skipped: " + result.getMethod().getMethodName()
        );
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentManager.flushReport();
    }
}