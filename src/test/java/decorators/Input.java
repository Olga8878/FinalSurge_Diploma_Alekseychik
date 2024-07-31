package decorators;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Log4j2
public class Input {
    WebDriver driver;
    String id;

    public Input(WebDriver driver, String label) {
        this.driver = driver;
        this.id = label;
    }

    public Input(WebDriver driver) {
        this.driver = driver;
    }

    public void setValue(String text) {
        driver.findElement(By.id(String.format(this.id))).clear();
        log.info("Clear input with id  " + this.id);
        driver.findElement(By.id(String.format(this.id))).sendKeys(text);
        log.info("Write into input with label: " + id + "text: " + text);
    }

    public void setValueByModal(By locator, String value) {
        log.info(String.format("setting input: value = %s", value));
        driver.findElement(locator).sendKeys(value);
    }


}




