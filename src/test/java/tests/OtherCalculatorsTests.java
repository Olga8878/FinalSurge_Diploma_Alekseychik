package tests;

import enums.Gender;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.base.BaseTest;
import pages.OtherCalculatorsPage;
import utils.PropertyReader;

public class OtherCalculatorsTests extends BaseTest {

    public OtherCalculatorsPage otherCalculatorsPage;


    @BeforeMethod(alwaysRun = true)
    public void loginAndMoveToOtherCalc() {
        DashboardPage dashboardPage = loginPage.login(PropertyReader.getProperty("email"), PropertyReader.getProperty("password"));
        otherCalculatorsPage = dashboardPage.clickOtherCalculators();
    }

    @DataProvider(name = "validationToEmpty")
    public Object[][] someDataForTest() {
        return new Object[][]{
                {"50", "80", "30", "", "*Please enter a value for Run Distance."},
                {"50", "80", "", "5", "*Please enter an Integer value for Age."},
                {"", "80", "30", "5", "*Please enter a value for Weight."},
                {"50", "", "30", "5", "*Please enter a value for Height in Inches."}
        };
    }

    @Test(groups = "negative", dataProvider = "validationToEmpty")
    public void verifyCalculatorIfOneInputIsEmpty(String weight, String height, String age, String runDist, String errorMsg) {
        otherCalculatorsPage.enterDataForCalculation(weight, height, age, runDist, Gender.FEMALE);
        Assert.assertTrue(otherCalculatorsPage.getErrorMsg().contains(errorMsg), "Error message incorrect");
    }

    @Test(groups = "negative")
    public void verifyCalculatorAgeValidation() {
        String expectedErrorMsg = "*Age cannot be less than 5.";
        String ageLessFive = "4";
        otherCalculatorsPage.enterDataForCalculation("50", "80", ageLessFive, "5", Gender.FEMALE);
        Assert.assertTrue(otherCalculatorsPage.getErrorMsg().contains(expectedErrorMsg), "Error message incorrect");
    }

    @Test(groups = "negative")
    public void verifyCalculatorHeightValidation() {
        String expectedErrorMsg = "*Height in Inches cannot be less than 2.00.";
        String heightLessTwo = "1";
        otherCalculatorsPage.enterDataForCalculation("50", heightLessTwo, "10", "5", Gender.FEMALE);
        Assert.assertTrue(otherCalculatorsPage.getErrorMsg().contains(expectedErrorMsg), "Error message incorrect");
    }

    @Test(groups = "positive")
    public void verifyCalculatorTrainingCalories() {
        String runDistance = "5";
        String weightLbs = "30";
        String height = "2";
        String age = "5";
        String expectedTrainingCalories = Math.round((Integer.parseInt(weightLbs) * 0.453592) * (Integer.parseInt(runDistance) * 1.60934)) + " kCal";
        otherCalculatorsPage.enterDataForCalculation(weightLbs, height, age, runDistance, Gender.FEMALE);
        Assert.assertEquals(otherCalculatorsPage.getTrainingCalories(), expectedTrainingCalories, "Traning Calories is NOT calculated correctly.");
    }
}
