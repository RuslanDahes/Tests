package BoardGovernace.boards.folders.files;

import BoardGovernace.utils.Waiters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UploadFiles extends Files {
    public UploadFiles(WebDriver driver) { super(driver); }
    @FindBy(className = "file-upload-btn")
    WebElement uploadFileButton;
    @FindBy(xpath = "/html/body/label[2]/input")
    WebElement uploadArea;
    @FindBy(xpath = "//*[@id=\"ngdialog1\"]/div[2]/div/div/div[2]/form/div[3]/button[2]")
    WebElement attachFileButton;
    @FindBy(xpath = "//*[@id=\"ngdialog1\"]/div[2]/div/div/div[2]/form/div[5]/a")
    WebElement okButton;
    @FindBy(name = "description")
    WebElement descriptionTextArea;
    @FindBy(className = "gdpr-label")
    WebElement gdprCheckbox;
    @FindBy(className = "mdi-delete")
    WebElement deleteIcon;


    public void uploadFile(String file) {
        openPopupAndUploadFile(file);
        finishUpload();
    }

    public void uploadFileWithDescription(String file, String description) {
        openPopupAndUploadFile(file);
        descriptionTextArea.sendKeys(description);
        finishUpload();
    }

    public void uploadFileWithGDPR(String file) {
        openPopupAndUploadFile(file);
        gdprCheckbox.click();
        finishUpload();
    }

    public boolean checkFileInList(String fileName) {
        boolean present =false;
        driver.navigate().refresh();
        Waiters.treadWaiter(3);
        for (WebElement element : fileList) {
            System.out.println(element.getText());
            if (element.getText().contains(fileName)) {
                present = true;
                break;
            }
        }
        return present;
    }



    public void openPopupAndUploadFile(String file) {
        String filePath = System.getProperty("user.dir") + file;
        uploadFileButton.click();
        Waiters.treadWaiter(2);
        uploadArea.sendKeys(filePath);
        Waiters.treadWaiter(3);
    }

    public void finishUpload() {
        attachFileButton.click();
        Waiters.treadWaiter(3);
        okButton.click();
        Waiters.treadWaiter(5);
    }
}
