package com.tvs.pgm.threew.mobile.tests;

import com.tvs.pgm.threew.mobile.base.DriverManager;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import java.net.MalformedURLException;

public class BaseTest {

    @BeforeSuite
    public void setup() throws MalformedURLException {
        DriverManager.initializeDriver();
    }

    @AfterSuite
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
