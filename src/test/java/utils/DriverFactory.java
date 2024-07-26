package utils;

import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverFactory {
    private static DriverFactory instance;
    public WebDriver driver;

    public static synchronized DriverFactory getInstance() {
        if (instance == null) {
            instance = new DriverFactory();
        }
        return instance;
    }

    @SneakyThrows
    public WebDriver getDriver() {
        if (isDriverNull()) {
            switch (PropertyReader.getProperty("browser_name")) {
                case "chrome" -> {
                    ChromeOptions options = new ChromeOptions();
//                options.addArguments("--headless");
                    driver = new ChromeDriver(options);
                }
                case "edge" -> driver = new EdgeDriver();
                case "firefox" -> driver = new FirefoxDriver();
                default -> throw new Exception("Unsupported browser");
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }
        return driver;
    }

    private boolean isDriverNull() {
        return driver == null;
    }

    public void tearDown() {
        getDriver().quit();
    }
}
