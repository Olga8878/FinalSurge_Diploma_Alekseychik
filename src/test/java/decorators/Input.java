package decorators;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


@Log4j2
public class Input {
    WebDriver driver;
    String id;

    public Input(WebDriver driver, String label) {
        this.driver = driver;
        this.id = label;
    }

    public void setValue(String text) {
        WebElement inputElement = driver.findElement(By.id(this.id));
        inputElement.clear();
        log.info("Clear input with id  " + this.id);
        inputElement.sendKeys(text);
        log.info("Write into input with label: " + id + "text: " + text);
    }

    public void inputBDay(String text) {
        WebElement inputElement = driver.findElement(By.id(this.id));
        inputElement.clear();
        log.info("Clear input BDay with id:  " + this.id);
        Actions action = new Actions(driver);
        action.doubleClick(inputElement).perform();
        inputElement.sendKeys(text);
        log.info("Write into input BDay by id: " + this.id + "text: " + text);
    }

}

