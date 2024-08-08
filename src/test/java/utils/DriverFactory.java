package utils;

import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class DriverFactory {
    private static volatile DriverFactory instance;
    private final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private final ThreadLocal<Map<WebDriver, String>> driverMap = new ThreadLocal<>();

    public static DriverFactory getInstance() {
        DriverFactory localInstance = instance;
        if (localInstance == null) {
            synchronized (DriverFactory.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new DriverFactory();
                }
            }
        }
        return instance;
    }

    @SneakyThrows
    public synchronized WebDriver getDriver() {
        if (isDriverNull()) {
            WebDriver webDriver;
            switch (PropertyReader.getProperty("browser_name")) {
                case "chrome" -> {
                    ChromeOptions options = new ChromeOptions();
                    webDriver = new ChromeDriver(options);
                    driver.set(webDriver);
                    driverMap.set(getMapWithHandle(webDriver));
                }
                case "edge" ->  {
                    webDriver = new EdgeDriver();
                    driver.set(webDriver);
                    driverMap.set(getMapWithHandle(webDriver));
                }
                case "firefox" -> {
                    webDriver = new FirefoxDriver();
                    driver.set(webDriver);
                    driverMap.set(getMapWithHandle(webDriver));
                }
                default -> throw new Exception("Unsupported browser");
            }
            driver.get().manage().window().maximize();
            driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }
        return driver.get();
    }

    public boolean isDriverNull() {
        return driver.get() == null;
    }

    private Map<WebDriver, String> getMapWithHandle(WebDriver driver) {
        String handle = driver.getWindowHandle();
        Map<WebDriver, String> map = new HashMap<>();
        map.put(driver, handle);
        return map;
    }

    public String getInitialWindowHandle() {
        return driverMap.get().get(getDriver());
    }

    public void tearDown() {
        if (!isDriverNull()) {
            try {
                driver.get().quit();
            } catch (WebDriverException exception) {

            } finally {
                driver.remove();
            }
        }
    }
}
