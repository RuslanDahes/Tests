package BoardGovernace.boards.folders;

import BoardGovernace.loginPage.Login;
import BoardGovernace.profile.BaseProfile;
import BoardGovernace.utils.UserCredentials;
import BoardGovernace.utils.Waiters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;

public class Permissions extends Folder {
    public Permissions(WebDriver driver) { super(driver); }

    @FindBy(className = "mdi-checkbox-marked")
    List<WebElement> permissionCheckboxList;
    @FindBy(className = "small-item")
    List<WebElement> permissionUserList;


    public void removePermission(String userName) {
        BaseProfile baseProfile = new BaseProfile(driver);
        openPermissionPopup();
        removePermissionsOnPopup(userName);
        savePermissionButton.click();
        Waiters.treadWaiter(2);
        baseProfile.logout();
    }

    public void openPermissionPopup() {
        openMenuFolder("Folder for Permission");
        clickOnElementJSTreadWait(folderPermissionMenuButton, 2);
        Waiters.treadWaiter(1);
    }

    public void removePermissionsOnPopup(String userName) {
        for (int i=0; i<permissionUserList.size(); i++) {
            if (permissionUserList.get(i).getText().contains(userName)) {
                permissionUserList.get(i).click();
                Waiters.treadWaiter(2);
                break;
            }
        }
    }

    public boolean checkPermission(String folderName) {
        Login login = new Login(driver);
        login.loginUser(UserCredentials.EMAIL_TEST, UserCredentials.PASSWORD_TEST);
        openBoard();
        return checkFolderInList(folderName);
    }
}
