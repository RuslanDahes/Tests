package BoardGovernanceTest.boardsTest.foldersTest.filesTest;

import BoardGovernace.boards.folders.files.Files;
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
import BoardGovernanceTest.boardsTest.foldersTest.AppearanceFolderTest;
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

public class UploadFilesTest extends BaseTest {
    @BeforeClass
    public void login() {
        UploadFiles uploadFiles = new UploadFiles(getDriver());
        uploadFiles.openFolder();
    }

    @BeforeMethod
    public void getTestCase(ITestContext ctx, Method method) throws NoSuchMethodException {
        Method m = UploadFilesTest.class.getMethod(method.getName());
        if (m.isAnnotationPresent(TestRails.class)) {
            TestRails ta = m.getAnnotation(TestRails.class);
            System.out.println(ta.id());
            ctx.setAttribute("caseId",ta.id());
        }
    }

    @TestRails(id="87411")
    @Test
    public void uploadFileDoc() {
        UploadFiles uploadFiles = new UploadFiles(getDriver());
        uploadFiles.uploadFile(AttachPath.TEST_UPLOAD_DOC);
        Assert.assertTrue(uploadFiles.checkFileInList("TestDOC"));
    }

    @TestRails(id="87412")
    @Test
    public void uploadFileDocX() {
        UploadFiles uploadFiles = new UploadFiles(getDriver());
        uploadFiles.uploadFile(AttachPath.TEST_UPLOAD_DOCX);
        Assert.assertTrue(uploadFiles.checkFileInList("TestDOCX"));
    }

    @TestRails(id="87413")
    @Test
    public void uploadFilePDF() {
        UploadFiles uploadFiles = new UploadFiles(getDriver());
        uploadFiles.uploadFile(AttachPath.TEST_UPLOAD_PDF);
        Assert.assertTrue(uploadFiles.checkFileInList("pdf-test"));
    }

    @TestRails(id="87414")
    @Test
    public void uploadFileTXT() {
        UploadFiles uploadFiles = new UploadFiles(getDriver());
        uploadFiles.uploadFile(AttachPath.TEST_UPLOAD_TXT);
        Assert.assertTrue(uploadFiles.checkFileInList("txtfile"));
    }

    @TestRails(id="87415")
    @Test
    public void uploadFileGIF() {
        UploadFiles uploadFiles = new UploadFiles(getDriver());
        uploadFiles.uploadFile(AttachPath.TEST_UPLOAD_GIF);
        Assert.assertTrue(uploadFiles.checkFileInList("gifpicture"));
    }

    @TestRails(id="87416")
    @Test
    public void uploadFileJPG() {
        UploadFiles uploadFiles = new UploadFiles(getDriver());
        uploadFiles.uploadFile(AttachPath.TEST_UPLOAD_JPG);
        Assert.assertTrue(uploadFiles.checkFileInList("image"));
    }

    @TestRails(id="87417")
    @Test
    public void uploadFileJPEG() {
        UploadFiles uploadFiles = new UploadFiles(getDriver());
        uploadFiles.uploadFile(AttachPath.TEST_UPLOAD_JPEG);
        Assert.assertTrue(uploadFiles.checkFileInList("photo"));
    }

    @TestRails(id="87418")
    @Test
    public void uploadFilePNG() {
        UploadFiles uploadFiles = new UploadFiles(getDriver());
        uploadFiles.uploadFile(AttachPath.TEST_UPLOAD_PNG);
        Assert.assertTrue(uploadFiles.checkFileInList("testpicture"));
    }

    @TestRails(id="87419")
    @Test
    public void uploadFileXLS() {
        UploadFiles uploadFiles = new UploadFiles(getDriver());
        uploadFiles.uploadFile(AttachPath.TEST_UPLOAD_XLS);
        Assert.assertTrue(uploadFiles.checkFileInList("XLSfile"));
    }

    @TestRails(id="87420")
    @Test
    public void uploadFileWithDescription() {
        UploadFiles uploadFiles = new UploadFiles(getDriver());
        uploadFiles.uploadFileWithDescription(AttachPath.TEST_UPLOAD_DOC, "test description");
        Assert.assertTrue(uploadFiles.checkFileInList("TestDOC"));
    }

    @TestRails(id="87421")
    @Test
    public void uploadFileWithGdpr() {
        UploadFiles uploadFiles = new UploadFiles(getDriver());
        uploadFiles.uploadFileWithGDPR(AttachPath.TEST_UPLOAD_DOC);
        Assert.assertTrue(uploadFiles.checkFileInList("TestDOC"));
    }

    @AfterMethod
    public void refreshBoard() {
        getDriver().navigate().refresh();
        Waiters.treadWaiter(3);
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
