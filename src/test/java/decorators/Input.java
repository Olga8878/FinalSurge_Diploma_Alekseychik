package decorators;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


@Log4j2
public class Input {
    WebDriver driver;
    String id;

    public Input(WebDriver driver, String label) {
        this.driver = driver;
        this.id = label;
    }

    public void setValue(String text) {
        log.info("Clear input with id  " + this.id);
        driver.findElement(By.id(String.format(this.id))).clear();
        log.info("Write into input with label: " + id + "text: " + text);
        driver.findElement(By.id(String.format(this.id))).sendKeys(text);
    }
}





