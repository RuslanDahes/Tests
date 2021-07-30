package BoardGovernace.boards;

import BoardGovernace.BasePage;
import BoardGovernace.utils.Waiters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;
import java.util.concurrent.TimeUnit;

public class Board extends BasePage {
    public Board(WebDriver driver) { super(driver); }

    @FindBy(className = "header-small")
    List<WebElement> companyNameList;
    @FindBy(className = "mdi-dots-vertical")
    List<WebElement> verticalDotsList;





    public void openBoard() {
        driver.get("https://www.staging.board-office.dk/board-login/board-office/board/a33eccee-2573-4190-9bcd-c9018a174109/archive");
        Waiters.implicitWait(driver, Waiters.TIME_TEN, TimeUnit.SECONDS);
    }



}
