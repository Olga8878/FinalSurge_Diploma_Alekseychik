package pages;

import enums.BikeBrand;
import io.qameta.allure.Step;
import models.Bike;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.base.BasePage;

public class EquipmentBikesPage extends BasePage {
    private final By EDIT_BUTTON = By.xpath("//a[@title='Edit']");
    private final By DELETE_BUTTON = By.xpath("//a[@id='del-shoe2']");
    private final By OK_BUTTON = By.xpath("//a[text()='OK']");
    private final By ACTUAL_BIKE_NAME = By.id("ShoeName");
    private final By ACTUAL_BIKE_BRAND = By.xpath("//a[@class='select2-choice']/span");
    private final By ACTUAL_BIKE_MODEL = By.id("ShoeModel");
    private final By ACTUAL_BIKE_COST = By.id("ShoeCost");
    private final By ACTUAL_DATE = By.id("ShoeDate");
    private final By ACTUAL_STARTING_DISTANCE = By.id("StartDist");
    private final By ACTUAL_NOTES = By.id("ShoeNotes");
    private final By NO_BIKES_TEXT = By.xpath("//div[@class='hero-unit']/p[1]");

    public EquipmentBikesPage() {
        super();
    }


    @Step("Getting added bike details")
    public Bike getAddedBikeDetails() {
        Bike addedBike = new Bike();
        addedBike.setBikeName(getActualName());
        addedBike.setBikeBrand(BikeBrand.fromString(getActualBrand()));
        addedBike.setModel(getActualModel());
        addedBike.setCost(getActualCost());
        addedBike.setDatePurchased(getActualDate());
        addedBike.setDistance(getActualDistance());
        addedBike.setNotes(getActualNotes());
        return addedBike;

    }

    @Step("Getting added bike name")
    public String getActualName() {
        return driver.findElement(ACTUAL_BIKE_NAME).getAttribute("value");
    }

    @Step("Getting added bike brand")
    public String getActualBrand() {
        return driver.findElement(ACTUAL_BIKE_BRAND).getText();
    }

    @Step("Getting added bike model")
    public String getActualModel() {
        return driver.findElement(ACTUAL_BIKE_MODEL).getAttribute("value");
    }

    @Step("Getting added bike cost")
    public String getActualCost() {
        return driver.findElement(ACTUAL_BIKE_COST).getAttribute("value");
    }

    @Step("Getting actual date")
    public String getActualDate() {
        return driver.findElement(ACTUAL_DATE).getAttribute("value");
    }

    @Step("Getting actual distance")
    public String getActualDistance() {
        return driver.findElement(ACTUAL_STARTING_DISTANCE).getAttribute("value");
    }

    @Step("Getting added bike notes")
    public String getActualNotes() {
        return driver.findElement(ACTUAL_NOTES).getAttribute("value");
    }

    @Step("Clicking button 'Edit'")
    public void clickEditButton() {
        driver.findElement(EDIT_BUTTON).click();
    }

    @Step("Clicking button 'Delete'")
    public void clickDeleteButton() {
        driver.findElement(DELETE_BUTTON).click();
    }

    @Step("Clicking button 'OK'")
    public void clickOKButton() {
        driver.findElement(OK_BUTTON).click();
    }

    @Step("Getting text about absence of current bikes")
    public String getNoBikesText() {
        return driver.findElement(NO_BIKES_TEXT).getText();
    }

    @Override
    public boolean isPageOpened() {
        wait.until(ExpectedConditions.elementToBeClickable(OK_BUTTON));
        return true;
    }
}


