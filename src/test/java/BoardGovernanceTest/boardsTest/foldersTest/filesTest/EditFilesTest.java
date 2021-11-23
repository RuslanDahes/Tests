package BoardGovernanceTest.boardsTest.foldersTest.filesTest;

import BoardGovernace.boards.folders.files.EditFiles;
import BoardGovernace.boards.folders.files.UploadFiles;
import BoardGovernace.loginPage.Login;
import BoardGovernace.utils.AttachPath;
import BoardGovernace.utils.Texts;
import BoardGovernace.utils.UserCredentials;
import BoardGovernace.utils.Waiters;
import BoardGovernanceTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EditFilesTest extends BaseTest  {
    @BeforeClass
    public void login() {
        EditFiles editFiles = new EditFiles(getDriver());
        editFiles.openFolder();
    }

    @Test
    public void editFileWithDescription() {
        EditFiles editFiles = new EditFiles(getDriver());
        editFiles.editFile("TestDOC", "Edited File Name", "Test description");
        Assert.assertEquals(editFiles.getFileTitle(), "Edited File Name");
        Assert.assertEquals(editFiles.getDescriptionText(), "Test description");
    }

    @Test
    public void editFileWithOutDescription() {
        EditFiles editFiles = new EditFiles(getDriver());
        editFiles.editFile("TestDOC", "Edited File Name");
        Assert.assertEquals(editFiles.getFileTitle(), "Edited File Name");
    }

    @AfterMethod
    public void refreshBoard() {
        EditFiles editFiles = new EditFiles(getDriver());
        editFiles.backToFolder();
    }


}
