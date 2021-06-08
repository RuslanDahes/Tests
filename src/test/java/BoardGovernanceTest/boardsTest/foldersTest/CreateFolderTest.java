package BoardGovernanceTest.boardsTest.foldersTest;

import BoardGovernace.boards.CreateBoard;
import BoardGovernace.boards.folders.CreateFolder;
import BoardGovernace.loginPage.Login;
import BoardGovernace.testrailConfig.APIException;
import BoardGovernace.testrailConfig.TestRails;
import BoardGovernace.testrailConfig.TestSuiteCreating;
import BoardGovernace.utils.Texts;
import BoardGovernace.utils.UserCredentials;
import BoardGovernanceTest.BaseTest;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class CreateFolderTest extends BaseTest {
    @BeforeClass
    public void login() {
        Login login = new Login(getDriver());
        CreateBoard createBoard = new CreateBoard(getDriver());
        login.loginUser(UserCredentials.EMAIL_MYKHAIL, UserCredentials.PASSWORD_MYKHAIL);
//        createBoard.acceptCookie();
    }

    @BeforeMethod
    public void getTestCase(ITestContext ctx, Method method) throws NoSuchMethodException {
        Method m = CreateFolderTest.class.getMethod(method.getName());
        if (m.isAnnotationPresent(TestRails.class)) {
            TestRails ta = m.getAnnotation(TestRails.class);
            System.out.println(ta.id());
            ctx.setAttribute("caseId",ta.id());
        }
    }

    @BeforeMethod
    public void openPage() {
        CreateFolder createFolder = new CreateFolder(getDriver());
        createFolder.openBoard();
    }

    @TestRails(id="86582")
    @Test
    public void createFolderSuccses() {
        CreateFolder createFolder = new CreateFolder(getDriver());
        createFolder.createFolder(Texts.TEST_FOLDER);
        Assert.assertTrue(createFolder.checkFolderInList(Texts.TEST_FOLDER));
    }

    @TestRails(id="86583")
    @Test
    public void checkErrorState() {
        CreateFolder createFolder = new CreateFolder(getDriver());
        createFolder.createFolder("");
        createFolder.showError();
    }

    @TestRails(id="86584")
    @Test
    public void createMoreOneFolderWithSameName() {
        CreateFolder createFolder = new CreateFolder(getDriver());
        createFolder.createFolder(Texts.TEST_FOLDER);
        createFolder.createFolder(Texts.TEST_FOLDER);
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

//    @AfterClass
//    public void logout() {
//        BaseProfile baseProfile = new BaseProfile(getDriver());
//        baseProfile.openPage("");
//        baseProfile.logout();
//    }
}
