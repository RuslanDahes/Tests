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

    public void openBoard() {
        driver.get(Links.PRE_PROD_TEST_BOARD_URL);
//        Waiters.implicitWait(driver, Waiters.TIME_TEN, TimeUnit.SECONDS);
        Waiters.treadWaiter(5);
    }
}
