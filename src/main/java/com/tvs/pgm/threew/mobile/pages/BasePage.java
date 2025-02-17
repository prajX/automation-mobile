package com.tvs.pgm.threew.mobile.pages;

import org.openqa.selenium.support.ui.WebDriverWait;
import com.tvs.pgm.threew.mobile.base.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import java.time.Duration;

public class BasePage {

    protected AndroidDriver driver;
    protected WebDriverWait wait;

    public BasePage() {
        driver = DriverManager.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

}
