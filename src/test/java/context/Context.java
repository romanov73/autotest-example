package context;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public abstract class Context {
    private final static String DRIVER_LOCATION = "drivers/%s";
    protected WebDriver driver;

    public WebDriver getDriver() {
        if (driver != null) {
            return driver;
        }
        throw new IllegalStateException("WebDriver is not initialized");
    }

    public void start() {
        System.setProperty(getDriverType(), getDriverExecutablePath());
        createDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void close() {
        driver.quit();
    }

    protected abstract void createDriver();

    protected abstract String getDriverType();

    protected abstract String getWindowsDriver();

    protected abstract String getLinuxDriver();

    private String getDriverExecutablePath() {
        return Context.class.getClassLoader().getResource(
                String.format(DRIVER_LOCATION,
                        isWindows()
                                ? getWindowsDriver()
                                : getLinuxDriver())).getFile();
    }

    private boolean isWindows() {
        return System.getProperty("os.name").toLowerCase().contains("windows");
    }
}
