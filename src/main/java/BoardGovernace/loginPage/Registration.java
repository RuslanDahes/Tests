package BoardGovernace.loginPage;

import BoardGovernace.BasePage;
import BoardGovernace.utils.Waiters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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



    public void fillFields(String firstName, String middleName, String surName, String email, String password) {
        firstNameField.sendKeys(firstName);
        Waiters.treadWaiter(1);
        middleNameField.sendKeys(middleName);
        Waiters.treadWaiter(1);
        surnameField.sendKeys(surName);
        Waiters.treadWaiter(1);
        emailField.sendKeys(email);
        Waiters.treadWaiter(1);
        passwordField.sendKeys(password);
        Waiters.treadWaiter(10);
    }
}
