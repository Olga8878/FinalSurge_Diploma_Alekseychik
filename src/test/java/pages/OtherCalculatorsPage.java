package pages;

import org.openqa.selenium.By;
import pages.base.BasePage;

public class OtherCalculatorsPage extends BasePage {

    private final By weightInput = By.id("Weight");
    private final By heightInput = By.id("HeightInchCent");
    private final By ageInput = By.id("Age");
    private final By todaysRunInput = By.id("RunDist");
    private final By calcBtn = By.id("saveButtonSettings");
    private final By errorMsg = By.xpath("//div[contains(@class,'alert alert-error')]");
    private final By trainingCalories = By.xpath("//table[contains(@class,'table table-condensed')]//td[2]");

    private void enterWeight(String value){
        driver.findElement(weightInput).sendKeys(value);
    }

    private void enterHeight(String value){
        driver.findElement(heightInput).sendKeys(value);
    }

    private void enterAge(String value){
        driver.findElement(ageInput).sendKeys(value);
    }

    private void enterRunDistance(String value){
        driver.findElement(todaysRunInput).sendKeys(value);
    }

    private void clickToCalcBtn(){
        driver.findElement(calcBtn).click();
    }

    private void selectGender(Gender gender){
        driver.findElement(By.id(gender.getLocator())).click();
    }

    public void enterDataForCalculation(String weight, String height, String age, String runDistance, Gender gender){
        enterWeight(weight);
        enterHeight(height);
        enterAge(age);
        enterRunDistance(runDistance);
        selectGender(gender);
        clickToCalcBtn();
    }

    public String getErrorMsg(){
        return driver.findElement(errorMsg).getText();
    }

    public String getTrainingCalories(){
        return driver.findElement(trainingCalories).getText();
    }

    public enum Gender {
        MALE("optionsRadios5"),
        FEMALE("optionsRadios6");

        private final String name;

        Gender(String name){
            this.name = name;
        }

        public String getLocator(){
            return this.name;
        }
    }

    @Override
    public boolean isPageOpened() {
        return false;
    }
}
