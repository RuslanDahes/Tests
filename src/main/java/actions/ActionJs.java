package actions;

import BoardGovernace.utils.Waiters;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionJs extends Act {
    public ActionJs(WebDriver driver) { super(driver); }

    public void scrollAndClickToElementJS(WebElement element) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(element));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();" ,element);
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
    }

    public void hover(WebElement element) {
        String javaScript = "var evObj = document.createEvent('MouseEvents');" +
                "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);" +
                "arguments[0].dispatchEvent(evObj);";
        ((JavascriptExecutor)driver).executeScript(javaScript, element);
    }

    public void click(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", waitForVisible(element));
    }

    public void sendkeys(WebElement element, String value) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value +"');", element);
    }

    public void clear(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", element);
    }


}
