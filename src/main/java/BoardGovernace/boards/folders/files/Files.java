package BoardGovernace.boards.folders.files;

import BoardGovernace.boards.folders.Folder;
import BoardGovernace.loginPage.Login;
import BoardGovernace.utils.Texts;
import BoardGovernace.utils.UserCredentials;
import BoardGovernace.utils.Waiters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Files extends Folder {
    public Files(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "archive-file-list__box")
    List<WebElement> fileList;
    @FindBy(className = "archive-file-list-action")
    List<WebElement> menuFileDots;

    public void openFile(String fileName) {
        for (int i = 0; i < fileList.size(); i++) {
            if (fileList.get(i).getText().contains(fileName)) {
                fileList.get(i).click();
                Waiters.treadWaiter(2);
                break;
            }
        }
    }

    public void openFolder() {
        Login login = new Login(driver);
        UploadFiles uploadFiles = new UploadFiles(driver);
        login.loginUser(UserCredentials.EMAIL_MYKHAIL, UserCredentials.PASSWORD_MYKHAIL);
        uploadFiles.openBoard();
        uploadFiles.openFolder(Texts.TEST_FOLDER_FOR_UPLOAD_FILE);
    }

    public void openMenuFile(String fileName) {
        int menuFolderCount= 0;
        for(int i = 0; i<fileList.size(); i++) {
            if (fileList.get(i).getText().contains(fileName)) {
                menuFolderCount = i;
                break;
            }
        }
        menuFileDots.get(menuFolderCount).click();
        Waiters.treadWaiter(1);
    }
}
