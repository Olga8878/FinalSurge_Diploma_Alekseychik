package pages;


import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.base.BasePage;

@Log4j2
public class CalendarPage extends BasePage {

    public final By quickAddButton = By.id("QuickAddToggle");

    String addedQuickWorkout = "//a[@class='dropdown-toggle detailslink']";

    public CalendarPage() {
        super();
    }

    @Step("Open Quick Workout")
    public WorkoutQuickAddPage clickQuickAdd() {
        log.info("Click Quick Add button by id: " + quickAddButton);
        driver.findElement(quickAddButton).click();
        return new WorkoutQuickAddPage();
    }

    @Step("The added quick workout is visible in the calendar")
    public boolean addedQuickWorkoutIsVisible() {
        log.info("Check that the added quick workout is visible in the calendar by xpath");
        return driver.findElement(By.xpath(addedQuickWorkout)).isDisplayed();
    }

    @Override
    public boolean isPageOpened() {
        wait.until(ExpectedConditions.elementToBeClickable(quickAddButton));
        return true;
    }
}

