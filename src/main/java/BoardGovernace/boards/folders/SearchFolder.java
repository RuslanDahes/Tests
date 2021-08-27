package BoardGovernace.boards.folders;

import org.openqa.selenium.WebDriver;

public class SearchFolder extends Folder {
    public SearchFolder(WebDriver driver) { super(driver); }

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
}
