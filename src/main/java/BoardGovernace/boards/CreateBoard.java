package BoardGovernace.boards;

import BoardGovernace.BasePage;
import BoardGovernace.utils.Params;
import BoardGovernace.utils.Texts;
import BoardGovernace.utils.Waiters;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CreateBoard extends BasePage {
    public CreateBoard(WebDriver driver) { super(driver); }
    @FindBy(xpath = "//*[@data-cy='nameField']")
    WebElement boardNameField;
    @FindBy(xpath = "//*[@data-cy='companyField']")
    WebElement companyNameField;
    @FindBy(xpath = "//*[@data-cy='cvrField']")
    WebElement cvrField;
    @FindBy(name = "ean")
    WebElement eanField;
    @FindBy(name = "contact")
    WebElement contactPersonField;
    @FindBy(xpath = "//*[@data-cy='sectoralCodeField']")
    WebElement sectoralField;
    @FindBy(xpath = "/html/body/div/section/div/div/div[2]/div/div/div/new-board/form/div[2]/div[3]/div[4]/div/form-input/div/div/div/input")
    WebElement addressField;
    @FindBy(xpath = "/html/body/div/section/div/div/div[2]/div/div/div/new-board/form/div[2]/div[3]/div[5]/div[1]/form-input/div/div/div/input")
    WebElement cityField;
    @FindBy(xpath = "/html/body/div/section/div/div/div[2]/div/div/div/new-board/form/div[2]/div[3]/div[5]/div[2]/form-input/div/div/div/input")
    WebElement zipCodeField;
    @FindBy(xpath = "/html/body/div/section/div/div/div[2]/div/div/div/new-board/form/div[2]/div[3]/div[6]/div[1]/form-input/div/div/div/input")
    WebElement phoneField;
    @FindBy(name = "country")
    WebElement countryField;
    @FindBy(name = "email")
    WebElement emailField;
    @FindBy(name = "language")
    WebElement languageDropDownList;
    @FindBy(xpath = "//*[@data-cy='employeesCountSelect']")
    WebElement employeesContDropDownList;
    @FindBy(xpath = "//*[@data-cy='termsAcceptedCheckbox']")
    WebElement termOfUseCheckBox;
    @FindBy(xpath = "//*[@data-cy='codanTermsAcceptedCheckbox']")
    WebElement acceptComplianceCheckBox;
    @FindBy(xpath = "/html/body/div[3]/section/div/div/div[2]/div/div/div/new-board/form/div[2]/div[5]/insurance-terms/div[3]/div/div/label/input")
    WebElement compensationAgainstCheckBox;
    @FindBy(xpath = "/html/body/div[3]/section/div/div/div[2]/div/div/div/new-board/form/div[2]/div[5]/insurance-terms/div[1]/div/form-input/div/div/div/ng-transclude/div/a")
    WebElement directorsDropDownList;
    @FindBy(xpath = "//*[@data-cy='createNewBoardBtn']")
    WebElement registrationBoardButton;
    @FindBy(className = "subscription__mark")
    List<WebElement> priceBlocks;
    @FindBy(xpath = "//*[@data-cy='subscriptionMembersCountMini']")
    WebElement miniStartUserCount;
    @FindBy(xpath = "//*[@data-cy='subscriptionMembersCountStandard']")
    WebElement basicUserCount;
    @FindBy(xpath = "//*[@data-cy='subscriptionMembersCountElite']")
    WebElement eliteUserCount;
    @FindBy(xpath = "//*[@data-cy='subscriptionCorporate']")
    WebElement corporateUserCount;
    @FindBy(className = "subscription--elite")
    WebElement eliteTariff;
    @FindBy(id = "ui-select-choices-row-0-1")
    WebElement aboveUsers;
    @FindBy(className = "subscription__price-block")
    List<WebElement> priceBlocksList;
    @FindBy(className = "subscription--corporate")
    WebElement corporateTariff;
    @FindBy(className = "cookie-message-accept")
    WebElement cookieAcceptButton;




    public void fillRequiredFields(String boardName) {
        boardNameField.sendKeys(boardName);
        companyNameField.sendKeys(Texts.BOARD_COMPANY);
        cvrField.sendKeys(Texts.BOARD_CRV);
        sectoralField.sendKeys(Texts.BOARD_SECTORAL);
        addressField.sendKeys(Texts.BOARD_ADDRESS);
        cityField.sendKeys(Texts.BOARD_CITY);
        zipCodeField.sendKeys(Texts.BOARD_ZIP);
        phoneField.sendKeys(Texts.BOARD_PHONE_NUMBER);
    }

    public void fillAllFields(String boardName) {
        fillRequiredFields(boardName);
    }

    public void tariffMiniStart() {
//        priceBlocks.get(0).click();
        Waiters.treadWaiter(1);
        Select userCount = new Select(miniStartUserCount);
        userCount.selectByVisibleText("4");
        Waiters.treadWaiter(1);
    }

    public void tariffBasic() {
//        priceBlocks.get(1).click();
        Waiters.treadWaiter(1);
        Select userCount = new Select(basicUserCount);
        userCount.selectByVisibleText("4");
        Waiters.treadWaiter(1);
    }

    public void tariffElite() {
//        eliteUserCount.click();
        Waiters.treadWaiter(1);
        Select userCount = new Select(eliteUserCount);
        userCount.selectByVisibleText("4");
        Waiters.treadWaiter(10);

    }

    public void tariffCorporate() {
//        priceBlocks.get(3).click();
        corporateTariff.click();
//        Waiters.treadWaiter(1);
//        Select userCount = new Select(corporateUserCount);
//        userCount.selectByVisibleText("4");
        Waiters.treadWaiter(3);

    }


    public void createRequiredBoard(String nameTariff) {
        fillRequiredFields(nameTariff);
        if (nameTariff.equals(Texts.MINI_START_TARIFF)) {
            tariffMiniStart();
        }
        if (nameTariff.equals(Texts.BASIC_TARIFF)) {
            tariffBasic();
        }
        if (nameTariff.equals(Texts.ELITE_TARIFF)) {
            tariffElite();
        }
        if (nameTariff.equals(Texts.CORPORATE_TARIFF)) {
            tariffCorporate();

        }
        Waiters.treadWaiter(1);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", termOfUseCheckBox);
        Waiters.treadWaiter(2);
//        termOfUseCheckBox.click();
        Waiters.treadWaiter(1);
        registrationBoardButton.click();
    }

    public void checkError() {
        tariffMiniStart();
        registrationBoardButton.click();
        Waiters.treadWaiter(3);
        Assert.assertEquals(boardNameField.getCssValue("border-color"), Params.errorFields);
        Assert.assertEquals(companyNameField.getCssValue("border-color"), Params.errorFields);
        Assert.assertEquals(cvrField.getCssValue("border-color"), Params.errorFields);
        Assert.assertEquals(sectoralField.getCssValue("border-color"), Params.errorFields);
        Assert.assertEquals(addressField.getCssValue("border-color"), Params.errorFields);
        Assert.assertEquals(cityField.getCssValue("border-color"), Params.errorFields);
        Assert.assertEquals(zipCodeField.getCssValue("border-color"), Params.errorFields);
        Assert.assertEquals(phoneField.getCssValue("border-color"), Params.errorFields);
    }

    public void aboveCheck() {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", employeesContDropDownList);
        Waiters.treadWaiter(5);
        employeesContDropDownList.click();
        Waiters.treadWaiter(3);
        aboveUsers.click();
        Waiters.treadWaiter(1);
        Assert.assertEquals(priceBlocksList.get(3).getCssValue("background-color"), "rgba(90, 95, 116, 1)");
    }

    public void acceptCookie() {
        cookieAcceptButton.click();
        Waiters.treadWaiter(2);
    }

}
