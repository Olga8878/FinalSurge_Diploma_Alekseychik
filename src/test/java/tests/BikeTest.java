package tests;

import jdk.jfr.Description;
import modals.BikeModal;
import models.Bike;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import pages.base.BaseTest;
import utils.PropertyReader;
import utils.TestDataFactory.BikeFactory;


public class BikeTest extends BaseTest {
    protected BikeModal bikeModal;
    protected EquipmentBikesPage equipmentBikesPage;
    protected DashboardPage dashboardPage;
    protected final String EXPECTED_TEXT = "You have no Current bikes. Add one now by using the Add New Bike form.";

    @BeforeMethod(alwaysRun = true)
    public void initialize() {
        LoginPage loginPage = new LoginPage();
        dashboardPage = loginPage.login(PropertyReader.getProperty("email"), PropertyReader.getProperty("password"));
        equipmentBikesPage = dashboardPage.navigateToAddBike();
        bikeModal = new BikeModal();
    }

    @Test(groups = "positive")
    public void addAndDeleteNewBikeTest() {
        Bike myBike = BikeFactory.addNewBike();
        bikeModal.fillForm(myBike);
        bikeModal.clickAddBikeButton();
        equipmentBikesPage.clickEditButton();
        Assert.assertEquals(myBike, equipmentBikesPage.getAddedBikeDetails());
        equipmentBikesPage.clickDeleteButton();
        equipmentBikesPage.clickOKButton();
        Assert.assertEquals(equipmentBikesPage.getNoBikesText(), EXPECTED_TEXT);
    }
}



