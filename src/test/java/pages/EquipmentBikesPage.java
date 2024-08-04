package pages;

import enums.BikeBrand;
import io.qameta.allure.Step;
import models.Bike;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.base.BasePage;

public class EquipmentBikesPage extends BasePage {
    private final By editButton = By.xpath("//a[@title='Edit']");
    private final By deleteButton = By.xpath("//a[@id='del-shoe2']");
    private final By okButton = By.xpath("//a[text()='OK']");
    private final By actualBikeName = By.id("ShoeName");
    private final By actualBikeBrand = By.xpath("//a[@class='select2-choice']/span");
    private final By actualBikeModel = By.id("ShoeModel");
    private final By actualBikeCost = By.id("ShoeCost");
    private final By actualDate = By.id("ShoeDate");
    private final By actualStartingDistance = By.id("StartDist");
    private final By actualNotes = By.id("ShoeNotes");
    private final By NoBikesText = By.xpath("//div[@class='hero-unit']/p[1]");

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
        return driver.findElement(actualBikeName).getAttribute("value");
    }

    @Step("Getting added bike brand")
    public String getActualBrand() {
        return driver.findElement(actualBikeBrand).getText();
    }

    @Step("Getting added bike model")
    public String getActualModel() {
        return driver.findElement(actualBikeModel).getAttribute("value");
    }

    @Step("Getting added bike cost")
    public String getActualCost() {
        return driver.findElement(actualBikeCost).getAttribute("value");
    }

    @Step("Getting actual date")
    public String getActualDate() {
        return driver.findElement(actualDate).getAttribute("value");
    }

    @Step("Getting actual distance")
    public String getActualDistance() {
        return driver.findElement(actualStartingDistance).getAttribute("value");
    }

    @Step("Getting added bike notes")
    public String getActualNotes() {
        return driver.findElement(actualNotes).getAttribute("value");
    }

    @Step("Clicking button 'Edit'")
    public void clickEditButton() {
        driver.findElement(editButton).click();
    }

    @Step("Clicking button 'Delete'")
    public void clickDeleteButton() {
        driver.findElement(deleteButton).click();
    }

    @Step("Clicking button 'OK'")
    public void clickOKButton() {
        driver.findElement(okButton).click();
    }

    @Step("Getting text about absence of current bikes")
    public String getNoBikesText() {
        return driver.findElement(NoBikesText).getText();
    }

    @Override
    public boolean isPageOpened() {
        wait.until(ExpectedConditions.elementToBeClickable(okButton));
        return true;
    }
}


