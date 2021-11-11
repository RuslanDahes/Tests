package BoardGovernace.boards.folders.files;

import BoardGovernace.boards.folders.Folder;
import BoardGovernace.utils.Waiters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Files extends Folder {
    public Files(WebDriver driver) { super(driver); }
    @FindBy(className = "archive-file-list__box")
    List<WebElement> listOfFile;




    public void openFile(String fileName) {
        for(int i = 0; i<listOfFile.size(); i++) {
            if (listOfFile.get(i).getText().contains(fileName)) {
                listOfFile.get(i).click();
                Waiters.treadWaiter(2);
                break;
            }
        }
    }
}
