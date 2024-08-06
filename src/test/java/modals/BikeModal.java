package modals;

import decorators.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Bike;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@Log4j2
public class BikeModal extends BaseModal {

    private final  By BIKE_BRAND = By.xpath("//span[text()='Select Brand...']");
    private final String BIKE_BRAND_LOCATOR = "//ul[@class='select2-results']//div[contains(.,'%s')]";
    private final  By STARTING_DISTANCE = By.id("StartDist");

    private final  By ADD_BIKE_BUTTON = By.id("saveButton");

    public BikeModal() {
        super();
    }

    @Step("Selecting a bike brand")
    public void selectBikeBrand(String optionName) {
        log.info("Selecting a bike brand");
        driver.findElement(BIKE_BRAND).click();
        WebElement optionToClick = driver.findElement(By.xpath(String.format(BIKE_BRAND_LOCATOR, optionName)));
        optionToClick.click();
    }

    @Step("Filling in the form to add a new bike")
    public BikeModal fillForm(Bike bike) {
        new Input(driver, "ShoeName").setValue(bike.getBikeName());
        selectBikeBrand(bike.getBikeBrand().getName());
        new Input(driver, "ShoeModel").setValue(bike.getModel());
        new Input(driver, "ShoeCost").setValue(bike.getCost());
        new Input(driver, "ShoeDate").setValue(bike.getDatePurchased());
        log.info("clearing prefilled input");
        driver.findElement(STARTING_DISTANCE).clear();
        new Input(driver, "StartDist").setValue(bike.getDistance());
        new Input(driver, "ShoeNotes").setValue(bike.getNotes());
        return this;
    }

    @Step("Clicking button 'Add Bike'")
    public void clickAddBikeButton() {
        log.info("clicking button 'Add Bike'");
        driver.findElement(ADD_BIKE_BUTTON).click();
    }
}

