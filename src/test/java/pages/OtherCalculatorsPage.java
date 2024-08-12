package pages;

import enums.Gender;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.base.BasePage;

public class OtherCalculatorsPage extends BasePage {

    private final By weightInput = By.id("Weight");
    private final By heightInput = By.id("HeightInchCent");
    private final By ageInput = By.id("Age");
    private final By todaysRunInput = By.id("RunDist");
    private final By calcBtn = By.id("saveButtonSettings");
    private final By errorMsg = By.xpath("//div[contains(@class,'alert alert-error')]");
    private final By trainingCalories = By.xpath("//table[contains(@class,'table table-condensed')]//td[2]");

    @Step("Enter weight 'weight'")
    private OtherCalculatorsPage enterWeight(String value) {
        driver.findElement(weightInput).sendKeys(value);
        return this;
    }

    @Step("Enter height 'height' ")
    private OtherCalculatorsPage enterHeight(String value) {
        driver.findElement(heightInput).sendKeys(value);
        return this;
    }

    @Step("Enter age 'age' ")
    private OtherCalculatorsPage enterAge(String value) {
        driver.findElement(ageInput).sendKeys(value);
        return this;
    }

    @Step("Enter distance")
    private OtherCalculatorsPage enterRunDistance(String value) {
        driver.findElement(todaysRunInput).sendKeys(value);
        return this;
    }

    @Step("Click calculation button")
    private OtherCalculatorsPage clickToCalcBtn() {
        driver.findElement(calcBtn).click();
        return this;
    }

    @Step("Select gender 'gender'")
    private OtherCalculatorsPage selectGender(Gender gender) {
        driver.findElement(By.id(gender.getLocator())).click();
        return this;
    }

    @Step("Enter information for calculation")
    public OtherCalculatorsPage enterDataForCalculation(String weight, String height, String age, String runDistance, Gender gender) {
        return enterWeight(weight).
                enterHeight(height).
                enterAge(age).
                enterRunDistance(runDistance).
                selectGender(gender).
                clickToCalcBtn();
    }

    @Step("Get error message")
    public String getErrorMsg() {
        return driver.findElement(errorMsg).getText();
    }

    @Step("Get training calories")
    public String getTrainingCalories() {
        return driver.findElement(trainingCalories).getText();
    }


    @Override
    public boolean isPageOpened() {
        wait.until(ExpectedConditions.elementToBeClickable(calcBtn));
        return true;
    }
}
