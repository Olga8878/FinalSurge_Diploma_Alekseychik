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
    public void setUp(ITestContext testContext) {
        driver = DriverFactory.getInstance().getDriver();
        testContext.setAttribute("driver", driver);
        loginPage = new LoginPage();
    }

    @BeforeMethod(alwaysRun = true)
    public void prepareBrowser() {
        if (loginPage != null) {
            loginPage.closeSubWindows();
            restartCrashedBrowser();
        }
    }

    private void restartCrashedBrowser() {
        try {
            loginPage.checkWebDriver();
        } catch (Throwable throwable) {
            DriverFactory.getInstance().tearDown();
        }
    }

    @AfterMethod(alwaysRun = true)
    public void clearCookies() {
        driver.manage().deleteAllCookies();
        ((JavascriptExecutor) driver).executeScript(String.format("window.localStorage.clear();"));
        ((JavascriptExecutor) driver).executeScript(String.format("window.sessionStorage.clear();"));
    }

    @AfterClass(alwaysRun = true)
    public void tearDownDriver() {
        DriverFactory.getInstance().tearDown();
    }
}