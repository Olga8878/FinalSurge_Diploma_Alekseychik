package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.base.BaseTest;
import pages.ImportDataPage;
import utils.PropertyReader;

public class ImportDataTests extends BaseTest {

    public ImportDataPage importDataPage;

    @BeforeMethod(alwaysRun = true)
    public void loginAndMoveToPrintWorkouts() {
        DashboardPage dashboardPage = loginPage.login(PropertyReader.getProperty("email"), PropertyReader.getProperty("password"));
        importDataPage = dashboardPage.navigateToImportData();
    }

    @Test(groups = "negative")
    public void verifyUploadWithoutFileOnImportData() {
        importDataPage.clickToUploadFile();
        Assert.assertEquals(importDataPage.getDataImportStatusTxt(),
                "You did not upload a valid import fil. Please choose a valid file and try again.");

    }

    @Test(groups = "positive")
    public void verifyUploadFileOnImportData() {

        String fileName = System.getProperty("user.dir") + "/src/test/resources/example.tcx";
        importDataPage.getDropDown().selectOption("MySwimBikeRun");
        importDataPage.uploadFile(fileName);
        Assert.assertEquals(importDataPage.getDataImportStatusTxt(),
                "Your data import is complete! Your imported workouts will now be displayed on your calendar.", "Correct import");
    }
}
