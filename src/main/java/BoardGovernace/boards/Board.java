package BoardGovernace.boards;

import BoardGovernace.BasePage;
import BoardGovernace.utils.Links;
import BoardGovernace.utils.Waiters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;

public class Board extends BasePage {
    public Board(WebDriver driver) { super(driver); }

    @FindBy(className = "header-small")
    List<WebElement> companyNameList;
    @FindBy(className = "mdi-dots-vertical")
    List<WebElement> verticalDotsList;
    @FindBy(className = "user-details")
    public WebElement userProfileAvatar;

    public void openBoard() {
        action.waitForVisible(userProfileAvatar);
        driver.get(Links.PRE_PROD_TEST_BOARD_URL);
        action.waitForPageLoaded();
        Waiters.treadWaiter(3);
//        action.waitForVisible(verticalDotsList);
//        Waiters.implicitWait(driver, Waiters.TIME_TEN, TimeUnit.SECONDS);
    }
}
