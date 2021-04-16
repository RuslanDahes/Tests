package BoardGovernace.boards;

import BoardGovernace.BasePage;
import BoardGovernace.utils.Texts;
import BoardGovernace.utils.Waiters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CreateBoard extends BasePage {
    public CreateBoard(WebDriver driver) { super(driver); }
    @FindBy(name = "name")
    WebElement boardNameField;
    @FindBy(name = "company")
    WebElement companyNameField;
    @FindBy(name = "cvr")
    WebElement cvrField;
    @FindBy(name = "ean")
    WebElement eanField;
    @FindBy(name = "contact")
    WebElement contactPersonField;
    @FindBy(name = "sectoralCode")
    WebElement sectoralField;
    @FindBy(name = "address")
    WebElement addressField;
    @FindBy(name = "city")
    WebElement cityField;
    @FindBy(name = "zipCode")
    WebElement zipCodeField;
    @FindBy(name = "phone")
    WebElement phoneField;
    @FindBy(name = "country")
    WebElement countryField;
    @FindBy(name = "email")
    WebElement emailField;
    @FindBy(name = "language")
    WebElement languageDropDownList;
    @FindBy(xpath = "/html/body/div[3]/section/div/div/div[2]/div/div/div/new-board/form/div[2]/div[3]/div[3]/div[2]/form-input/div/div/div/ng-transclude/div")
    WebElement employeesContDropDownList;
    @FindBy(xpath = "/html/body/div[3]/section/div/div/div[2]/div/div/div/new-board/form/div[2]/div[5]/div[2]/div/div/label/input")
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

    public void selectTariffAndUserCount(WebElement tariff, WebElement userDropDown) {
        tariff.click();
        Waiters.treadWaiter(1);
        Select userCount = new Select(userDropDown);
        userCount.selectByVisibleText("4");
        Waiters.treadWaiter(1);
    }

    public void createRequiredBoard(WebElement tariff, WebElement userDropDownTariff) {
        fillRequiredFields();
        selectTariffAndUserCount(tariff, userDropDownTariff);
        termOfUseCheckBox.click();
        Waiters.treadWaiter(1);
        registrationBoardButton.click();
    }




}
