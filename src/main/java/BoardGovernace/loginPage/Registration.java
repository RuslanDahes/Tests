package BoardGovernace.loginPage;

import BoardGovernace.BasePage;
import BoardGovernace.utils.UserCredentials;
import BoardGovernace.utils.Waiters;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class Registration extends BasePage {
    public Registration(WebDriver driver) { super(driver); }
    String testRandomEmail;

    @FindBy(name = "firstname")
    WebElement firstNameField;
    @FindBy(name = "middlename")
    WebElement middleNameField;
    @FindBy(name = "lastname")
    WebElement surnameField;
    @FindBy(name = "email")
    WebElement emailField;
    @FindBy(name = "password")
    WebElement passwordField;
    @FindBy(className = "error-listerror-list")
    WebElement errorBlock;
    @FindBy(className = "error-list__item")
    List<WebElement> validationList;
    @FindBy(xpath = "//*[@data-cy='termsAcceptedCheckbox']")
    WebElement conditionsCheckBox;
    @FindBy(className = "subscription-label")
    List<WebElement> tariffPlan;
    @FindBy(xpath = "//*[@data-cy='signupFormCreateBtn']")
    WebElement createProfileButton;
    @FindBy(className = "form-error-message")
    List<WebElement> errorlist;
    @FindBy(className = "error-list__item")
    List<WebDriver> passwordValidationList;
    @FindBy(id = "ctl00_MainContent_WindowUC1_ctl00_ctl00_Logo1")
    WebElement danishCardIcon;
    @FindBy(id = "ctl00_MainContent_WindowUC1_ctl00_ctl00_Logo3")
    WebElement visaCardIcon;
    @FindBy(id = "ctl00_MainContent_WindowUC1_ctl00_ctl00_Logo4")
    WebElement masterCardIcon;
    @FindBy(id = "ctl00_MainContent_WindowUC1_ctl00_ctl00_btnSubmitForm")
    WebElement completePaymentButton;
    @FindBy(id = "epay_frame")
    WebElement frame;
    @FindBy(id = "ctl00_MainContent_WindowUC1_ctl00_epay_payment_return_button")
    WebElement continueButton;
    public  @FindBy(xpath = "//*[@data-cy='licenseFreeReadMore']")
    WebElement freeTariffReadMoreButton;
    public  @FindBy(xpath = "//*[@data-cy='licenseBasicReadMore']")
    WebElement basicTariffReadMoreButton;
    public  @FindBy(xpath = "//*[@data-cy='licenseProReadMore']")
    WebElement proTariffReadMoreButton;
    public  @FindBy(xpath = "//*[@data-cy='licenseEliteReadMore']")
    WebElement eliteTariffReadMoreButton;

    public String getTestRandomEmail() {
        return testRandomEmail;
    }

    public void setTestRandomEmail(String testRandomEmail) {
        this.testRandomEmail = testRandomEmail;
    }

    public void  fillAllData() {
        Random random = new Random();
        setTestRandomEmail("test" + String.valueOf(random.nextInt(1000000000)) + "@test.com");
        System.out.println(getTestRandomEmail());
        fillFields("FistName", "MiddleName", "SurName", getTestRandomEmail(), UserCredentials.PASSWORD_FOR_REGISTRATION);
//        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
//                ,conditionsCheckBox);
//        Waiters.treadWaiter(1);
        scrollAndClickToElementJS(conditionsCheckBox);
//        conditionsCheckBox.click();
    }

    public void fillFields(String firstName, String middleName, String surName, String email, String password) {
        firstNameField.sendKeys(firstName);
        middleNameField.sendKeys(middleName);
        surnameField.sendKeys(surName);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        Waiters.treadWaiter(2);

    }

    public void clearFields() {
        firstNameField.clear();
        middleNameField.clear();
        surnameField.clear();
        emailField.clear();
        passwordField.clear();
        Waiters.treadWaiter(1);
        driver.navigate().refresh();
        Waiters.treadWaiter(3);
    }


    public List<WebElement> getErrorlist() {
        return errorlist;
    }

    public void clickCreateButton() {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
                ,createProfileButton);
        Waiters.treadWaiter(1);
        scrollAndClickToElementJS(createProfileButton);
    }

    public void checkPassword(String password) {
        passwordField.sendKeys(password);
        scrollAndClickToElementJS(createProfileButton);
    }

    public List<WebElement> getValidationList() {
        return validationList;
    }

    public void acceptAlert() {
        Alert alert = driver.switchTo().alert();
        Waiters.treadWaiter(1);
        alert.accept();
        Waiters.treadWaiter(2);
    }

    public void createAccount(WebElement tariffPlan) {
        fillAllData();
        scrollAndClickToElementJS(tariffPlan);
//        tariffPlan.click();
        Waiters.treadWaiter(1);
        scrollAndClickToElementJS(createProfileButton);
    }

    public void payPopup(int typeOfAccount ) {
        driver.switchTo().frame(frame);
        Waiters.treadWaiter(2);
        if (typeOfAccount == 1) {
            scrollAndClickToElementJS(danishCardIcon);
        }
        if (typeOfAccount == 2) {
            scrollAndClickToElementJS(visaCardIcon);
        }
        if (typeOfAccount == 3) {
            scrollAndClickToElementJS(masterCardIcon);
        }
        completePaymentButton.click();
        Waiters.treadWaiter(2);
        continueButton.click();
        Waiters.treadWaiter(2);
    }
}
