package BoardGovernanceTest.boardsTest.foldersTest;

import BoardGovernace.boards.folders.AppearanceFolder;
import BoardGovernace.boards.folders.CreateFolder;
import BoardGovernace.boards.folders.ViewLogs;
import BoardGovernace.loginPage.Login;
import BoardGovernace.utils.UserCredentials;
import BoardGovernace.utils.Waiters;
import BoardGovernanceTest.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ViewLogsTest extends BaseTest {

    @BeforeClass
    public void login() {
        Login login = new Login(getDriver());
        login.loginUser(UserCredentials.EMAIL_MYKHAIL, UserCredentials.PASSWORD_MYKHAIL);
    }

    @BeforeMethod
    public void openPage() {
        ViewLogs viewLogs = new ViewLogs(getDriver());
        viewLogs.openBoard();
        viewLogs.searchFolder("FolderForLogsChecking");
        viewLogs.openFolder("FolderForLogsChecking");
    }

    @Test
    public void createFolderLogs() {
        CreateFolder createFolder = new CreateFolder(getDriver());
        ViewLogs viewLogs = new ViewLogs(getDriver());
        createFolder.createFolder("CreateFolderLogs");
        viewLogs.checkCreateLogs();
    }
}
