package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Waiters {
    public static final  int TIME_MINUTE = 60;
    public static final  int TIME_TEN = 10;
    public static final  int TIME_SECONDS = 5;

    public static void implicitWait (WebDriver driver, int time, TimeUnit timeUnit) {

        driver.manage().timeouts().implicitlyWait(time, timeUnit);
    }


    public static void treadWaiter (int timeInSec) {
        try {
            Thread.sleep(timeInSec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void waitForUrl (WebDriver driver, int maxTimeSeconds, String url) {
        WebDriverWait wait = new WebDriverWait(driver, maxTimeSeconds);
        wait.until(ExpectedConditions.urlToBe(url));
    }
}
