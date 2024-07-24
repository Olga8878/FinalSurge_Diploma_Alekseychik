package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.base.BasePage;

public class DashboardPage extends BasePage {

    public final By workoutHeader = By.xpath("//a[text()='Workouts']");
    public final By addWorkout = By.xpath("//a[text()='Add Workout']");
    public final By importData = By.xpath("//a[text()='Import Data']");
    public final By gearRoutesHeader = By.xpath("//a[text()='Gear & Routes']");
    public final By shoes = By.xpath("//a[text()='Shoes']");
    public final By dailyVitalsHeader = By.xpath("//a[text()='Daily Vitals']");
    public final By viewAddVitals = By.xpath("//a[text()='View & Add Vitals']");
    public final By dashboardButton = By.xpath("//*[@class='icsw16-home']");
    public final By calendar = By.xpath("//li/a[text()='Training Calendar']");
    public final By workoutCalculators = By.cssSelector("[data-reveal-id='IntensityCalc']");
    public final By otherCalculators = By.cssSelector("[data-reveal-id='OtherCalc']");
    public final By logoutLink = By.xpath("//a[text()='Logout']");
    public static final By logoutMessage = By.cssSelector("[class^='alert']");
    public final By printWorkoutsLink = By.xpath("//a[@data-reveal-id='PrintWorkouts']/i");

    public DashboardPage() {
        super();
    }

    @Step
    public WorkoutQuickAddPage navigateToAddWorkout() {
        moveToWorkoutHeader();
        driver.findElement(addWorkout).click();
        return new WorkoutQuickAddPage();
    }

    private void moveToWorkoutHeader() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(workoutHeader)).build().perform();
    }

    @Step
    public ImportDataPage navigateToImportData() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(workoutHeader)).build().perform();
        driver.findElement(importData).click();
        return new ImportDataPage();
    }

    @Step
    public boolean dashboardButtonIsDisplayed() {
        return driver.findElement(dashboardButton).isDisplayed();
    }

    @Step("Clicking 'Calendar'")
    public CalendarPage clickCalendar() {
        driver.findElement(calendar).click();
        return new CalendarPage();
    }

    @Step("Clicking 'Workout Calculators'")
    public WorkoutQuickAddPage clickWorkoutCalculators() {
        driver.findElement(workoutCalculators).click();
        return new WorkoutQuickAddPage();
    }

    @Step("Clicking 'Other Calculators'")
    public OtherCalculatorsPage clickOtherCalculators() {
        driver.findElement(otherCalculators).click();
        return new OtherCalculatorsPage();
    }

    @Step("Clicking 'Print Workouts' link")
    public PrintWorkoutsPage clickPrintWorkouts() {
        driver.findElement(printWorkoutsLink).click();
        return new PrintWorkoutsPage();
    }

    @Step("Clicking 'Logout' link")
    public void clickLogoutButton() {
        driver.findElement(logoutLink).click();
    }

    @Step("Getting message about successfully logged out of the system")
    public static String getLogoutMessage() {
        return driver.findElement(logoutMessage).getText();
    }

    @Override
    public boolean isPageOpened() {
        wait.until(ExpectedConditions.elementToBeClickable(dashboardButton));
        return true;
    }
}


