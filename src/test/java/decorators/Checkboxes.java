package decorators;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.*;

@Log4j2
public class Checkboxes {

    String checkboxesDownLocator = "%s";

    WebDriver driver;
    String id;

    public Checkboxes(WebDriver driver, String label) {
        this.driver = driver;
        this.id = label;
    }

    @Step("Tick checkbox as {isTrue}")
    public void tickCheckbox(boolean isTrue) {
        driver.findElement(By.id(String.format(checkboxesDownLocator, this.id))).click();
        log.info("Tick checkbox " + isTrue);

    }
}

