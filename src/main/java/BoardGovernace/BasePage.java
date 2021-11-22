package BoardGovernace;

import BoardGovernace.utils.Links;
import BoardGovernace.utils.Waiters;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openPage(String pageUrl) {
        driver.get(Links.STAGE_BASIC_URL + pageUrl);
        Waiters.implicitWait(driver, Waiters.TIME_TEN, TimeUnit.SECONDS);
    }

    public void scrollAndClickToElement(WebElement element) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
                ,element);
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(element)).click();
        Waiters.treadWaiter(1);
    }

    public void scrollAndInputToElement(WebElement element, String text) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
                ,element);
        element.sendKeys(text);
        Waiters.treadWaiter(1);
    }


}
