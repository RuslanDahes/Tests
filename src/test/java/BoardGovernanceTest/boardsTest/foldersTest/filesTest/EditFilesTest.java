package BoardGovernanceTest.boardsTest.foldersTest.filesTest;

import BoardGovernace.boards.folders.files.EditFiles;
import BoardGovernace.boards.folders.files.UploadFiles;
import BoardGovernace.loginPage.Login;
import BoardGovernace.testrailConfig.APIException;
import BoardGovernace.testrailConfig.TestRails;
import BoardGovernace.testrailConfig.TestSuiteCreating;
import BoardGovernace.utils.AttachPath;
import BoardGovernace.utils.Texts;
import BoardGovernace.utils.UserCredentials;
import BoardGovernace.utils.Waiters;
import BoardGovernanceTest.BaseTest;
import org.openqa.selenium.support.FindBy;
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

public class EditFilesTest extends BaseTest  {
    @BeforeClass
    public void login() {
        EditFiles editFiles = new EditFiles(getDriver());
        editFiles.openFolder();
//        editFiles.uploadFile(AttachPath.TEST_UPLOAD_DOC);
    }

    @BeforeMethod
    public void getTestCase(ITestContext ctx, Method method) throws NoSuchMethodException {
        Method m = EditFilesTest.class.getMethod(method.getName());
        if (m.isAnnotationPresent(TestRails.class)) {
            TestRails ta = m.getAnnotation(TestRails.class);
            System.out.println(ta.id());
            ctx.setAttribute("caseId",ta.id());
        }
    }

    @TestRails(id="87590")
    @Test
    public void editFileWithDescription() {
        EditFiles editFiles = new EditFiles(getDriver());
        editFiles.editFile("TestDOC", "Edited File Name", "Test description");
//        Assert.assertTrue(editFiles.checkFileInList("Edited File Name"));
    }

    @TestRails(id="87591")
    @Test
    public void editFileWithOutDescription() {
        EditFiles editFiles = new EditFiles(getDriver());
        editFiles.editFile("TestDOCX", "Edited File Name");
//        Assert.assertTrue(editFiles.checkFileInList("Edited File Name"));
    }

    @AfterMethod
    public void refreshBoard() {
        EditFiles editFiles = new EditFiles(getDriver());
        editFiles.backToFolder();
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
