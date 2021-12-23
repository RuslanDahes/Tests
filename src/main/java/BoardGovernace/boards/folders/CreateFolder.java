package BoardGovernace.boards.folders;

import BoardGovernace.boards.Board;
import BoardGovernace.utils.Links;
import BoardGovernace.utils.Waiters;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class CreateFolder extends Folder {
    public CreateFolder(WebDriver driver) { super(driver); }


    public void createFolder(String folderName) {
        action.waitElementToBeClickable(createFolderButton);
        action.click(createFolderButton);
        System.out.println(folderNameField.size());
        action.waitForVisible(folderNameField);
        action.sendKeys(folderNameField.get(1), folderName);
//        folderNameField.get(1).sendKeys(folderName);
//        folderNameField.get(3).sendKeys(folderName);
//        Waiters.treadWaiter(2);
        action.click(saveFolderButton);
        action.waitForPageLoaded();
//        saveFolderButton.click();
//        Waiters.treadWaiter(2);
    }





    public void showError() {
        Assert.assertTrue(errorText.isDisplayed());
    }


}
