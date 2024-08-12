package tests;

import models.WorkoutQuickAdd;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CalendarPage;
import pages.DashboardPage;
import pages.WorkoutQuickAddPage;
import pages.base.BaseTest;
import pages.PrintWorkoutsPage;
import utils.PropertyReader;
import utils.testDataFactory.WorkoutQuickAddFactory;

public class PrintWorkoutsTest extends BaseTest {

    public PrintWorkoutsPage printWorkoutsPage;
    public DashboardPage dashboardPage;

    @BeforeMethod(alwaysRun = true)
    public void loginAndMoveToPrintWorkouts() {
        dashboardPage = loginPage.login(PropertyReader.getProperty("email"), PropertyReader.getProperty("password"));
    }

    @Test(groups = "negative")
    public void verifyPrintWithoutData() {
        String expectedErrorMsg = """
                ×
                Please fix the following errors:
                *The date range you have selected does not contain any workouts. Please close this browser window and adjust your date range.""";
        printWorkoutsPage = dashboardPage.clickPrintWorkouts();
        printWorkoutsPage.print("07/07/2024", "07/09/2024");
        Assert.assertEquals(printWorkoutsPage.getErrorText(), expectedErrorMsg,
                "Error message does NOT appear");
    }

    @Test(groups = "positive")
    public void verifyPrintWithDataWorkout() {
        CalendarPage calendarPage = dashboardPage.clickCalendar();
        WorkoutQuickAddPage workoutQuickAddPage = calendarPage.clickQuickAdd();
        WorkoutQuickAdd workoutQuickAdd = WorkoutQuickAddFactory.getWorkoutQuickData();
        workoutQuickAdd.setDate("07/12/2024");
        workoutQuickAddPage.fillInFormQuickWorkout(workoutQuickAdd);
        dashboardPage.navigateToDashboardPage();
        printWorkoutsPage = dashboardPage.clickPrintWorkouts();
        printWorkoutsPage.print("07/12/2024", "07/12/2024");
        Assert.assertTrue(printWorkoutsPage.isLogoDisplayed(), "Some data about fitness does NOT exist.");
    }
}
