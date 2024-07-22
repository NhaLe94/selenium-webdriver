package pageFactorys;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageUIs.RegisterPageUI;

public class RegisterPageFactory extends BasePage {
    private WebDriver driver;

    public RegisterPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='gender-male']")
    private WebElement genderMaleRadio;

    @FindBy(xpath = "//input[@id='FirstName']")
    private WebElement firstNameTextbox;

    @FindBy(xpath = "//input[@id='LastName']")
    private WebElement lastNameTextbox;

    @FindBy(xpath = "//select[@name='DateOfBirthDay']")
    private WebElement dayDropdown;

    @FindBy(xpath = "//select[@name='DateOfBirthMonth']")
    private WebElement monthDropdown;

    @FindBy(xpath = "//select[@name='DateOfBirthYear']")
    private WebElement yearDropdown;

    @FindBy(xpath = "//input[@id='Email']")
    private WebElement emailTextbox;

    @FindBy(xpath = "//input[@id='Company']")
    private WebElement companyNameTextbox;

    @FindBy(xpath = "//input[@id='Password']")
    private WebElement passwordTextbox;

    @FindBy(xpath = "//input[@id='ConfirmPassword']")
    private WebElement confirmPasswordTextbox;

    @FindBy(xpath = "//button[@id='register-button']")
    private WebElement registerButton;

    @FindBy(xpath = "//div[@class='result']")
    private WebElement resultText;

    @FindBy(xpath = "//a[@class='ico-logout']")
    private WebElement logoutLink;

    @FindBy(xpath = "//a[@class='ico-login']")
    private WebElement loginLink;

    public void clickToMaleRadio() {
        waitForElementClickable(driver, genderMaleRadio);
        clickToElement(genderMaleRadio);
    }

    public void enterToFirstNameTextbox(String firstName) {
        waitForElementVisible(driver, firstNameTextbox);
        sendkeyToElement(firstNameTextbox, firstName);

    }

    public void enterToLastNameTextbox(String lastName) {
        waitForElementVisible(driver, lastNameTextbox);
        sendkeyToElement(lastNameTextbox, lastName);
    }

    public void selectDayDropdown(String day) {
        waitForElementClickable(driver, dayDropdown);
        selectItemInDropdown(dayDropdown, day);
    }

    public void selectMonthDropdown(String month) {
        waitForElementClickable(driver, monthDropdown);
        selectItemInDropdown(monthDropdown, month);
    }

    public void selectYearDropdown(String year) {
        waitForElementClickable(driver, yearDropdown);
        selectItemInDropdown(yearDropdown, year);
    }

    public void enterToEmailTextbox(String email) {
        waitForElementVisible(driver, emailTextbox);
        sendkeyToElement(emailTextbox, email);
    }

    public void enterToCompanyNameTextbox(String companyName) {
        waitForElementVisible(driver, companyNameTextbox);
        sendkeyToElement(companyNameTextbox, companyName);
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver, passwordTextbox);
        sendkeyToElement(passwordTextbox, password);
    }

    public void enterToConfirmPasswordTextbox(String confirmPassword) {
        waitForElementVisible(driver, confirmPasswordTextbox);
        sendkeyToElement(confirmPasswordTextbox, confirmPassword);
    }

    public void clickToRegisterButton() {
        waitForElementClickable(driver, registerButton);
        clickToElement(registerButton);
    }

    public String getRegisterSuccessMessage() {
        waitForElementClickable(driver, resultText);
        return getElementText(resultText);
    }

    public void clickToLogoutLink() {
        waitForElementClickable(driver, logoutLink);
        clickToElement(logoutLink);
    }

    public void clickToLoginLink() {
        waitForElementClickable(driver, loginLink);
        clickToElement(loginLink);
    }
}
