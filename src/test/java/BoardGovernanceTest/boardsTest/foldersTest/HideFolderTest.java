package BoardGovernanceTest.boardsTest.foldersTest;

import BoardGovernace.boards.CreateBoard;
import BoardGovernace.boards.folders.CreateFolder;
import BoardGovernace.boards.folders.HideFolder;
import BoardGovernace.loginPage.Login;
import BoardGovernace.testrailConfig.APIException;
import BoardGovernace.testrailConfig.TestRails;
import BoardGovernace.testrailConfig.TestSuiteCreating;
import BoardGovernace.utils.UserCredentials;
import BoardGovernace.utils.Waiters;
import BoardGovernanceTest.BaseTest;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class HideFolderTest extends BaseTest {
    @BeforeClass
    public void login() {
        Login login = new Login(getDriver());
        login.loginUser(UserCredentials.EMAIL_MYKHAIL, UserCredentials.PASSWORD_MYKHAIL);
        CreateFolder createFolder = new CreateFolder(getDriver());
        createFolder.openBoard();
    }

    @BeforeMethod
    public void getTestCase(ITestContext ctx, Method method) throws NoSuchMethodException {
        Method m = HideFolderTest.class.getMethod(method.getName());
        if (m.isAnnotationPresent(TestRails.class)) {
            TestRails ta = m.getAnnotation(TestRails.class);
            System.out.println(ta.id());
            ctx.setAttribute("caseId",ta.id());
        }
    }

    @TestRails(id="86807")
    @Test (priority = 1)
    public void hideFolderCheck() {
        HideFolder hideFolder = new HideFolder(getDriver());
        hideFolder.hideFolder();
        hideFolder.displayAndHideFolders();
        Assert.assertTrue(hideFolder.checkHideFolder());
    }

    @TestRails(id="86808")
    @Test (priority = 2)
    public void displayFolderCheck() {
        HideFolder hideFolder = new HideFolder(getDriver());
        hideFolder.showFolder();
//        Assert.assertTrue(hideFolder.checkDisplayedFolder());
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
}
