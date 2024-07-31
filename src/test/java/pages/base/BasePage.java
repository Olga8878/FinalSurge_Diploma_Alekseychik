package pages.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverFactory;

import java.time.Duration;

public abstract class BasePage {
    protected  WebDriver driver;
    protected WebDriverWait wait;

    public BasePage() {
        driver = DriverFactory.getInstance().getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public abstract boolean isPageOpened();
}