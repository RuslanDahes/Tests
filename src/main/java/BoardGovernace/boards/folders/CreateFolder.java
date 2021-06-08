package BoardGovernace.boards.folders;

import BoardGovernace.boards.Board;
import BoardGovernace.utils.Links;
import BoardGovernace.utils.Waiters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CreateFolder extends Folder {
    public CreateFolder(WebDriver driver) { super(driver); }


    public void createFolder(String folderName) {
        createFolderButton.click();
        Waiters.treadWaiter(1);
        System.out.println(folderNameField.size());
        folderNameField.get(3).sendKeys(folderName);
        Waiters.treadWaiter(1);
        saveFolderButton.click();
        Waiters.treadWaiter(2);
    }





    public void showError() {
        Assert.assertTrue(errorText.isDisplayed());
    }


}
