package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.base.BasePage;

public class DashboardPage extends BasePage {

    public final By workoutHeader= By.xpath("//a[text()='Workouts']");
    public final By addWorkout = By.xpath("//a[text()='Add Workout']");
    public final By importData = By.xpath("//a[text()='Import Data']");
    public final By customizeActivityTypes = By.xpath("//a[text()='Customize Activity Types']");
    public final By paceZones = By.xpath("//a[text()='HR/Power/Pace Zones']");
    public final By gearRoutesHeader= By.xpath("//a[text()='Gear & Routes']");
    public final By shoes = By.xpath("//a[text()='Shoes']");
    public final By dailyVitalsHeader= By.xpath("//a[text()='Daily Vitals']");
    public final By viewAddVitals = By.xpath("//a[text()='View & Add Vitals']");
    public final By dashboardButton = By.xpath("//*[@class='icsw16-home']");
    public final By calendar = By.className("icsw16-day-calendar");
    public final By workoutCalculators= By.xpath("//i[@class='icsw16-stop-watch']");
    public final By otherCalculators = By.xpath("//i[@class='icsw16-calculator']");
    public final By logoutLink = By.xpath("//a[text()='Logout']");
    public static final By  logoutMessage = By.cssSelector("[class^='alert']");
    public final By printWorkoutsLink = By.xpath("//nav//li//i[@class='icsw16-printer']/..");
    public final By reportsStatisticsLink = By.xpath("//a/i[@class='icsw16-graph']");

    public DashboardPage() {
        super();
    }

    @Step
    public ShoesPage navigateToShoesPage() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(gearRoutesHeader)).build().perform();
        driver.findElement(shoes).click();
        return new ShoesPage();
    }

    @Step
    public void navigateToAddWorkout() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(workoutHeader)).build().perform();
        driver.findElement(addWorkout).click();
    }

    @Step
    public ImportDataPage navigateToImportData() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(workoutHeader)).build().perform();
        driver.findElement(importData).click();
        return new ImportDataPage();
    }

    @Step
    public void openCustomizeActivityTypes() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(workoutHeader)).build().perform();
        driver.findElement(customizeActivityTypes).click();
    }

    @Step
    public void openAddPaceZones() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(workoutHeader)).build().perform();
        driver.findElement(paceZones).click();
    }

    @Step
    public void navigateToViewAddVitals() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(dailyVitalsHeader)).build().perform();
        driver.findElement(viewAddVitals).click();
    }

    @Step
    public boolean dashboardButtonIsDisplayed() {
        return driver.findElement(dashboardButton).isDisplayed();
    }

    @Step("Clicking 'Calendar'")
    public void clickCalendar() {
        driver.findElement(calendar ).click();
    }

    @Step("Clicking 'Workout Calculators'")
    public void clickWorkoutCalculators() {
        driver.findElement(workoutCalculators).click();
    }

    @Step("Clicking 'Other Calculators'")
    public OtherCalculatorsPage clickOtherCalculators() {
        driver.findElement(otherCalculators ).click();
        return new OtherCalculatorsPage();
    }

    @Step("Clicking 'Print Workouts' link")
    public PrintWorkoutsPage clickPrintWorkouts() {
        driver.findElement(printWorkoutsLink).click();
        return new PrintWorkoutsPage();
    }

    @Step("Clicking 'Reports & Statistics' link")
    public void clickReportsAndStatistics() {
        driver.findElement(reportsStatisticsLink).click();
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


