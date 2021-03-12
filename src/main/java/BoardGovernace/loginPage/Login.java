package BoardGovernace.loginPage;
import BoardGovernace.BasePage;
import BoardGovernace.utils.Links;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.*;

public class Login extends BasePage {
    public Login(WebDriver driver) { super(driver); }
    public By emailField = name("email");
    public By passwordField = name("password");
    public By loginButton = cssSelector("body > div.wrapper > div > div.row.collapse > div > login-form > div > div > div > div.login-form.login-content.ng-scope > form > div.btn-wrap > button-submit > button");
    public By loginError = className("message-content");




    public void login(String email, String password) {
        openURL(Links.LOGIN_URL);
        $(emailField).sendKeys(email);
        $(passwordField).sendKeys(password);
        $(loginButton).click();
    }
}
