package BoardGovernace.boards.folders;

import BoardGovernace.utils.Waiters;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;

public class AppearanceFolder extends Folder {
    public AppearanceFolder(WebDriver driver) { super(driver); }
    @FindBy(className = "mdi-triangle")
    List<WebElement> dropdownButton;
    @FindBy(className = "icon--color-bg-green")
    WebElement liteGreenColorButton;
    @FindBy(className = "icon--color-bg-blue")
    WebElement blueColorButton;
    @FindBy(className = "icon--color-green")
    WebElement greenIconButton;
    @FindBy(xpath = "//*[@data-cy='customSettingsSaveBtn']")
    WebElement saveButton;
    @FindBy(className = "archive-file-list__icon")
    List<WebElement> folderFonList;
    @FindBy(className = "icon--color-blue")
    WebElement blueIconButton;



    public void selectAppearance() {
        clickOnElementJSTreadWait(appearanceButton, 2);
        Waiters.treadWaiter(1);
    }

    public void changeGreenColorFon() {
        dropdownButton.get(0).click();
        Waiters.treadWaiter(1);
        liteGreenColorButton.click();
        Waiters.treadWaiter(1);
        saveButton.click();
        Waiters.treadWaiter(2);
    }

    public void changeBlueColorFon() {
        dropdownButton.get(0).click();
        Waiters.treadWaiter(1);
        blueColorButton.click();
        Waiters.treadWaiter(1);
        saveButton.click();
        Waiters.treadWaiter(2);
    }

    public void changeGreenIcon() {
        dropdownButton.get(1).click();
        Waiters.treadWaiter(1);
        greenIconButton.click();
        Waiters.treadWaiter(1);
        saveButton.click();
        Waiters.treadWaiter(2);
    }

    public void changeBlueIcon() {
        dropdownButton.get(1).click();
        Waiters.treadWaiter(1);
        greenIconButton.click();
        Waiters.treadWaiter(1);
        saveButton.click();
        Waiters.treadWaiter(2);
    }
}
