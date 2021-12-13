package BoardGovernanceTest.boardsTest.foldersTest;

import BoardGovernace.boards.folders.AppearanceFolder;
import BoardGovernace.boards.folders.CreateFolder;
import BoardGovernace.loginPage.Login;
import BoardGovernace.testrailConfig.APIException;
import BoardGovernace.testrailConfig.TestRails;
import BoardGovernace.testrailConfig.TestSuiteCreating;
import BoardGovernace.utils.UserCredentials;
import BoardGovernanceTest.BaseTest;
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

public class AppearanceFolderTest extends BaseTest {
    @BeforeClass
    public void login() {
        Login login = new Login(getDriver());
        login.loginUser(UserCredentials.EMAIL_MYKHAIL, UserCredentials.PASSWORD_MYKHAIL);
    }

    @BeforeMethod
    public void getTestCase(ITestContext ctx, Method method) throws NoSuchMethodException {
        Method m = AppearanceFolderTest.class.getMethod(method.getName());
        if (m.isAnnotationPresent(TestRails.class)) {
            TestRails ta = m.getAnnotation(TestRails.class);
            System.out.println(ta.id());
            ctx.setAttribute("caseId",ta.id());
        }
    }

    @BeforeMethod
    public void openPage() {
        AppearanceFolder appearanceFolder = new AppearanceFolder(getDriver());
        CreateFolder createFolder = new CreateFolder(getDriver());
        appearanceFolder.openBoard();
        createFolder.createFolder("Appearance");
        appearanceFolder.openMenuFolder("Appearance");
    }

    @TestRails(id="86800")
    @Test
    public void createBlueFolderFon() {
        AppearanceFolder appearanceFolder = new AppearanceFolder(getDriver());
        appearanceFolder.selectAppearance();
        appearanceFolder.changeBlueColorFon();
    }

    @TestRails(id="86801")
    @Test
    public void createGreenFolderFon() {
        AppearanceFolder appearanceFolder = new AppearanceFolder(getDriver());
        appearanceFolder.selectAppearance();
        appearanceFolder.changeGreenColorFon();
    }

    @TestRails(id="86802")
    @Test
    public void createBlueFolderIcon() {
        AppearanceFolder appearanceFolder = new AppearanceFolder(getDriver());
        appearanceFolder.selectAppearance();
        appearanceFolder.changeBlueIcon();
    }

    @TestRails(id="86803")
    @Test
    public void createGreenFolderIcon() {
        AppearanceFolder appearanceFolder = new AppearanceFolder(getDriver());
        appearanceFolder.selectAppearance();
        appearanceFolder.changeGreenIcon();
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
