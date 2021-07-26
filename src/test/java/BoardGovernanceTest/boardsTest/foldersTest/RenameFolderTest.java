package BoardGovernanceTest.boardsTest.foldersTest;

import BoardGovernace.boards.CreateBoard;
import BoardGovernace.boards.folders.CreateFolder;
import BoardGovernace.boards.folders.RenameFolder;
import BoardGovernace.loginPage.Login;
import BoardGovernace.testrailConfig.APIException;
import BoardGovernace.testrailConfig.TestRails;
import BoardGovernace.testrailConfig.TestSuiteCreating;
import BoardGovernace.utils.Texts;
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

public class RenameFolderTest extends BaseTest {
    @BeforeClass
    public void login() {
        Login login = new Login(getDriver());
        CreateBoard createBoard = new CreateBoard(getDriver());
        login.loginUser(UserCredentials.EMAIL_MYKHAIL, UserCredentials.PASSWORD_MYKHAIL);
//        createBoard.acceptCookie();
    }

    @BeforeMethod
    public void getTestCase(ITestContext ctx, Method method) throws NoSuchMethodException {
        Method m = RenameFolderTest.class.getMethod(method.getName());
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
        createFolder.createFolder(Texts.TEST_FOLDER);
    }

    @TestRails(id="86805")
    @Test
    public void succsesRenameFolder() {
        RenameFolder renameFolder = new RenameFolder(getDriver());
        renameFolder.openMenuFolder(Texts.TEST_FOLDER);
        renameFolder.editFolderName();
        Assert.assertTrue(renameFolder.checkFolderInList(Texts.TEST_EDIT_FOLDER));
    }

    @TestRails(id="86806")
    @Test
    public void cancelRenameFolder() {
        RenameFolder renameFolder = new RenameFolder(getDriver());
        renameFolder.openMenuFolder(Texts.TEST_FOLDER);
        renameFolder.editFolderNameWithCancel();
        Assert.assertFalse(renameFolder.checkFolderInList(Texts.TEST_EDIT_FOLDER_CANCEL));
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
