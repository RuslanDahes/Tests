package actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Action extends Act {
    public Action(WebDriver driver) { super(driver); }

    public void click(WebElement element) {
        waitForVisible(element);
        element.click();
    }

    public void clear(WebElement element) {
        waitForVisible(element);
        element.clear();
    }

    public void clearAndSendKeys(WebElement element, String value) {
        waitForVisible(element);
        element.clear();
        element.sendKeys(value);
    }

    public void sendKeys(WebElement element, String value) {
        waitForVisible(element);
        element.sendKeys(value);
    }

    public void sendKeysAndClickEnter(WebElement element, String value) {
        waitForVisible(element);
        element.clear();
        element.sendKeys(value, Keys.ENTER);
    }

    public void moveTo(WebElement element) {
        waitForVisible(element);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public void moveToAndWait(WebElement element) {
        waitForVisible(element);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).pause(500).build().perform();
    }
}
