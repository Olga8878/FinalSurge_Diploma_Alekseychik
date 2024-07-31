package modals;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;


@Log4j2
public abstract class BaseModal {

    static WebDriver driver;

    public BaseModal() {
        driver = DriverFactory.getInstance().getDriver();
    }

}

