package actions;

import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Act {

    public WebDriver driver;
    public FluentWait wait;


    public Act(WebDriver driver) {
        this.driver = driver;
        this.wait = setWebDriverWait();
    }

    private FluentWait setWebDriverWait() {
        Duration timeout = Duration.ofSeconds(
                Long.parseLong(
                        Objects.requireNonNull(
                                Dotenv.load().get("implicitlyWait"))));
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(timeout)
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);
        return (FluentWait) wait;
    }



    protected WebElement findWebElement(By by) {
        waitForPageLoaded();
        WebElement element = driver.findElement(by);
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='2px dashed #ffe207'", element);
        return element;
    }

    public WebElement waitElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    public WebElement fastWaitForVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public List<WebElement> fastWaitForVisible(List<WebElement> elements) {
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
        return elements;
    }

    public WebElement waitForVisible(WebElement element) {
        waitForPageLoaded();
        return fastWaitForVisible(element);
    }

    public List<WebElement> waitForVisible(List<WebElement> elements) {
        waitForPageLoaded();
        return fastWaitForVisible(elements);
    }

    public WebElement fastWaitForInvisible(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
        return element;
    }

    public WebElement waitForInvisible(WebElement element) {
        waitForPageLoaded();
        return fastWaitForInvisible(element);
    }

    public WebElement fastWaitToDisappear(WebElement element) {
        wait.until(ExpectedConditions.stalenessOf(element));
        return element;
    }

    public WebElement waitToDisappear(WebElement element) {
        waitForPageLoaded();
        return fastWaitToDisappear(element);
    }

    public void waitForPageLoaded() {
        wait.until(WebDriver -> ((JavascriptExecutor) driver).executeScript("return document.readyState")
                .equals("complete"));
    }

    public void waitForNewPageLoaded() {
        String currentUrl = driver.getCurrentUrl();
        while(driver.getCurrentUrl().equals(currentUrl)) {
            try {
                SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        wait.until(WebDriver -> ((JavascriptExecutor) driver).executeScript("return document.readyState")
                .equals("complete"));
    }

    public void waitForJQueryLoaded() {
        wait.until(WebDriver -> (Long)((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
    }

    public void contextClick(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).contextClick().build().perform();
    }

    public void setAttribute(WebElement element, String attName, String attValue) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);",
                element, attName, attValue);
    }

    public void openNewTab() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
    }

    public void openNewTabAndSwitchTo() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
    }

    public void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
