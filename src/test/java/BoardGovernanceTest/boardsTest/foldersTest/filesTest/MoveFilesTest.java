package BoardGovernanceTest.boardsTest.foldersTest.filesTest;

import BoardGovernace.boards.folders.files.MoveFiles;
import BoardGovernace.boards.folders.files.UploadFiles;
import BoardGovernace.loginPage.Login;
import BoardGovernace.utils.AttachPath;
import BoardGovernace.utils.Texts;
import BoardGovernace.utils.UserCredentials;
import BoardGovernace.utils.Waiters;
import BoardGovernanceTest.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MoveFilesTest extends BaseTest {
    @BeforeClass
    public void loginAndOpenFolder() {
        MoveFiles moveFiles = new MoveFiles(getDriver());
        moveFiles.openFolder();
    }

    @Test
    public void moveFileS() {
        MoveFiles moveFiles = new MoveFiles(getDriver());
        moveFiles.moveFile();
        Waiters.treadWaiter(10);
    }


}
