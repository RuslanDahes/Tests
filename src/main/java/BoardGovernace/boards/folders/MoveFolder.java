package BoardGovernace.boards.folders;

import BoardGovernace.utils.Waiters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MoveFolder extends Folder {
    public MoveFolder(WebDriver driver) { super(driver); }
    @FindBy(linkText = "Move folder")
    WebElement moveFolderOnPanelButton;
    @FindBy(className = "small-item")
    List<WebElement> folderToMoveList;
    @FindBy(className = "btn--sm")
    List<WebElement> moveFolderOnPopupButton;
    @FindBy(id = "ngdialog1-aria-labelledby")
    WebElement popupShown;

    public void moveFolder(String folderToMove) {
        moveFolderOnPanelButton.click();
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
//        openFolder("Folder to move");
        driver.get("https://www.staging.board-office.dk/board-login/board-office/board/a33eccee-2573-4190-9bcd-c9018a174109/archive/?archiveGuid=32061195-bc09-4934-83c9-e8c11f3fdac8");
        Waiters.implicitWait(driver, Waiters.TIME_TEN, TimeUnit.SECONDS);
        Waiters.treadWaiter(10);
        return checkFolderInList("FolderForMove");
    }

    public boolean checkMoveButtonState() {
        Waiters.treadWaiter(10);
        return popupShown.isDisplayed();
    }
}
