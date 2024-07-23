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
    public void loginAndMoveToPrintWorkouts(){
        DashboardPage dashboardPage = loginPage.login(PropertyReader.getProperty("email"), PropertyReader.getProperty("password"));
        importDataPage = dashboardPage.navigateToImportData();
    }
    @Test(groups = "negative")
    public void verifyUploadWithoutFileOnImportData() {
        importDataPage.clickToUploadFile();
        Assert.assertEquals(importDataPage.getDataImportStatusTxt(),
                "You did not upload a valid import file. Please choose a valid file and try again.");

    }

    @Test(groups = "positive")
    public void verifyUploadFileOnImportData() {
        String fileName = System.getProperty("user.dir") + "/src/test/resources/testFile.csv";
        importDataPage.uploadFile(fileName);
        //Assert.assertEquals(importDataPage.getDataImportStatusTxt(),
        //        "You did not upload a valid import file. Please choose a valid file and try again.");
    }
}
