package pages;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.base.BasePage;
import utils.DriverFactory;
import utils.PropertyReader;

import java.util.Set;

public class LoginPage extends BasePage {
    protected final Logger logger = LogManager.getLogger(this.getClass().getName());
    public final By loginEmail = By.id("login_name");
    public final By loginPassword = By.id("login_password");
    public final By signInButton = By.xpath("//button[text()=\"Login\"]");


    public LoginPage() {
        super();
    }

    @Override
    public boolean isPageOpened() {
        return false;
    }

    @Step
    public void openURL() {
        driver.get(PropertyReader.getProperty("base_url"));
    }

    @Step
    private void setEmailValue(String email) {
        driver.findElement(loginEmail).sendKeys(email);
    }

    @Step
    private void setPasswordValue(String password) {
        driver.findElement(loginPassword).sendKeys(password);
    }

    @Step
    private void clickSignInButton() {
        driver.findElement(signInButton).click();
    }

    @Step
    public DashboardPage login(String email, String password) {
        logger.info("Log in with email = {}, password = {}", email, password);
        openURL();
        setEmailValue(email);
        setPasswordValue(password);
        clickSignInButton();
        return new DashboardPage();
    }

    public void checkWebDriver() {
        DriverFactory.getInstance().getDriver().getCurrentUrl();
    }

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
}
