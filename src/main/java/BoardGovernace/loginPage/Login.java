package BoardGovernace.loginPage;

import BoardGovernace.BasePage;
import BoardGovernace.utils.Links;
import BoardGovernace.utils.Waiters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.openqa.selenium.By.*;

public class Login extends BasePage {
    public Login(WebDriver driver) { super(driver); }
    @FindBy (name = "email")
    WebElement emailField;
    @FindBy (name = "password")
    WebElement passwordField;
    @FindBy (className = "btn--primary")
    WebElement loginButton;
    @FindBy (className = "message-content")
    List<WebElement> loginError;

    public List<WebElement> getLoginError() {
        return loginError;
    }

    //    public By emailField = name("email");
//    public By passwordField = name("password");
//    public By loginButton = cssSelector("body > div.wrapper > div > div.row.collapse > div > login-form > div > div > div > div.login-form.login-content.ng-scope > form > div.btn-wrap > button-submit > button");
//    public By loginError = className("message-content");




    public void loginUser(String email, String password) {
        openPage(Links.LOGIN_URL);
        emailField.sendKeys(email);
        Waiters.treadWaiter(1);
        passwordField.sendKeys(password);
        Waiters.treadWaiter(1);
        loginButton.click();
        Waiters.treadWaiter(2);
    }
}
