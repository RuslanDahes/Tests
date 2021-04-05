package BoardGovernanceTest.loginTest;

import BoardGovernace.loginPage.Login;
import BoardGovernace.profile.BaseProfile;
import BoardGovernace.testrailConfig.APIException;
import BoardGovernace.testrailConfig.TestRails;
import BoardGovernace.testrailConfig.TestSuiteCreating;
import BoardGovernace.utils.*;
import BoardGovernanceTest.BaseTest;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;


public class LoginTest extends BaseTest {


    @BeforeMethod
    public void getTestCase(ITestContext ctx, Method method) throws NoSuchMethodException {
        Method m = LoginTest.class.getMethod(method.getName());
        if (m.isAnnotationPresent(TestRails.class)) {
            TestRails ta = m.getAnnotation(TestRails.class);
            System.out.println(ta.id());
            ctx.setAttribute("caseId",ta.id());
        }
    }

    @TestRails(id="86378")
    @Test (priority = 3)
    public void succsesLogin() {
        Login login = new Login(getDriver());
        login.loginUser(UserCredentials.EMAIL_MYKHAIL, UserCredentials.PASSWORD_MYKHAIL);
        Waiters.treadWaiter(3);
        Assert.assertEquals(getDriver().getCurrentUrl(), Links.STAGE_BASIC_URL + Links.BASE_PAGE_URL);
    }

    @TestRails(id="86379")
    @Test (priority = 1)
    public void incorrectPassword() {
        Login login = new Login(getDriver());
        login.loginUser(UserCredentials.EMAIL_MYKHAIL, Texts.PASSWORD_INCORRECT);
        Assert.assertEquals(login.getLoginError().get(0).getText(), "Forkert brugernavn eller adgangskode. Prøv venligst igen.");
    }

    @TestRails(id="86380")
    @Test(priority = 1)
    public void incorrectEmail() {
        Login login = new Login(getDriver());
        login.loginUser(Texts.EMAIL_INCORRECT, UserCredentials.PASSWORD_MYKHAIL);
        Assert.assertEquals(login.getLoginError().get(0).getText(), "Forkert brugernavn eller adgangskode. Prøv venligst igen.");
    }

    @TestRails(id="86381")
    @Test(priority = 1)
    public void incorrectEmailAndPassword() {
        Login login = new Login(getDriver());
        login.loginUser(Texts.EMAIL_INCORRECT, Texts.PASSWORD_INCORRECT);
        Assert.assertEquals(login.getLoginError().get(0).getText(), "Forkert brugernavn eller adgangskode. Prøv venligst igen.");
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

    @AfterClass
    public void Logout() {
        BaseProfile baseProfile = new BaseProfile(getDriver());
        if (!getDriver().getCurrentUrl().equals(Links.STAGE_BASIC_URL + Links.LOGIN_URL))
            baseProfile.logout();
    }
}
