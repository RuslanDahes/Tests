package BoardGovernanceTest.loginTest;

import BoardGovernace.loginPage.Registration;
import BoardGovernace.utils.Params;
import BoardGovernace.utils.Texts;
import BoardGovernace.utils.Waiters;
import BoardGovernanceTest.BaseTest;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {
    @BeforeClass
    public void openRegistrationPage() {
        Registration registration = new Registration(getDriver());
        registration.openPage("/en/opret-bruger/");
        Waiters.treadWaiter(1);
    }

    @Test
    public void tryRegistrationWithOutTariffPlan() {
        Registration registration = new Registration(getDriver());
        registration.fillAllData();
        registration.clickCreateButton();
        registration.acceptAlert();
    }

    @Test
    public void checkErrorVisibility() {
        Registration registration = new Registration(getDriver());
        Waiters.treadWaiter(2);
        registration.clickCreateButton();
        Assert.assertEquals(registration.getErrorlist().size(), 4);
    }

    @Test
    public void createFreeAccount() {
        Registration registration = new Registration(getDriver());
        registration.createAccount(0);
        Waiters.treadWaiter(10);
    }
}
