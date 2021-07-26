package BoardGovernace.boards.folders;

import BoardGovernace.utils.Waiters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteFolder extends Folder {
    public DeleteFolder(WebDriver driver) { super(driver); }
    @FindBy(linkText = "Delete folder")
    WebElement deleteFolderButton;
    @FindBy(linkText = "Delete")
    WebElement confirmationDeleteButton;


    public void deleteFolder() {
        deleteFolderButton.click();
        Waiters.treadWaiter(1);
        confirmationDeleteButton.click();
        Waiters.treadWaiter(2);
    }

    public boolean checkDeletedFolder() {
        int menuFolderCount= 0;
        for(int i = 0; i<folderList.size(); i++) {
            if (folderList.get(i).getText().contains("FolderForDelete")) {
                menuFolderCount = i;
                break;
            }
        }
        return menuFolderCount <= 0;
    }
}
