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
import java.util.Set;

public class Registration extends BasePage {
    public Registration(WebDriver driver) { super(driver); }
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
    @FindBy(xpath = "/html/body/div/div[1]/signup-form/div[2]/div/form/div/div/div[2]/div[2]/div/div/label/input")
    WebElement conditionsCheckBox;
    @FindBy(className = "subscription-label")
    List<WebElement> tariffPlan;
    @FindBy(className = "btn--lg")
    WebElement createProfileButton;
    @FindBy(className = "form-error-message")
    List<WebElement> errorlist;
    @FindBy(className = "error-list__item")
    List<WebDriver> passwordValidationList;
    String testRandomEmail;
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
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
                ,conditionsCheckBox);
        Waiters.treadWaiter(1);
        conditionsCheckBox.click();
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
        createProfileButton.click();
        Waiters.treadWaiter(1);
    }

    public void checkPassword(String password) {
        passwordField.sendKeys(password);
        clickCreateButton();
        Waiters.treadWaiter(1);
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

    public void createAccount(int typeAccount) {
        fillAllData();
        tariffPlan.get(typeAccount).click();
        Waiters.treadWaiter(1);
        clickCreateButton();
        Waiters.treadWaiter(3);
    }

    public void payPopup(int typeOfAccount ) {
        driver.switchTo().frame(frame);
        Waiters.treadWaiter(2);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
                ,danishCardIcon);
        Waiters.treadWaiter(1);
        Waiters.treadWaiter(3);
        if (typeOfAccount == 1) {
            danishCardIcon.click();
            Waiters.treadWaiter(2);
        }
        if (typeOfAccount == 2) {
            visaCardIcon.click();
            Waiters.treadWaiter(2);
        }
        if (typeOfAccount == 3) {
            masterCardIcon.click();
            Waiters.treadWaiter(2);
        }
        completePaymentButton.click();
        Waiters.treadWaiter(2);
        continueButton.click();
        Waiters.treadWaiter(2);
    }
}
