package BoardGovernace.boards.folders;

import BoardGovernace.utils.Links;
import BoardGovernace.utils.Waiters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MoveFolder extends Folder {
    public MoveFolder(WebDriver driver) { super(driver); }
    @FindBy(className = "small-item")
    List<WebElement> folderToMoveList;
    @FindBy(className = "btn--sm")
    List<WebElement> moveFolderOnPopupButton;
    @FindBy(id = "ngdialog1-aria-labelledby")
    WebElement popupShown;

    public void moveFolder(String folderToMove) {
        clickOnElementJSTreadWait(moveFolderOnPanelButton, 2);
        Waiters.treadWaiter(2);
        for (int i=0; i<folderToMoveList.size(); i++) {
            if (folderToMoveList.get(i).getText().contains(folderToMove)) {
                folderToMoveList.get(i).click();
                Waiters.treadWaiter(2);
                break;
            }
        }
        moveFolderOnPopupButton.size();
        moveFolderOnPopupButton.get(2).click();
        Waiters.treadWaiter(2);
    }



    public boolean checkFolder() {
        openPage(Links.STAGE_TEST_BOARD_URL);
        openFolder("FolderToMoveFile");
        return checkFolderInList("FolderForMoveFile");
    }

    public boolean checkMoveButtonState() {
        Waiters.treadWaiter(10);
        return popupShown.isDisplayed();
    }
}
