package BoardGovernace.boards.folders;

import BoardGovernace.utils.Texts;
import BoardGovernace.utils.Waiters;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RenameFolder extends Folder {
    public RenameFolder(WebDriver driver) { super(driver); }
//    @FindBy(className = "//*[@id=\"folder-id-60282\"]/div[3]/div/ul/li[5]/a")
//    WebElement editNameButton;
    @FindBy(xpath = "/html/body/div[3]/section/div/div/board/ng-transclude/archive/div/archive-folder-create/modal/div/div[2]/div/ng-transclude/form/div/button[2]")
    WebElement saveNameButton;


    public void editFolderName() {
        clickOnElementJSTreadWait(editNameButton, 2);
//        editNameButton.click();
        Waiters.treadWaiter(1);
        folderNameField.get(1).sendKeys(Keys.COMMAND + "a");
        folderNameField.get(1).sendKeys(Keys.DELETE);
        Waiters.treadWaiter(1);
        folderNameField.get(1).sendKeys(Texts.TEST_EDIT_FOLDER);
        Waiters.treadWaiter(1);
        folderNameField.get(1).sendKeys(Keys.ENTER);
        Waiters.treadWaiter(2);
    }

    public void editFolderNameWithCancel() {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", editNameButton);
        Waiters.treadWaiter(1);
//        editNameButton.click();
//        Waiters.treadWaiter(1);
        folderNameField.get(1).sendKeys(Keys.COMMAND + "a");
        folderNameField.get(1).sendKeys(Keys.DELETE);
        Waiters.treadWaiter(1);
        folderNameField.get(1).sendKeys(Texts.TEST_EDIT_FOLDER_CANCEL);
        Waiters.treadWaiter(1);
        driver.navigate().refresh();
        Waiters.treadWaiter(3);
    }


}
