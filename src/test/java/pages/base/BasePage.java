package pages.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverFactory;

import java.time.Duration;

public abstract class BasePage {
    protected static WebDriver driver;
    protected WebDriverWait wait;
    protected final Logger logger = LogManager.getLogger(this.getClass().getName());

    public BasePage() {
        driver = DriverFactory.getInstance().getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public abstract boolean isPageOpened();
}