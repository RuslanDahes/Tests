package BoardGovernace.boards.folders;

import BoardGovernace.utils.Waiters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewLogs extends Folder {
    public ViewLogs(WebDriver driver) { super(driver); }

    @FindBy (xpath = "/html/body/div[3]/section/div/div/board/ng-transclude/board-global-log/div/div/div/div/ng-container/div[2]/div/board-global-log-overview/table/tbody/tr[1]/td[2]")
    WebElement firstAction;

    public boolean checkCreateLogs() {
        openBoard();
        openMenuFolder("CreateFolderLogs");
        Waiters.treadWaiter(10);
        viewLogButton.click();
        Waiters.treadWaiter(2);
        return firstAction.getText().contains("Folders created");
    }
}
