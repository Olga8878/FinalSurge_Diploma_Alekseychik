package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.base.BasePage;
import utils.PropertyReader;

public class LoginPage extends BasePage {
    public final By logInLink = By.xpath("//span[contains(text(), 'Log In')]");
    public final By loginEmail = By.cssSelector("input[name=email]");
    public final By loginPassword = By.cssSelector("input[name=password]");
    public final By signInButton = By.xpath("//span[contains(text(), 'Sign In')]");

    public final By continueWithClassic = By.xpath("//span[contains(text(), 'Continue with Classic')]");

    public LoginPage() {
        super();
    }

    @Step
    public void openURL() {
        driver.get(PropertyReader.getProperty("base_url"));
    }
    @Override
    public boolean isPageOpened() {
        wait.until(ExpectedConditions.elementToBeClickable(logInLink));
        return true;
    }

    @Step
    private void clickLogInLink() {
        driver.findElement(logInLink).click();
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
        clickLogInLink();
        setEmailValue(email);
        setPasswordValue(password);
        clickSignInButton();
        clickToContinueWithClassic();
        return new DashboardPage();
    }

    @Step
    private void clickToContinueWithClassic(){
        driver.findElement(continueWithClassic).click();
    }
}
