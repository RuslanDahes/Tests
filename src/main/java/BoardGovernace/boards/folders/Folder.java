package BoardGovernace.boards.folders;

import BoardGovernace.boards.Board;
import BoardGovernace.utils.Waiters;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;

public class Folder extends Board {
    public Folder(WebDriver driver) { super(driver); }
    @FindBy(xpath = "/html/body/div[3]/section/div/div/board/ng-transclude/archive/div/archive-tree/div/div[1]/div/div/div/button")
    WebElement createFolderButton;
    @FindBy(name = "folderName")
    List<WebElement> folderNameField;
    @FindBy(xpath = "//*[@id=\"ngdialog1\"]/div[2]/form/div/button[2]")
    WebElement saveFolderButton;
    public  @FindBy (xpath = "//*[@ng-if='error.messageKey']")
    WebElement errorText;
//    @FindBy(linkText = "Please enter a name")
//    WebElement errorText;
    @FindBy(className = "archive-file-list__box")
    List<WebElement> folderList;
    @FindBy(className = "mdi-dots-vertical")
    List<WebElement> dotsVerticalList;
    @FindBy(className = "modal-close")
    WebElement closePopupButton;
    @FindBy(className = "icon--color-bg-light-gray")
    List<WebElement> folderIcon;
    @FindBy(name = "query")
    WebElement searchField;
    @FindBy(className = "archive-file-list__box")
    List<WebElement> folderAreaList;
    @FindBy(xpath = "//*[@id=\"ngdialog1\"]/div[2]/div/button[2]")
    WebElement savePermissionButton;

    public boolean checkFolderInList(String folderName) {
        boolean inList = false;
        for(int i = 0; i<folderList.size(); i++) {
            if (folderList.get(i).getText().contains(folderName)) {
                inList = true;
            }
        }
        return inList;
    }

    public void openMenuFolder(String folderName) {
        int menuFolderCount= 0;
        for(int i = 0; i<folderList.size(); i++) {
            if (folderList.get(i).getText().contains(folderName)) {
                menuFolderCount = i;
                break;
            }
        }
        dotsVerticalList.get(menuFolderCount).click();
        Waiters.treadWaiter(1);
    }

    public void openFolder(String folderName) {
        for(int i = 0; i<folderList.size(); i++) {
            if (folderList.get(i).getText().contains(folderName)) {
                folderAreaList.get(i).click();
                Waiters.treadWaiter(2);
                break;
            }
        }
    }

    public void searchFolder(String folderName) {
        searchField.sendKeys(folderName);
        Waiters.treadWaiter(1);
        searchField.sendKeys(Keys.ENTER);
        Waiters.treadWaiter(3);
    }
}
