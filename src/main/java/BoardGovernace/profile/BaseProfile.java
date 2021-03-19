package BoardGovernace.profile;

import BoardGovernace.BasePage;
import BoardGovernace.utils.Waiters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BaseProfile extends BasePage {
    public BaseProfile(WebDriver driver) { super(driver); }

    @FindBy(className = "user-details-img-wrapper")
    protected WebElement userProfileAvatar;
    @FindBy(className = "mdi-logout")
    protected List<WebElement> logoutButtonListOne;


    public void logout() {
        userProfileAvatar.click();
        Waiters.treadWaiter(1);
        logoutButtonListOne.get(1).click();
        Waiters.treadWaiter(1);
    }
}
