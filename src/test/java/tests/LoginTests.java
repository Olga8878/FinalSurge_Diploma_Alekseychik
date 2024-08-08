package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.base.BaseTest;
import utils.PropertyReader;

public class LoginTests extends BaseTest {

    @Test(groups = "positive")
    public void verifyLoginTest() {
        DashboardPage dashboardPage = loginPage.login(PropertyReader.getProperty("email"), PropertyReader.getProperty("password"));
        Assert.assertTrue(dashboardPage.isPageOpened(), "The Dashboard page is NOT opened.");
    }
}