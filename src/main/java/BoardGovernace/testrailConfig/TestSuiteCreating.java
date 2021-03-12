package BoardGovernace.testrailConfig;

import BoardGovernace.utils.Links;
import BoardGovernace.utils.Params;
import BoardGovernace.utils.UserCredentials;
import org.json.simple.JSONObject;
import org.testng.ITestContext;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class TestSuiteCreating {

    public static long TEST_RUN;
    public static APIClient CLIENT;
    public static String PROJECT_ID = "56";
    public static int SUITE_ID = 1724;


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
}
