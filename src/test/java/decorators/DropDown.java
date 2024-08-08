package decorators;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class DropDown {
    WebDriver driver;
    String id;

    public DropDown(WebDriver driver, String label) {
        this.driver = driver;
        this.id = label;
    }

    @Step("Select an option from the drop-down")
    public void selectOption(String option) {
        log.info("Click on dropdown with id: " + this.id);
        driver.findElement(By.id(this.id)).click();
        log.info("Select option on the DropDown by xpath: " + option + "and click");
        driver.findElement(By.xpath(String.format("//option[text()='%s'] | //li[text()='%s'] | //select[@id='%s']/option[text()='%s']", option, option, this.id, option))).click();
    }
}


