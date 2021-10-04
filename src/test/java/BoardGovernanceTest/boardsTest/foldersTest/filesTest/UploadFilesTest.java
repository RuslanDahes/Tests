package BoardGovernanceTest.boardsTest.foldersTest.filesTest;

import BoardGovernace.boards.folders.Permissions;
import BoardGovernace.boards.folders.files.Files;
import BoardGovernace.boards.folders.files.UploadFiles;
import BoardGovernace.loginPage.Login;
import BoardGovernace.profile.BaseProfile;
import BoardGovernace.utils.UserCredentials;
import BoardGovernanceTest.BaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UploadFilesTest extends BaseTest {
    @BeforeMethod
    public void login() {
        Login login = new Login(getDriver());
        Files files = new Files(getDriver());
        login.loginUser(UserCredentials.EMAIL_MYKHAIL, UserCredentials.PASSWORD_MYKHAIL);
//        createBoard.acceptCookie();
        files.openBoard();
    }

    @BeforeMethod
    public void openFolder() {
        UploadFiles uploadFiles = new UploadFiles(getDriver());
        uploadFiles.openFolder("Folder for file");
    }

    @Test
    public void baseUploadFile() {
        
    }

    @AfterMethod
    public void logoutUser() {
        BaseProfile baseProfile = new BaseProfile(getDriver());
        baseProfile.logout();
    }
}
