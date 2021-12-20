package BoardGovernace;

import BoardGovernace.utils.Links;
import BoardGovernace.utils.Waiters;
import actions.Action;
import actions.ActionJs;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePage {
    protected WebDriver driver;
    protected Action action;
    protected ActionJs actionJs;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.action = new Action(driver);
        this.actionJs = new ActionJs(driver);
        PageFactory.initElements(driver, this);
    }

    public void openPage(String pageUrl) {
//        driver.get(Links.STAGE_BASIC_URL + pageUrl);
        driver.get(Links.PRE_PROD_BASIC_URL + pageUrl);
//        Waiters.implicitWait(driver, Waiters.TIME_TEN, TimeUnit.SECONDS);
        action.waitForPageLoaded();
    }

    public void scrollAndClickToElementJS(WebElement element) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(element));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();" ,element);
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
        Waiters.treadWaiter(1);
    }

    public void clickOnElementJSTreadWait(WebElement element, int timeInSec) {
        Waiters.treadWaiter(timeInSec);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();" ,element);
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
    }

    public void scrollAndInputToElementJS(WebElement element, String text) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
                ,element);
        element.sendKeys(text);
        Waiters.treadWaiter(1);
    }


}
