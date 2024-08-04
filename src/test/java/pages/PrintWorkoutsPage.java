package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.base.BasePage;

public class PrintWorkoutsPage extends BasePage {

    private final By iframe = By.cssSelector("iframe[id='PrintWorkoutsiFrame']");
    private final By img = By.cssSelector("img[src*='finalsurge_logo.png']");
    private final By printStartDate = By.cssSelector("input[id='PrintStartDate']");
    private final By printEndDate = By.cssSelector("input[id='PrintEndDate']");
    private final By printWorkoutsBtn = By.xpath("//input[@id='saveButtonPrint']");
    private final By error = By.xpath("//div[@class='alert alert-error']");

    public void print(String startDate, String endDate) {
        switchToFrame(iframe);
        enterStartDate(startDate);
        enterEndDate(endDate);
        clickPrintWorkouts();
        switchToSecondWindow();
    }

    @Step("Get error message")
    public String getErrorText() {
        return driver.findElement(error).getText();
    }


    @Step("Enter start date")
    private void enterStartDate(String startDate) {
        driver.findElement(printStartDate).sendKeys(startDate);
    }

    @Step("Enter end date")
    private void enterEndDate(String endDate) {
        driver.findElement(printEndDate).sendKeys(endDate);
    }

    @Step("Click print workout button")
    private void clickPrintWorkouts() {
        driver.findElement(printWorkoutsBtn).click();
    }

    public boolean isLogoDisplayed() {
        return driver.findElement(img).isDisplayed();
    }

    @Override
    public boolean isPageOpened() {
        wait.until(ExpectedConditions.elementToBeClickable(printWorkoutsBtn));
        return true;
    }
}
