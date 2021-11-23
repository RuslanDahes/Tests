package BoardGovernace.boards.folders.files;

import BoardGovernace.utils.AttachPath;
import BoardGovernace.utils.Waiters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MoveFiles extends Files {
    public MoveFiles(WebDriver driver) {
        super(driver);
    }

    @FindBy(partialLinkText = "Move")
    WebElement moveFileOnPanelButton;
    @FindBy(xpath = "//*[@id=\"ngdialog1\"]/div[2]/div[2]/ul/li[1]/a")
    WebElement headFolderBreadCrumb;
    @FindBy(xpath = "//*[@id=\"ngdialog3\"]/div[2]/div[1]/div/div/div/button[2]")
    WebElement moveFileToCategoryButton;

    String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void moveFile() {
        setFileName(fileList.get(0).getText());
        openMenuFile(getFileName());
        moveFileOnPanelButton.click();
        Waiters.treadWaiter(2);
        headFolderBreadCrumb.click();
        Waiters.treadWaiter(2);
        moveFileToCategoryButton.click();
        Waiters.treadWaiter(2);
    }


}
