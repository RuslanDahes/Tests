package BoardGovernanceTest.boardsTest;

import BoardGovernace.boards.CreateBoard;
import BoardGovernace.loginPage.Login;
import BoardGovernace.profile.BaseProfile;
import BoardGovernace.utils.Links;
import BoardGovernace.utils.Texts;
import BoardGovernace.utils.UserCredentials;
import BoardGovernace.utils.Waiters;
import BoardGovernanceTest.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
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
    public void createBoardWithTariffMiniStart() {
        CreateBoard createBoard = new CreateBoard(getDriver());
        createBoard.openPage(Links.CREATE_BOARD_URL);
        createBoard.createRequiredBoard(Texts.MINI_START_TARIFF);
        Waiters.treadWaiter(10);
    }

    @Test
    public void createBoardWithTariffBasic() {
        CreateBoard createBoard = new CreateBoard(getDriver());
        createBoard.openPage(Links.CREATE_BOARD_URL);
        createBoard.createRequiredBoard(Texts.BASIC_TARIFF);
        Waiters.treadWaiter(10);
    }




    @AfterClass
    public void logout() {
        BaseProfile baseProfile = new BaseProfile(getDriver());
        baseProfile.logout();
    }
}
