package pages;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
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


    @Step("Open url")
    public void openURL() {
        driver.get(PropertyReader.getProperty("base_url"));
    }

    @Step("Set email 'email'")
    private void setEmailValue(String email) {
        driver.findElement(loginEmail).sendKeys(email);
    }

    @Step("Set password 'password'")
    private void setPasswordValue(String password) {
        driver.findElement(loginPassword).sendKeys(password);
    }

    @Step("Click signUp Button")
    private void clickSignInButton() {
        driver.findElement(signInButton).click();
    }

    @Step("Enter login and password")
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

    @Override
    public boolean isPageOpened() {
        wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        return true;
    }
}
