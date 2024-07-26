package decorators;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

    @Log4j2
    public class RadioButton {

        String radioButton = "%s";
        String radioButtonInCaloricNeedsCalculator = "//label[contains(.,'%s')]/input";

        WebDriver driver;
        String id;
        String label;

        public RadioButton(WebDriver driver, String label) {
            this.driver = driver;
            this.id = label;
            this.label = label;
        }

        @Step("Click on RadioButton")
        public void clickRadioButton() {
            driver.findElement(By.id(String.format(radioButton, this.id))).click();
            log.info("Click with id: " + this.id);
        }

        @Step("Click on RadioButton in Caloric Needs Calculator")
        public void clickRadioButtonCaloricNeedsCalculator() {
            driver.findElement(By.xpath(String.format(radioButtonInCaloricNeedsCalculator, this.label))).click();
            log.info("Click with id: " + this.label);
        }



    }

