package ru.ulstu.autotest.context;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxContext extends Context {
    private final static String DRIVER_TYPE = "webdriver.gecko.driver";

    @Override
    protected void createDriver() {
        FirefoxOptions options = new FirefoxOptions();
        driver = new FirefoxDriver(options);
        driver.manage().deleteAllCookies();
    }

    @Override
    protected String getWindowsDriver() {
        return "geckodriver.exe";
    }

    @Override
    protected String getLinuxDriver() {
        return "geckodriver";
    }

    @Override
    protected String getDriverType() {
        return DRIVER_TYPE;
    }
}
