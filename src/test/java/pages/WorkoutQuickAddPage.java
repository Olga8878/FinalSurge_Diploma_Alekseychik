package pages;

import decorators.Checkboxes;
import decorators.DropDown;
import decorators.Input;
import decorators.TextArea;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.WorkoutQuickAdd;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.base.BasePage;

@Log4j2
public class WorkoutQuickAddPage extends BasePage {

    public final By addWorkoutButton = By.id("saveButton");

    public WorkoutQuickAddPage() {
        super();
    }

    @Step("Add workout through the quick add")
    public void fillInFormQuickWorkout(WorkoutQuickAdd workoutQuickAdd) {
        log.info("Fill in the data " + workoutQuickAdd);
        new Input(driver, "WorkoutDate").setValue(workoutQuickAdd.getDate());
        new DropDown(driver, "WorkoutTime").selectOption(workoutQuickAdd.getTime());
        new DropDown(driver, "ActivityType").selectOption(workoutQuickAdd.getActivityType());
        new Input(driver, "Name").setValue(workoutQuickAdd.getWorkoutName());
        new TextArea(driver, "Desc").write(workoutQuickAdd.getWorkoutDescription());
        new Checkboxes(driver, "PlannedWorkout").tickCheckbox(workoutQuickAdd.isShowPlanned());
        if (workoutQuickAdd.isShowPlanned()) {
            new Input(driver, "PDistance").setValue(workoutQuickAdd.getPlannedDistance());
            new DropDown(driver, "PDistType").selectOption(workoutQuickAdd.getPlannedDistanceType());
            new Input(driver, "PDuration").setValue(workoutQuickAdd.getPlannedDuration());
        }
        new Input(driver, "Distance").setValue(workoutQuickAdd.getDistance());
        new DropDown(driver, "DistType").selectOption(workoutQuickAdd.getDistType());
        new Input(driver, "Duration").setValue(workoutQuickAdd.getDuration());
        new Input(driver, "Pace").setValue(workoutQuickAdd.getPace());
        new DropDown(driver, "PaceType").selectOption(workoutQuickAdd.getPaceType());
        new DropDown(driver, "HowFeel").selectOption(workoutQuickAdd.getHowIFelt());
        new DropDown(driver, "PerEffort").selectOption(workoutQuickAdd.getPerceivedEffort());
        new TextArea(driver, "PostDesc").write(workoutQuickAdd.getPostDesc());
        new Checkboxes(driver, "SaveLibrary").tickCheckbox(workoutQuickAdd.isSaveLibrary());
        clickSaveButton();
    }

    @Step("Click Add Workout button")
    public WorkoutQuickAddPage clickSaveButton() {
        log.info("Click Add Workout button by id: " + addWorkoutButton);
        driver.findElement(addWorkoutButton).click();

        return new WorkoutQuickAddPage();
    }

    @Override
    public boolean isPageOpened() {
        wait.until(ExpectedConditions.elementToBeClickable(addWorkoutButton));
        return true;
    }
}


