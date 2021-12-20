package BoardGovernace.boards.folders.files;

import BoardGovernace.boards.folders.AppearanceFolder;
import BoardGovernace.utils.AttachPath;
import BoardGovernace.utils.Waiters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MoveFiles extends Files {
    public MoveFiles(WebDriver driver) {
        super(driver);
    }

    @FindBy(partialLinkText = "Move")
    WebElement moveFileOnPanelButton;
    @FindBy(xpath = "//*[@id=\"ngdialog1\"]/div[2]/div[2]/ul/li[1]/a")
    WebElement headFolderBreadCrumb;
    @FindBy(xpath = "//*[@id=\"ngdialog1\"]/div[2]/div[1]/div/div/div/button[2]")
    WebElement moveFileToCategoryButton;
    @FindBy(xpath = "//*[@class='archive-file-list__item small-item ng-scope']")
    List<WebElement> foldersForMove;

    String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void moveFile() {
        action.waitForVisible(fileList);
        setFileName(fileList.get(0).getText());
        openMenuFile(getFileName());
        action.click(moveFileOnPanelButton);
        action.click(headFolderBreadCrumb);
        selectFolderToMove("FolderToMoveFileTest");
        actionJs.click(moveFileToCategoryButton);
    }

    public void selectFolderToMove(String folderName) {
        action.waitForVisible(foldersForMove);
        for (int i=0; i<foldersForMove.size(); i++) {
            if (foldersForMove.get(i).getText().contains(folderName)) {
                action.moveTo(foldersForMove.get(i));
                actionJs.click(foldersForMove.get(i));
            }
        }
    }
}
