package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.base.BaseTest;
import pages.PrintWorkoutsPage;
import utils.PropertyReader;

public class PrintWorkoutsTest extends BaseTest {

    public PrintWorkoutsPage printWorkoutsPage;

    @BeforeMethod(alwaysRun = true)
    public void loginAndMoveToPrintWorkouts(){
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = loginPage.login(PropertyReader.getProperty("email"), PropertyReader.getProperty("password"));
        printWorkoutsPage = dashboardPage.clickPrintWorkouts();
    }
    @Test(groups = "negative")
    public void verifyPrintWithoutData() {
        String expectedErrorMsg = """
                ×
                Please fix the following errors:
                *The date range you have selected does not contain any workouts. Please close this browser window and adjust your date range.""";
        printWorkoutsPage.print("07/07/2024", "07/09/2024");
        Assert.assertEquals(printWorkoutsPage.getErrorText(), expectedErrorMsg,
               "Error message does NOT appear");
    }

    @Test(groups = "positive")
    public void verifyPrintWithData() {
        printWorkoutsPage.print("07/12/2024", "07/12/2024");
        Assert.assertTrue(printWorkoutsPage.isLogoDisplayed(),"Some data about fitness does NOT exist.");
    }
}
