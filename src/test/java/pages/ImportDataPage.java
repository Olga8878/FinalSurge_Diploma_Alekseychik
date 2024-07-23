package pages;

import org.openqa.selenium.By;
import pages.base.BasePage;

public class ImportDataPage extends BasePage {

    private final By inputSelectFile = By.name("FileUpload1");

    private final By dataImportStatus = By.xpath("//h3[@id='thestatus']");

    private final By uploadFileBtn = By.id("saveButton");

    public ImportDataPage() {
        super();
    }
    public void uploadFile(String fileName){
        selectFile(fileName);
        clickToUploadFile();
    }

    private void selectFile(String fileName){
        driver.findElement(inputSelectFile).sendKeys(fileName);
    }

    public void clickToUploadFile(){
        driver.findElement(uploadFileBtn).click();
    }

    public String getDataImportStatusTxt(){
        return driver.findElement(dataImportStatus).getText();
    }

    @Override
    public boolean isPageOpened() {
        return false;
    }
}
