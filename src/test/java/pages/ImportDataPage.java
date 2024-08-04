package pages;

import decorators.DropDown;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.base.BasePage;

public class ImportDataPage extends BasePage {

    private final By inputSelectFile = By.name("FileUpload1");

    private final By dataImportStatus = By.xpath("//h3[@id='thestatus']");

    private final By uploadFileBtn = By.id("saveButton");
    private final By dropdown = By.id("LogType");

    public ImportDataPage() {
        super();
    }

    @Step("Upload file: {fileName}")
    public void uploadFile(String fileName) {
        selectFile(fileName);
        clickToUploadFile();
    }

    @Step("Getting dropdown")
    public DropDown getDropDown() {
        return new DropDown(driver, "LogType");

    }

    @Step("Select file: {fileName}")
    private void selectFile(String fileName) {
        driver.findElement(inputSelectFile).sendKeys(fileName);
    }

    @Step("Click to upload file button")
    public void clickToUploadFile() {
        driver.findElement(uploadFileBtn).click();
    }

    @Step("Getting Data Import Status Text")
    public String getDataImportStatusTxt() {
        return driver.findElement(dataImportStatus).getText();
    }

    @Override
    public boolean isPageOpened() {
        wait.until(ExpectedConditions.elementToBeClickable(uploadFileBtn));
        return true;
    }
}
