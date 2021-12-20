package BoardGovernace.boards.folders.files;

import BoardGovernace.utils.Waiters;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EditFiles extends UploadFiles {
    public EditFiles(WebDriver driver) { super(driver); }
    @FindBy(className = "btn--gray")
    WebElement editButton;
    @FindBy(xpath = "//*[@id=\"ngdialog1\"]/div[2]/form/label[1]/input")
    WebElement fileNameField;
    @FindBy(name = "description")
    WebElement descriptionField;
    @FindBy(xpath = "//*[@id=\"ngdialog1\"]/div[2]/form/div[3]/button[2]")
    WebElement saveChangesButton;
    @FindBy(xpath = "/html/body/div/section/div/div/board/ng-transclude/archive/div/archive-file-overview/div/div[2]/div/div/div[2]/div/div/div/div[2]/h3")
    WebElement fileTitle;
    @FindBy(xpath = "/html/body/div/section/div/div/board/ng-transclude/archive/div/archive-file-overview/div/div[2]/div/div/div[2]/div/div/div/div[2]/div/p[1]")
    WebElement descriptionText;
    @FindBy(className = "archive-breadcrumb-item")
    List<WebElement> breadcrumbList;

    public void editFile(String nameFileForEdit, String newName, String descriptionText) {
        openFile(nameFileForEdit);
        action.waitForPageLoaded();
        scrollAndClickToElementJS(editButton);
        action.waitForPageLoaded();
        action.clearAndSendKeys(fileNameField, newName);
        action.clearAndSendKeys(descriptionField, descriptionText);
        action.click(saveChangesButton);
        action.waitForPageLoaded();
    }

    public void editFile(String nameFileForEdit, String newName) {
        openFile(nameFileForEdit);
        action.waitForPageLoaded();
        scrollAndClickToElementJS(editButton);
        action.waitForPageLoaded();
        action.clearAndSendKeys(fileNameField, newName);
        action.click(saveChangesButton);
        action.waitForPageLoaded();
    }

    public String getFileTitle() {
        action.waitForPageLoaded();
        action.waitForVisible(fileTitle);
        return fileTitle.getText();
    }

    public String getDescriptionText() {
        return descriptionText.getText();
    }

    public void backToFolder() {
        action.waitForPageLoaded();
        action.click(breadcrumbList.get(breadcrumbList.size()-1));
        action.waitForPageLoaded();
    }
}
