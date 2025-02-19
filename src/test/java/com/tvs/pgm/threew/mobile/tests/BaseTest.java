package com.tvs.pgm.threew.mobile.tests;

import com.tvs.pgm.threew.mobile.base.DriverManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.OutputType;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;

public class BaseTest {

    protected static ExtentReports extent;
    protected static ExtentTest test;

    @BeforeSuite
    public void setup() throws MalformedURLException {
        DriverManager.initializeDriver();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        extent.setSystemInfo("Tester", "Mayur Martiwar"); // Change Tester Name
        extent.setSystemInfo("Project", "Mobile App Testing - 3Wheeler");
        extent.setSystemInfo("Environment", "Dev");
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Java Version", System.getProperty("java.version"));
    }

    @BeforeMethod
    public void startTest(Method method) {
        Test testAnnotation = method.getAnnotation(Test.class);
        String testCaseName = (testAnnotation != null && !testAnnotation.description().isEmpty())
            ? testAnnotation.description() // Use @Test description if available
            : method.getName(); // Fallback to method name

        test = extent.createTest(testCaseName); // Set test name in report
    }

    @AfterMethod
    public void captureResult(ITestResult result) {
        if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test Passed");
        } else if (result.getStatus() == ITestResult.FAILURE) {
            test.fail("Test Failed: " + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.skip("Test Skipped");
        }

        String screenshotPath = "C:\\Users\\admin\\Desktop\\3wautomation\\automation-mobile\\src\\test\\resources\\screenshots\\" + result.getName() + ".jpeg";

    // Take Screenshot
    File screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
    try {
        FileHandler.copy(screenshot, new File(screenshotPath));
        test.addScreenCaptureFromPath(screenshotPath);
    } catch (IOException e) {
        test.warning("Screenshot capture failed: " + e.getMessage());
    }

    // Log test result
    if (result.getStatus() == ITestResult.FAILURE) {
        test.fail("Test Failed: " + result.getThrowable());
    } else if (result.getStatus() == ITestResult.SUCCESS) {
        test.pass("Test Passed");
    }
    }

    @AfterSuite
    public void tearDown() {
        DriverManager.quitDriver();
        extent.flush();
    }
}
