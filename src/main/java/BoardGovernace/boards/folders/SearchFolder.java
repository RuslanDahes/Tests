package BoardGovernace.boards.folders;

import BoardGovernace.utils.Waiters;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchFolder extends Folder {
    public SearchFolder(WebDriver driver) { super(driver); }
    @FindBy(className = "board-folder-empty")
    List<WebElement> emptyPlaceHolder;

    public boolean searchResult(String searchFolder) {
       boolean presentFolders = true;
        for (int i=0; i<folderList.size(); i++) {
            if (!folderList.get(i).getText().contains(searchFolder)) {
                presentFolders =false;
                break;
            }
        }
        return presentFolders;
    }

    public void clearSearchField() {
        searchField.clear();
        Waiters.treadWaiter(1);
        searchField.sendKeys(Keys.ENTER);
        Waiters.treadWaiter(2);
    }

    public boolean displayingEmptyPlaceHolder(){
        return emptyPlaceHolder.size()==1;
    }
}
