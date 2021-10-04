package BoardGovernanceTest.boardsTest.foldersTest;

import BoardGovernace.boards.CreateBoard;
import BoardGovernace.boards.folders.SearchFolder;
import BoardGovernace.loginPage.Login;
import BoardGovernace.utils.UserCredentials;
import BoardGovernanceTest.BaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchFolderTest extends BaseTest {

    @BeforeClass
    public void login() {
        Login login = new Login(getDriver());
        SearchFolder searchFolder = new SearchFolder(getDriver());
        login.loginUser(UserCredentials.EMAIL_MYKHAIL, UserCredentials.PASSWORD_MYKHAIL);
//        createBoard.acceptCookie();
        searchFolder.openBoard();
    }

    @Test
    public void fullNameSearch() {
        SearchFolder searchFolder = new SearchFolder(getDriver());
        searchFolder.searchFolder("Test folder");
        searchFolder.searchResult("Test folder");
    }

    @Test
    public void partNameSearch() {
        SearchFolder searchFolder = new SearchFolder(getDriver());
        searchFolder.searchFolder("Test");
        searchFolder.searchResult("Test");
    }

    @Test
    public void checkEmptyResult() {
        SearchFolder searchFolder = new SearchFolder(getDriver());
        searchFolder.searchFolder("sdfgdfhfghfghdasdfads");
        searchFolder.displayingEmptyPlaceHolder();
    }

    @AfterMethod
    public void clearField() {
        SearchFolder searchFolder = new SearchFolder(getDriver());
        searchFolder.clearSearchField();
    }

}
