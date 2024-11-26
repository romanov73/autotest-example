package context;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeContext extends Context {
    private final static String CHROME_BINARY_PATH = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
    private final static String DRIVER_TYPE = "webdriver.chrome.driver";

    @Override
    protected void createDriver() {
        ChromeOptions options = new ChromeOptions();
        options.setBinary(CHROME_BINARY_PATH);
        System.out.println(CHROME_BINARY_PATH);
        driver = new ChromeDriver(options);
    }

    @Override
    protected String getWindowsDriver() {
        return "chromedriver.exe";
    }

    @Override
    protected String getLinuxDriver() {
        return "chromedriver";
    }

    @Override
    protected String getDriverType() {
        return DRIVER_TYPE;
    }
}
