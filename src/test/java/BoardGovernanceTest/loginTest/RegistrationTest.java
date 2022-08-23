package BoardGovernanceTest.loginTest;

import BoardGovernace.loginPage.Login;
import BoardGovernace.loginPage.Registration;
import BoardGovernace.testrailConfig.APIException;
import BoardGovernace.testrailConfig.TestRails;
import BoardGovernace.testrailConfig.TestSuiteCreating;
import BoardGovernace.utils.Params;
import BoardGovernace.utils.Texts;
import BoardGovernace.utils.UserCredentials;
import BoardGovernace.utils.Waiters;
import BoardGovernanceTest.BaseTest;
import org.openqa.selenium.Alert;
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

public class RegistrationTest extends BaseTest {
    @BeforeMethod
    public void getTestCase(ITestContext ctx, Method method) throws NoSuchMethodException {
        Method m = RegistrationTest.class.getMethod(method.getName());
        if (m.isAnnotationPresent(TestRails.class)) {
            TestRails ta = m.getAnnotation(TestRails.class);
            System.out.println(ta.id());
            ctx.setAttribute("caseId",ta.id());
        }
    }

    @TestRails(id="86469")
    @Test (priority = 1)
    public void tryRegistrationWithOutTariffPlan() {
        Registration registration = new Registration(getDriver());
        registration.openPage("/en/opret-bruger/");
        registration.fillAllData();
        registration.clickCreateButton();
        registration.acceptAlert();
    }

    @TestRails(id="86470")
    @Test (priority = 1)
    public void checkErrorVisibility() {
        Registration registration = new Registration(getDriver());
        registration.openPage("/en/opret-bruger/");
        registration.clickCreateButton();
        Assert.assertEquals(registration.getErrorlist().size(), 5);
    }

    @TestRails(id="86471")
    @Test (priority = 2)
    public void createFreeAccount() {
        Registration registration = new Registration(getDriver());
        Login login = new Login(getDriver());
        registration.openPage("/en/opret-bruger/");
        Waiters.treadWaiter(1);
        registration.createAccount(registration.freeTariffReadMoreButton);
        Waiters.treadWaiter(5);
        login.loginUser(registration.getTestRandomEmail(), UserCredentials.PASSWORD_FOR_REGISTRATION);
//        Waiters.treadWaiter(10);
    }

//    @TestRails(id="86472")
//    @Test (priority = 2)
//    public void createBasicAccount() {
//        Registration registration = new Registration(getDriver());
//        registration.openPage("/en/opret-bruger/");
//        Waiters.treadWaiter(1);
//        registration.createAccount(registration.basicTariffReadMoreButton);
//        registration.payPopup(1);
//    }
//
//    @TestRails(id="86473")
//    @Test (priority = 2)
//    public void createProAccount() {
//        Registration registration = new Registration(getDriver());
//        registration.openPage("/en/opret-bruger/");
//        Waiters.treadWaiter(1);
//        registration.createAccount(registration.proTariffReadMoreButton);
//        registration.payPopup(2);
//    }
//
//    @TestRails(id="86474")
//    @Test (priority = 2)
//    public void createEliteAccount() {
//        Registration registration = new Registration(getDriver());
//        registration.openPage("/en/opret-bruger/");
//        Waiters.treadWaiter(1);
//        registration.createAccount(registration.eliteTariffReadMoreButton);
//        registration.payPopup(3);
//    }


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
