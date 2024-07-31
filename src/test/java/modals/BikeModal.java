package modals;

import decorators.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Bike;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Log4j2
public class BikeModal extends BaseModal {

    private final static By BIKE_NAME = By.id("ShoeName");
    private final static By BIKE_BRAND = By.xpath("//span[text()='Select Brand...']");
    private static final String bikeBrandLocator = "//ul[@class='select2-results']//div[contains(.,'%s')]";
    private final static By BIKE_MODEL = By.id("ShoeModel");
    private final static By BIKE_COST = By.id("ShoeCost");
    private final static By DATE = By.id("ShoeDate");
    private final static By STARTING_DISTANCE = By.id("StartDist");
    private final static By NOTES = By.id("ShoeNotes");
    private final static By ADD_BIKE_BUTTON = By.id("saveButton");

    public BikeModal() {
        super();
    }

    @Step("Selecting a bike brand")
    public void selectBikeBrand(String optionName) {
        log.info("Selecting a bike brand");
        driver.findElement(BIKE_BRAND).click();
        WebElement optionToClick = driver.findElement(By.xpath(String.format(bikeBrandLocator, optionName)));
        optionToClick.click();
    }

    @Step("Filling in the form to add a new bike")
    public BikeModal fillForm(Bike bike) {
        new Input(driver).setValueByModal(BIKE_NAME, bike.getBikeName());
        selectBikeBrand(bike.getBikeBrand().getName());
        new Input(driver).setValueByModal(BIKE_MODEL, bike.getModel());
        new Input(driver).setValueByModal(BIKE_COST, bike.getCost());
        new Input(driver).setValueByModal(DATE, bike.getDatePurchased());
        log.info("clearing prefilled input");
        driver.findElement(STARTING_DISTANCE).clear();
        new Input(driver).setValueByModal(STARTING_DISTANCE, bike.getDistance());
        new Input(driver).setValueByModal(NOTES, bike.getNotes());
        return this;
    }

    @Step("Clicking button 'Add Bike'")
    public void clickAddBikeButton() {
        log.info("clicking button 'Add Bike'");
        driver.findElement(ADD_BIKE_BUTTON).click();
    }
}

