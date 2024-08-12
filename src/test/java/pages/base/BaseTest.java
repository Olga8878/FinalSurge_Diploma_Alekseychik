package pages.base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.LoginPage;
import utils.DriverFactory;
import utils.InvokedListener;

@Listeners({InvokedListener.class})
public abstract class BaseTest {

    private WebDriver driver;
    protected LoginPage loginPage;

    @BeforeClass(alwaysRun = true)
    public synchronized void setUp(ITestContext testContext) {
        driver = DriverFactory.getInstance().getDriver();
        testContext.setAttribute("driver", driver);
        loginPage = new LoginPage();
    }

    @BeforeMethod(alwaysRun = true)
    public void prepareBrowser() {
        if (loginPage != null) {
            loginPage.closeSubWindows();
        }
    }

    @AfterMethod(alwaysRun = true)
    public void clearCookies() {
        driver.manage().deleteAllCookies();
        ((JavascriptExecutor) driver).executeScript("window.localStorage.clear();");
        ((JavascriptExecutor) driver).executeScript("window.sessionStorage.clear();");
    }

    @AfterClass(alwaysRun = true)
    public synchronized void tearDownDriver() {
        DriverFactory.getInstance().tearDown();
    }
}