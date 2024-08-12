package pages.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverFactory;

import java.time.Duration;
import java.util.Set;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected final Logger logger = LogManager.getLogger(this.getClass().getName());

    public BasePage() {
        driver = DriverFactory.getInstance().getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public abstract boolean isPageOpened();

    public void closeSubWindows() {
        try {
            closeAllSubWindows();
        } catch (NoSuchWindowException noSuchWindowException) {
            logger.warn("No such window exception: {}", noSuchWindowException.getMessage());
        } catch (WebDriverException ex) {
            logger.warn("It looks like driver is not available: {}", ex.getMessage());
        } catch (Exception ex) {
            logger.warn("Unexpected error during closing: {}", ex.getMessage());
        }
    }

    private void closeAllSubWindows() {
        String defaultWindow = DriverFactory.getInstance().getInitialWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        for (String window : windows) {
            if (!window.equals(defaultWindow)) {
                driver.switchTo().window(window);
                driver.close();
            }
        }
        driver.switchTo().window(defaultWindow);
    }

    protected void switchToSecondWindow() {
        Object[] windowHandles = driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowHandles[1]);
    }

    protected void switchToFrame(By locator) {
        driver.switchTo().frame(driver.findElement(locator));
    }
}
