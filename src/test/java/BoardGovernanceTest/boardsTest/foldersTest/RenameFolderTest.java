package BoardGovernanceTest.boardsTest.foldersTest;

import BoardGovernace.boards.CreateBoard;
import BoardGovernace.boards.folders.CreateFolder;
import BoardGovernace.boards.folders.RenameFolder;
import BoardGovernace.loginPage.Login;
import BoardGovernace.utils.Texts;
import BoardGovernace.utils.UserCredentials;
import BoardGovernace.utils.Waiters;
import BoardGovernanceTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RenameFolderTest extends BaseTest {
    @BeforeClass
    public void login() {
        Login login = new Login(getDriver());
        CreateBoard createBoard = new CreateBoard(getDriver());
        login.loginUser(UserCredentials.EMAIL_MYKHAIL, UserCredentials.PASSWORD_MYKHAIL);
//        createBoard.acceptCookie();
    }

    @BeforeMethod
    public void openPage() {
        CreateFolder createFolder = new CreateFolder(getDriver());
        createFolder.openBoard();
        createFolder.createFolder(Texts.TEST_FOLDER);
    }

    @Test
    public void succsesRenameFolder() {
        RenameFolder renameFolder = new RenameFolder(getDriver());
        renameFolder.openMenuFolder(Texts.TEST_FOLDER);
        renameFolder.editFolderName();
        Assert.assertTrue(renameFolder.checkFolderInList(Texts.TEST_EDIT_FOLDER));
    }

    @Test
    public void cancelRenameFolder() {
        RenameFolder renameFolder = new RenameFolder(getDriver());
        renameFolder.openMenuFolder(Texts.TEST_FOLDER);
        renameFolder.editFolderNameWithCancel();
        Assert.assertFalse(renameFolder.checkFolderInList(Texts.TEST_EDIT_FOLDER_CANCEL));
    }
}
