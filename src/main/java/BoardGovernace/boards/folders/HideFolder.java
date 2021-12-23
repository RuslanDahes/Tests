package BoardGovernace.boards.folders;

import BoardGovernace.utils.Waiters;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HideFolder extends Folder {
    public HideFolder(WebDriver driver) { super(driver); }
    @FindBy(className = "archive-toggler")
    List<WebElement> checkBoxList;
    @FindBy(className = "hidden-folders-header")
    WebElement hideFoldersBlock;



     String folderName;
    static String lastFolder;

    public void checkNameFirstFolder() {
        action.waitForVisible(folderList);
        folderName = folderList.get(0).getText();
        System.out.println(folderName);
    }

    public void checkNameLastFolder() {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0];", folderList.get(folderList.size()-1));
        lastFolder = folderList.get(folderList.size()-1).getText();
        System.out.println(lastFolder);
    }

    public void hideFolder() {
        action.waitForPageLoaded();
        checkNameFirstFolder();
        scrollAndClickToElementJS(dotsVerticalList.get(0));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", hideFolderButton);
        Waiters.treadWaiter(1);
    }

    public void displayAndHideFolders() {
        action.waitForPageLoaded();
        action.click(checkBoxList.get(2));
        Waiters.treadWaiter(2);
//        JavascriptExecutor executor = (JavascriptExecutor)driver;
//        executor.executeScript("arguments[0];", hideFoldersBlock);
    }

    public boolean checkHideFolder() {
        boolean folderPresent = false;
        for (int i =0; i<folderList.size(); i++){
            if (folderName.contains(folderList.get(i).getText())) {
                folderPresent = true;
            }
        }
        return folderPresent;
    }

    public boolean checkDisplayedFolder() {
        boolean folderPresent = false;
        for (int i =0; i<folderList.size(); i++){
            if (lastFolder.contains(folderList.get(i).getText())) {
                folderPresent = true;
            }
        }
        return folderPresent;
    }

    public void showFolder() {
        checkNameLastFolder();
        openMenuFolder(lastFolder);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", showFolderButton);
        refreshPage();
    }

    public void refreshPage() {
        driver.navigate().refresh();
        Waiters.treadWaiter(3);
    }
}
