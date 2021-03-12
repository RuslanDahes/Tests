package BoardGovernanceTest.loginTest;

import BoardGovernace.loginPage.Login;
import BoardGovernace.utils.Links;
import BoardGovernace.utils.Texts;
import BoardGovernace.utils.UserCredentials;
import BoardGovernace.utils.Waiters;
import BoardGovernanceTest.BaseTest;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.url;

public class LoginTest extends BaseTest {
    Login login = new Login(getDriver());

    @Test (priority = 2)
    public void succsesLogin() {
        login.login(UserCredentials.EMAIL_MYKHAIL, UserCredentials.PASSWORD_MYKHAIL);
        Waiters.treadWaiter(3);
        Assert.assertEquals(url(), Links.STAGE_BASIC_URL + Links.BASE_PAGE_URL);
    }

    @Test
    public void incorrectPassword() {
        login.login(UserCredentials.EMAIL_MYKHAIL, Texts.PASSWORD_INCORRECT);
        $(login.loginError).shouldBe(Condition.exactText("Forkert brugernavn eller adgangskode. Prøv venligst igen."));
    }

    @Test
    public void incorrectEmail() {
        login.login(Texts.EMAIL_INCORRECT, UserCredentials.PASSWORD_MYKHAIL);
        $(login.loginError).shouldBe(Condition.exactText("Forkert brugernavn eller adgangskode. Prøv venligst igen."));
    }

    @Test
    public void incorrectEmailAndPassword() {
        login.login(Texts.EMAIL_INCORRECT, Texts.PASSWORD_INCORRECT);
        $(login.loginError).shouldBe(Condition.exactText("Forkert brugernavn eller adgangskode. Prøv venligst igen."));
    }



}
