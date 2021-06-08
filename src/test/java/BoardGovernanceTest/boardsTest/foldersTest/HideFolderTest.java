package BoardGovernanceTest.boardsTest.foldersTest;

import BoardGovernace.boards.CreateBoard;
import BoardGovernace.boards.folders.CreateFolder;
import BoardGovernace.boards.folders.HideFolder;
import BoardGovernace.loginPage.Login;
import BoardGovernace.utils.UserCredentials;
import BoardGovernace.utils.Waiters;
import BoardGovernanceTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HideFolderTest extends BaseTest {
    @BeforeClass
    public void login() {
        Login login = new Login(getDriver());
        login.loginUser(UserCredentials.EMAIL_MYKHAIL, UserCredentials.PASSWORD_MYKHAIL);
//        createBoard.acceptCookie();
        CreateFolder createFolder = new CreateFolder(getDriver());
        createFolder.openBoard();
    }

    @Test (priority = 1)
    public void hideFolderCheck() {
        HideFolder hideFolder = new HideFolder(getDriver());
        hideFolder.hideFolder();
        hideFolder.displayAndHideFolders();
        Assert.assertTrue(hideFolder.checkHideFolder());
    }

    @Test (priority = 2)
    public void displayFolderCheck() {
        HideFolder hideFolder = new HideFolder(getDriver());
        hideFolder.showFolder();
        Assert.assertTrue(hideFolder.checkDisplayedFolder());
    }

}
