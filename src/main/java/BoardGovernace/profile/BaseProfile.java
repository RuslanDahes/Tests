package BoardGovernace.profile;

import BoardGovernace.BasePage;
import BoardGovernace.utils.Waiters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BaseProfile extends BasePage {
    public BaseProfile(WebDriver driver) { super(driver); }

    @FindBy(className = "user-details")
    protected WebElement userProfileAvatar;
    @FindBy(className = "mdi-logout")
    protected List<WebElement> logoutButtonListOne;
    @FindBy(className = "btn--default")
    WebElement noButton;



    public void logout() {
        action.waitElementToBeClickable(userProfileAvatar);
        clickOnElementJSTreadWait(userProfileAvatar, 5);
        Waiters.treadWaiter(2);
        System.out.println(logoutButtonListOne.size());
        clickOnElementJSTreadWait(logoutButtonListOne.get(1), 5);
//        logoutButtonListOne.get(1).click();
//        Waiters.treadWaiter(2);
//        noButton.click();
//        Waiters.treadWaiter(2);
    }
}
