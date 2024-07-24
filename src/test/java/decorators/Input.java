package decorators;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


@Log4j2
public class Input {
    String inputLocator = "%s";
    WebDriver driver;
    String id;

    public Input(WebDriver driver, String label) {
        this.driver = driver;
        this.id = label;
    }

    public void setValue(String text) {
        driver.findElement(By.id(String.format(inputLocator, this.id))).clear();
        log.info("Clear input with id  " + this.id);
        driver.findElement(By.id(String.format(inputLocator, this.id))).sendKeys(text);
        log.info("Write into input with label: " + id + "text: " + text);
    }

    public void inputBDay(String text) {
        driver.findElement(By.id(String.format(inputLocator, this.id))).clear();
        log.info("Clear input BDay with id:  " + inputLocator);
        Actions action = new Actions(driver);
        action.doubleClick(driver.findElement(By.id(String.format(inputLocator, this.id)))).perform();
        driver.findElement(By.id(String.format(inputLocator, this.id))).sendKeys(text);
        log.info("Write into input BDay by id: " + this.id + "text: " + text);

    }


}

