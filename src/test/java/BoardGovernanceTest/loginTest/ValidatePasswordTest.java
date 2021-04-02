package BoardGovernanceTest.loginTest;

import BoardGovernace.loginPage.Registration;
import BoardGovernace.utils.Params;
import BoardGovernace.utils.Texts;
import BoardGovernace.utils.Waiters;
import BoardGovernanceTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ValidatePasswordTest extends BaseTest {
    @BeforeClass
    public void openRegistrationPage() {
        Registration registration = new Registration(getDriver());
        registration.openPage("/en/opret-bruger/");
        Waiters.treadWaiter(1);
    }

    @Test
    public void capitalLetter() {
        Registration registration = new Registration(getDriver());
        registration.checkPassword(Texts.WRONG_TEST_PASSWORD);
        Assert.assertEquals(registration.getErrorlist().get(0).getCssValue("color"), Params.redColor);
    }

    @Test
    public void numberInPassword() {
        Registration registration = new Registration(getDriver());
        registration.checkPassword(Texts.WRONG_TEST_PASSWORD);
        Assert.assertEquals(registration.getErrorlist().get(1).getCssValue("color"), Params.redColor);
    }

    @Test
    public void smallLater() {
        Registration registration = new Registration(getDriver());
        registration.checkPassword("TEST");
        Assert.assertEquals(registration.getErrorlist().get(2).getCssValue("color"), Params.redColor);
    }

    @Test
    public void specialCharacter() {
        Registration registration = new Registration(getDriver());
        registration.checkPassword(Texts.WRONG_TEST_PASSWORD);
        Assert.assertEquals(registration.getErrorlist().get(3).getCssValue("color"), Params.redColor);
    }

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
}
