package BoardGovernace.boards.folders.files;

import BoardGovernace.utils.Waiters;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UploadFiles extends Files {
    public UploadFiles(WebDriver driver) { super(driver); }
    @FindBy(xpath = "/html/body/div[3]/section/div/div/board/ng-transclude/archive/div/archive-tree/div/div[1]/div/div/div/label/span")
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
    @FindBy(className = "archive-file-list__box")
    List<WebElement> listOfFile;

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
        for (WebElement element : listOfFile) {
            System.out.println(element.getText());
            if (element.getText().contains(fileName)) {
                present = true;
                break;
            }
        }
        System.out.println("test");
        return present;
    }



    public void openPopupAndUploadFile(String file) {
        uploadFileButton.click();
        Waiters.treadWaiter(2);
        uploadArea.sendKeys(file);
        Waiters.treadWaiter(3);
    }

    public void finishUpload() {
        Waiters.treadWaiter(1);
        attachFileButton.click();
        Waiters.treadWaiter(3);
        okButton.click();
        Waiters.treadWaiter(1);
    }
}
