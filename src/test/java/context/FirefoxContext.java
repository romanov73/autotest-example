package context;

import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxContext extends Context {
    private final static String DRIVER_TYPE = "webdriver.gecko.driver";

    @Override
    protected void createDriver() {
        driver = new FirefoxDriver();
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
