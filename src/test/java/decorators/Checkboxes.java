package decorators;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.*;

@Log4j2
public class Checkboxes {
    private final WebDriver driver;
    private final String id;

    public Checkboxes(WebDriver driver, String label) {
        this.driver = driver;
        this.id = label;
    }

    @Step("Tick checkbox as {isTrue}")
    public void tickCheckbox(boolean isTrue) {
        log.info("Tick checkbox " + isTrue);
        driver.findElement(By.id(this.id)).click();
    }
}

