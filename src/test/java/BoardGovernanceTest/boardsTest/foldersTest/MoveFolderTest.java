package BoardGovernanceTest.boardsTest.foldersTest;

import BoardGovernace.boards.folders.CreateFolder;
import BoardGovernace.boards.folders.DeleteFolder;
import BoardGovernace.boards.folders.MoveFolder;
import BoardGovernace.loginPage.Login;
import BoardGovernace.utils.UserCredentials;
import BoardGovernace.utils.Waiters;
import BoardGovernanceTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MoveFolderTest extends BaseTest {

    @BeforeClass
    public void login() {
        Login login = new Login(getDriver());
        login.loginUser(UserCredentials.EMAIL_MYKHAIL, UserCredentials.PASSWORD_MYKHAIL);
    }

    @BeforeMethod
    public void openPage() {
        DeleteFolder deleteFolder = new DeleteFolder(getDriver());
        deleteFolder.openBoard();
    }

    @Test
    public void moveFolder() {
        DeleteFolder deleteFolder = new DeleteFolder(getDriver());
        MoveFolder moveFolder = new MoveFolder(getDriver());
        deleteFolder.openMenuFolder("FolderForMoveFile");
        moveFolder.moveFolder("Folder to move");
//        Assert.assertTrue(moveFolder.checkFolder());
    }

    @Test
    public void moveFolderToCurrentFolder() {
        DeleteFolder deleteFolder = new DeleteFolder(getDriver());
        MoveFolder moveFolder = new MoveFolder(getDriver());
        deleteFolder.openMenuFolder("FolderToMoveFile");
        moveFolder.moveFolder("FolderToMoveFile");
//        Assert.assertTrue(moveFolder.checkMoveButtonState());
    }
}
