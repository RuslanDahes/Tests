package BoardGovernanceTest;

import BoardGovernace.BasePage;
import BoardGovernace.testrailConfig.APIClient;
import BoardGovernace.testrailConfig.APIException;
import BoardGovernace.testrailConfig.TestSuiteCreating;
import BoardGovernace.utils.BrowserFactory;
import BoardGovernace.utils.Links;
import BoardGovernace.utils.UserCredentials;
import BoardGovernace.utils.Waiters;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static BoardGovernace.testrailConfig.TestSuiteCreating.*;

public class BaseTest {
    private static WebDriver driver;
    BasePage basePage = new BasePage(getDriver());


    @BeforeClass
    public void openBrowser() throws Exception {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
//        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriverforbg.exe");
        System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver");
        System.setProperty("webdriver.safari.driver", "src/test/resources/drivers/safaridriver");

        driver = BrowserFactory.getDriver(BrowserFactory.CHROMEWEB);
        if (driver == null) {
            System.out.println("Invalid driver");
            return;
        }
        driver.manage().window().maximize();
        Waiters.implicitWait(driver, Waiters.TIME_TEN, TimeUnit.SECONDS);
    }

    @BeforeSuite
    public void createSuite(ITestContext ctx) throws IOException, APIException {
        DateTimeFormatter dateFormater = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        CLIENT = new APIClient(Links.TESTRAIL_URL);
        CLIENT.setUser(UserCredentials.TESTRAIL_LOGIN);
        CLIENT.setPassword(UserCredentials.TESTRAIL_PASSWORD);
        Map data = new HashMap();
        data.put("include_all",true);
        data.put("suite_id", SUITE_ID);
        data.put("name","Automation tests " + dateFormater.format(now));
        JSONObject c = null;
        c = (JSONObject)CLIENT.sendPost("add_run/"+PROJECT_ID,data);
        Long run_id = (Long)c.get("id");
        TEST_RUN = run_id;
        System.out.println("Run ID" + run_id);
        ctx.setAttribute("suiteId",run_id);
    }



//    @BeforeSuite
//    public void openBrowser() {
//        Configuration.baseUrl= Links.STAGE_BASIC_URL;
//        Configuration.browser = "chrome";
//        Configuration.startMaximized = true;
//    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
