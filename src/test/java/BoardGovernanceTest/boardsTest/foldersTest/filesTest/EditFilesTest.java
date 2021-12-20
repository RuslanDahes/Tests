package BoardGovernanceTest.boardsTest.foldersTest.filesTest;

import BoardGovernace.boards.folders.files.EditFiles;
import BoardGovernace.boards.folders.files.UploadFiles;
import BoardGovernace.loginPage.Login;
import BoardGovernace.utils.AttachPath;
import BoardGovernace.utils.Texts;
import BoardGovernace.utils.UserCredentials;
import BoardGovernace.utils.Waiters;
import BoardGovernanceTest.BaseTest;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EditFilesTest extends BaseTest  {
    @BeforeClass
    public void login() {
        EditFiles editFiles = new EditFiles(getDriver());
        editFiles.openFolder();
//        editFiles.uploadFile(AttachPath.TEST_UPLOAD_DOC);
    }


    @Test
    public void editFileWithDescription() {
        EditFiles editFiles = new EditFiles(getDriver());
        editFiles.editFile("TestDOC", "Edited File Name", "Test description");
//        Assert.assertTrue(editFiles.checkFileInList("Edited File Name"));
    }

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


}
