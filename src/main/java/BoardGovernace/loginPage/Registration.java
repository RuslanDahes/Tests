package BoardGovernace.loginPage;

import BoardGovernace.BasePage;
import BoardGovernace.utils.Waiters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

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
    @FindBy(xpath = "/html/body/div[3]/div[1]/signup-form/div[2]/div/form/div/div/div[2]/div[2]/div/div/label/input")
    WebElement conditionsCheckBox;
    @FindBy(className = "subscription-label")
    List<WebElement> tariffPlan;
    @FindBy(xpath = "/html/body/div[3]/div[1]/signup-form/div[2]/div/form/div/div/div[2]/div[2]/div/button")
    WebElement createProfileButton;



    public void fillFields(String firstName, String middleName, String surName, String email, String password) {
        firstNameField.sendKeys(firstName);
        middleNameField.sendKeys(middleName);
        surnameField.sendKeys(surName);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        Waiters.treadWaiter(10);
    }
}
