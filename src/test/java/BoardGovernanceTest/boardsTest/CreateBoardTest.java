package BoardGovernanceTest.boardsTest;

import BoardGovernace.boards.CreateBoard;
import BoardGovernace.loginPage.Login;
import BoardGovernace.profile.BaseProfile;
import BoardGovernace.utils.UserCredentials;
import BoardGovernace.utils.Waiters;
import BoardGovernanceTest.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateBoardTest extends BaseTest {
    @BeforeClass
    public void login() {
        Login login = new Login(getDriver());
        login.loginUser(UserCredentials.EMAIL_MYKHAIL, UserCredentials.PASSWORD_MYKHAIL);
    }

    @Test
    public void createBoard() {
        CreateBoard createBoard = new CreateBoard(getDriver());
        createBoard.openPage("/board-login/board-office/opret-bestyrelse");
//        createBoard.createRequiredBoard();
        Waiters.treadWaiter(1);
    }

    @AfterClass
    public void logout() {
        BaseProfile baseProfile = new BaseProfile(getDriver());
        baseProfile.logout();
    }
}
