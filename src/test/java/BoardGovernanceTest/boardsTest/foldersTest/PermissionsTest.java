package BoardGovernanceTest.boardsTest.foldersTest;

import BoardGovernace.boards.folders.Permissions;
import BoardGovernace.boards.folders.SearchFolder;
import BoardGovernace.loginPage.Login;
import BoardGovernace.profile.BaseProfile;
import BoardGovernace.utils.UserCredentials;
import BoardGovernace.utils.Waiters;
import BoardGovernanceTest.BaseTest;
import BoardGovernanceTest.profileTest.logoutTest.LogoutTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PermissionsTest extends BaseTest {
    @BeforeMethod
    public void login() {
        Login login = new Login(getDriver());
        Permissions permissions = new Permissions(getDriver());
        login.loginUser(UserCredentials.EMAIL_MYKHAIL, UserCredentials.PASSWORD_MYKHAIL);
//        createBoard.acceptCookie();
        permissions.openBoard();
    }

    @Test (priority = 1)
    public void removeUserPermission() {
        Permissions permissions = new Permissions(getDriver());
        permissions.removePermission("Test Test User");
        Assert.assertFalse(permissions.checkPermission("Folder for Permission"));
    }

    @Test (priority = 2)
    public void addUserPermission() {
        Permissions permissions = new Permissions(getDriver());
        permissions.removePermission("Test Test User");
        Assert.assertTrue(permissions.checkPermission("Folder for Permission"));
    }

    @AfterMethod
    public void logoutUser() {
        BaseProfile baseProfile = new BaseProfile(getDriver());
        baseProfile.logout();
    }
}
