package BoardGovernace.boards;

import BoardGovernace.BasePage;
import BoardGovernace.utils.Texts;
import BoardGovernace.utils.Waiters;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CreateBoard extends BasePage {
    public CreateBoard(WebDriver driver) { super(driver); }
    @FindBy(xpath = "/html/body/div[3]/section/div/div/div[2]/div/div/div/new-board/form/div[2]/div[1]/div/div[1]/form-input/div/div/div/ng-transclude/input")
    WebElement boardNameField;
    @FindBy(xpath = "/html/body/div[3]/section/div/div/div[2]/div/div/div/new-board/form/div[2]/div[3]/div[1]/div[1]/form-input/div/div/div/ng-transclude/input")
    WebElement companyNameField;
    @FindBy(xpath = "/html/body/div[3]/section/div/div/div[2]/div/div/div/new-board/form/div[2]/div[3]/div[2]/div[1]/form-input/div/div/div/ng-transclude/input")
    WebElement cvrField;
    @FindBy(xpath = "/html/body/div[3]/section/div/div/div[2]/div/div/div/new-board/form/div[2]/div[3]/div[3]/div[1]/form-input/div/div/div/input")
    WebElement eanField;
    @FindBy(xpath = "/html/body/div[3]/section/div/div/div[2]/div/div/div/new-board/form/div[2]/div[3]/div[1]/div[2]/form-input/div/div/div/input")
    WebElement contactPersonField;
    @FindBy(xpath = "/html/body/div[3]/section/div/div/div[2]/div/div/div/new-board/form/div[2]/div[3]/div[2]/div[2]/form-input/div/div/div/ng-transclude/input")
    WebElement sectoralField;
    @FindBy(xpath = "/html/body/div[3]/section/div/div/div[2]/div/div/div/new-board/form/div[2]/div[3]/div[4]/div/form-input/div/div/div/input")
    WebElement addressField;
    @FindBy(xpath = "/html/body/div[3]/section/div/div/div[2]/div/div/div/new-board/form/div[2]/div[3]/div[5]/div[1]/form-input/div/div/div/input")
    WebElement cityField;
    @FindBy(xpath = "/html/body/div[3]/section/div/div/div[2]/div/div/div/new-board/form/div[2]/div[3]/div[5]/div[2]/form-input/div/div/div/input")
    WebElement zipCodeField;
    @FindBy(xpath = "/html/body/div[3]/section/div/div/div[2]/div/div/div/new-board/form/div[2]/div[3]/div[6]/div[1]/form-input/div/div/div/input")
    WebElement phoneField;
    @FindBy(xpath = "/html/body/div[3]/section/div/div/div[2]/div/div/div/new-board/form/div[2]/div[3]/div[5]/div[3]/form-input/div/div/div/input")
    WebElement countryField;
    @FindBy(name = "email")
    WebElement emailField;
    @FindBy(name = "language")
    WebElement languageDropDownList;
    @FindBy(xpath = "/html/body/div[3]/section/div/div/div[2]/div/div/div/new-board/form/div[2]/div[3]/div[3]/div[2]/form-input/div/div/div/ng-transclude/div")
    WebElement employeesContDropDownList;
    @FindBy(xpath = "/html/body/div[3]/section/div/div/div[2]/div/div/div/new-board/form/div[2]/div[5]/div[2]/div/div/label")
    WebElement termOfUseCheckBox;
    @FindBy(xpath = "/html/body/div[3]/section/div/div/div[2]/div/div/div/new-board/form/div[2]/div[5]/insurance-terms/div[2]/div/div/label/input")
    WebElement acceptComplianceCheckBox;
    @FindBy(xpath = "/html/body/div[3]/section/div/div/div[2]/div/div/div/new-board/form/div[2]/div[5]/insurance-terms/div[3]/div/div/label/input")
    WebElement compensationAgainstCheckBox;
    @FindBy(xpath = "/html/body/div[3]/section/div/div/div[2]/div/div/div/new-board/form/div[2]/div[5]/insurance-terms/div[1]/div/form-input/div/div/div/ng-transclude/div/a")
    WebElement directorsDropDownList;
    @FindBy(xpath = "/html/body/div[3]/section/div/div/div[2]/div/div/div/new-board/form/div[2]/div[6]/div[3]/div/div/button")
    WebElement registrationBoardButton;
    @FindBy(className = "subscription__price-block")
    List<WebElement> priceBlocks;
    @FindBy(xpath = "/html/body/div[3]/section/div/div/div[2]/div/div/div/new-board/form/div[2]/div[5]/div[1]/div[1]/div/div[2]/p[2]/select")
    WebElement miniStartUserCount;
    @FindBy(xpath = "/html/body/div[3]/section/div/div/div[2]/div/div/div/new-board/form/div[2]/div[5]/div[1]/div[2]/div/div[2]/p[2]/select")
    WebElement basicUserCount;
    @FindBy(xpath = "/html/body/div[3]/section/div/div/div[2]/div/div/div/new-board/form/div[2]/div[5]/div[1]/div[3]/div/div[2]/p[2]/select")
    WebElement eliteUserCount;
    @FindBy(xpath = "/html/body/div[3]/section/div/div/div[2]/div/div/div/new-board/form/div[2]/div[5]/div[1]/div[4]/div/div[2]/p[2]/select")
    WebElement corporateUserCount;





    public void fillRequiredFields() {
        boardNameField.sendKeys(Texts.BOARD_NAME);
        companyNameField.sendKeys(Texts.BOARD_COMPANY);
        cvrField.sendKeys(Texts.BOARD_CRV);
        sectoralField.sendKeys(Texts.BOARD_SECTORAL);
        addressField.sendKeys(Texts.BOARD_ADDRESS);
        cityField.sendKeys(Texts.BOARD_CITY);
        zipCodeField.sendKeys(Texts.BOARD_ZIP);
        phoneField.sendKeys(Texts.BOARD_PHONE_NUMBER);
    }

    public void fillAllFields() {
        fillRequiredFields();
    }

    public void tariffMiniStart() {
        priceBlocks.get(0).click();
        Waiters.treadWaiter(1);
        Select userCount = new Select(miniStartUserCount);
        userCount.selectByVisibleText("4");
        Waiters.treadWaiter(1);
    }

    public void tariffBasic() {
        priceBlocks.get(1).click();
        Waiters.treadWaiter(1);
        Select userCount = new Select(basicUserCount);
        userCount.selectByVisibleText("4");
        Waiters.treadWaiter(1);
    }

    public void tariffElite() {
        priceBlocks.get(2).click();
        Waiters.treadWaiter(1);
        Select userCount = new Select(eliteUserCount);
        userCount.selectByVisibleText("4");
        Waiters.treadWaiter(1);
    }

    public void tariffCorporate() {
        priceBlocks.get(3).click();
        Waiters.treadWaiter(1);
        Select userCount = new Select(corporateUserCount);
        userCount.selectByVisibleText("4");
        Waiters.treadWaiter(1);
    }


    public void createRequiredBoard(String nameTariff) {
        fillRequiredFields();
        if (nameTariff.equals(Texts.MINI_START_TARIFF)) {
            tariffMiniStart();
        }
        if (nameTariff.equals(Texts.BASIC_TARIFF)) {
            tariffBasic();
        }
        if (nameTariff.equals(Texts.ELITE_TARIFF)) {
            tariffCorporate();
        }
        if (nameTariff.equals(Texts.CORPORATE_TARIFF)) {
            tariffElite();
        }
        Waiters.treadWaiter(1);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", termOfUseCheckBox);
        Waiters.treadWaiter(10);
//        termOfUseCheckBox.click();
        Waiters.treadWaiter(1);
        registrationBoardButton.click();
    }




}
