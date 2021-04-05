package BoardGovernanceTest.loginTest;

import BoardGovernace.loginPage.Registration;
import BoardGovernace.testrailConfig.APIException;
import BoardGovernace.testrailConfig.TestRails;
import BoardGovernace.testrailConfig.TestSuiteCreating;
import BoardGovernace.utils.Params;
import BoardGovernace.utils.Texts;
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

public class ValidatePasswordTest extends BaseTest {
    @BeforeClass
    public void openRegistrationPage() {
        Registration registration = new Registration(getDriver());
        registration.openPage("/en/opret-bruger/");
        Waiters.treadWaiter(1);
    }

    @BeforeMethod
    public void getTestCase(ITestContext ctx, Method method) throws NoSuchMethodException {
        Method m = ValidatePasswordTest.class.getMethod(method.getName());
        if (m.isAnnotationPresent(TestRails.class)) {
            TestRails ta = m.getAnnotation(TestRails.class);
            System.out.println(ta.id());
            ctx.setAttribute("caseId",ta.id());
        }
    }

    @TestRails(id="86475")
    @Test
    public void capitalLetter() {
        Registration registration = new Registration(getDriver());
        registration.checkPassword(Texts.WRONG_TEST_PASSWORD);
        Assert.assertEquals(registration.getErrorlist().get(0).getCssValue("color"), Params.redColor);
    }

    @TestRails(id="86476")
    @Test
    public void numberInPassword() {
        Registration registration = new Registration(getDriver());
        registration.checkPassword(Texts.WRONG_TEST_PASSWORD);
        Assert.assertEquals(registration.getErrorlist().get(1).getCssValue("color"), Params.redColor);
    }

    @TestRails(id="86477")
    @Test
    public void smallLater() {
        Registration registration = new Registration(getDriver());
        registration.checkPassword("TEST");
        Assert.assertEquals(registration.getErrorlist().get(2).getCssValue("color"), Params.redColor);
    }

    @TestRails(id="86478")
    @Test
    public void specialCharacter() {
        Registration registration = new Registration(getDriver());
        registration.checkPassword(Texts.WRONG_TEST_PASSWORD);
        Assert.assertEquals(registration.getErrorlist().get(3).getCssValue("color"), Params.redColor);
    }

    @TestRails(id="86479")
    @Test
    public void  lengthPassword() {
        Registration registration = new Registration(getDriver());
        registration.checkPassword(Texts.WRONG_TEST_PASSWORD);
        Assert.assertEquals(registration.getErrorlist().get(3).getCssValue("color"), Params.redColor);
    }

    @AfterMethod
    public void clearData() {
        Registration registration = new Registration(getDriver());
        registration.clearFields();
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
