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
    @FindBy(xpath = "//*[@data-cy='folderCreateBtn']")
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

    @FindBy(xpath = "//*[@data-cy='folderDeleteBtn']")
    WebElement deleteFolderButton;
    @FindBy(xpath = "//*[@data-cy='folderHideBtn']")
    WebElement hideFolderButton;
    @FindBy(xpath = "//*[@data-cy='hiddenFolderVisibilityBtn']")
    WebElement showFolderButton;
    @FindBy(xpath = "//*[@data-cy='folderAppearanceBtn']")
    WebElement appearanceButton;
    @FindBy(xpath = "//*[@data-cy='folderPermissionsBtn']")
    WebElement folderPermissionMenuButton;
    @FindBy(xpath = "//*[@data-cy='folderMoveBtn']")
    WebElement moveFolderOnPanelButton;
    @FindBy(xpath = "//*[@data-cy='folderRenameBtn']")
    WebElement editNameButton;
    @FindBy(xpath = "//*[@data-cy='folderViewLogBtn']")
    WebElement viewLogButton;
    @FindBy(xpath = "//*[@data-cy='folderCancelBtn']")
    WebElement cancelButton;





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
        Waiters.treadWaiter(2);
        scrollAndClickToElementJS(dotsVerticalList.get(menuFolderCount));
        Waiters.treadWaiter(1);
    }

    public void openFolder(String folderName) {
        action.waitForPageLoaded();
        Waiters.treadWaiter(2);
//        actionJs.waitForVisible(folderAreaList);
        for(int i = 0; i<folderList.size(); i++) {
            if (folderList.get(i).getText().contains(folderName)) {
                action.moveTo(folderAreaList.get(i));
                action.click(folderAreaList.get(i));
                action.waitForPageLoaded();
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
