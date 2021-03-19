package BoardGovernace;

import BoardGovernace.utils.Links;
import BoardGovernace.utils.Waiters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

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

//    public void open(String page) {
//        open(Links.STAGE_BASIC_URL + page);
//    }

//    public void openURL(String pageUrl) {
//        Selenide.open(Links.STAGE_BASIC_URL + pageUrl);
//    }
}
