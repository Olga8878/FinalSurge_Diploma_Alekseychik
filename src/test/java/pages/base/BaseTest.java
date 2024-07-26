package pages.base;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.LoginPage;
import utils.DriverFactory;
import utils.InvokedListener;
import utils.TestListener;


@Listeners({TestListener.class, InvokedListener.class})
public abstract class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;

    @BeforeClass(alwaysRun = true)
    public void setUp(ITestContext testContext) {
        driver = DriverFactory.getInstance().getDriver();
        testContext.setAttribute("driver", driver);
        loginPage = new LoginPage();
        loginPage.openURL();
        driver.manage().deleteAllCookies();
        Assert.assertTrue(loginPage.isPageOpened(),"The page is NOT opened.");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        DriverFactory.getInstance().tearDown();
    }
}