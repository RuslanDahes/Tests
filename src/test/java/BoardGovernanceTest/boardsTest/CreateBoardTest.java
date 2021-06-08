package BoardGovernanceTest.boardsTest;

import BoardGovernace.boards.CreateBoard;
import BoardGovernace.loginPage.Login;
import BoardGovernace.profile.BaseProfile;
import BoardGovernace.testrailConfig.APIException;
import BoardGovernace.testrailConfig.TestRails;
import BoardGovernace.testrailConfig.TestSuiteCreating;
import BoardGovernace.utils.Links;
import BoardGovernace.utils.Texts;
import BoardGovernace.utils.UserCredentials;
import BoardGovernanceTest.BaseTest;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class CreateBoardTest extends BaseTest {
    @BeforeClass
    public void login() {
        Login login = new Login(getDriver());
        CreateBoard createBoard = new CreateBoard(getDriver());
        login.loginUser(UserCredentials.EMAIL_MYKHAIL, UserCredentials.PASSWORD_MYKHAIL);
        createBoard.acceptCookie();
    }

    @BeforeMethod
    public void getTestCase(ITestContext ctx, Method method) throws NoSuchMethodException {
        Method m = CreateBoardTest.class.getMethod(method.getName());
        if (m.isAnnotationPresent(TestRails.class)) {
            TestRails ta = m.getAnnotation(TestRails.class);
            System.out.println(ta.id());
            ctx.setAttribute("caseId",ta.id());
        }
    }

    @BeforeMethod
    public void openPage() {
        CreateBoard createBoard = new CreateBoard(getDriver());
        createBoard.openPage(Links.CREATE_BOARD_URL);
    }

    @TestRails(id="86540")
    @Test
    public void createBoardWithTariffMiniStart() {
        CreateBoard createBoard = new CreateBoard(getDriver());
        createBoard.createRequiredBoard(Texts.MINI_START_TARIFF);
    }

    @TestRails(id="86541")
    @Test
    public void createBoardWithTariffBasic() {
        CreateBoard createBoard = new CreateBoard(getDriver());
        createBoard.createRequiredBoard(Texts.BASIC_TARIFF);
    }

    @TestRails(id="86542")
    @Test
    public void createBoardWithTariffElite() {
        CreateBoard createBoard = new CreateBoard(getDriver());
        createBoard.createRequiredBoard(Texts.ELITE_TARIFF);
    }

    @TestRails(id="86543")
    @Test
    public void createBoardWithTariffCorporate() {
        CreateBoard createBoard = new CreateBoard(getDriver());
        createBoard.createRequiredBoard(Texts.CORPORATE_TARIFF);
    }

    @TestRails(id="86544")
    @Test
    public void checkError() {
        CreateBoard createBoard = new CreateBoard(getDriver());
        createBoard.checkError();
    }

    @TestRails(id="86545")
    @Test
    public void checkTariffAboveUsers() {
        CreateBoard createBoard = new CreateBoard(getDriver());
        createBoard.aboveCheck();
    }

    @AfterMethod
    public void setTestCase(ITestResult result, ITestContext ctx) throws IOException, APIException {
        Map data = new HashMap();
        if(result.isSuccess()) {
            data.put("status_id",1);
        }
        else {
            data.put("status_id", 5);
            data.put("comment", result.getThrowable().toString());
        }
        String caseId = (String)ctx.getAttribute("caseId");
        TestSuiteCreating.CLIENT.sendPost("add_result_for_case/"+TestSuiteCreating.TEST_RUN+"/"+caseId,data);
    }

    @AfterClass
    public void logout() {
        BaseProfile baseProfile = new BaseProfile(getDriver());
        baseProfile.openPage("");
        baseProfile.logout();
    }
}
