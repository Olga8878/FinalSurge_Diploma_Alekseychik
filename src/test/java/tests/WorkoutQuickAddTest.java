package tests;

import models.WorkoutQuickAdd;
import utils.TestDataFactory.WorkoutQuickAddFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import pages.base.BaseTest;
import utils.PropertyReader;


public class WorkoutQuickAddTest extends BaseTest {

    public CalendarPage calendarPage;

    @BeforeMethod(alwaysRun = true)
    public void loginAndMoveToWorkoutQuick() {
        DashboardPage dashboardPage = loginPage.login(PropertyReader.getProperty("email"), PropertyReader.getProperty("password"));
        calendarPage = dashboardPage.clickCalendar();
    }
    @Test(groups = "positive")
    public void addQuickWorkout() {
        WorkoutQuickAddPage workoutQuickAddPage = calendarPage.clickQuickAdd();
        WorkoutQuickAdd workoutQuickAdd = WorkoutQuickAddFactory.getWorkoutQuickData();
        workoutQuickAddPage.fillInFormQuickWorkout(workoutQuickAdd);
        Assert.assertTrue(calendarPage.addedQuickWorkoutIsVisible(),
                "A quick workout has not been added");
    }
}








