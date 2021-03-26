package BoardGovernanceTest.loginTest;

import BoardGovernace.loginPage.Registration;
import BoardGovernace.utils.Waiters;
import BoardGovernanceTest.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {
    @BeforeClass
    public void openRegistrationPage() {
        Registration registration = new Registration(getDriver());
        registration.openPage("/en/opret-bruger/");
        Waiters.treadWaiter(3);
    }

    @Test
    public void checkFields() {
        Registration registration = new Registration(getDriver());
        registration.fillFields("FistName", "MiddleName", "SurName", "test@test.com", "password");
    }
}
