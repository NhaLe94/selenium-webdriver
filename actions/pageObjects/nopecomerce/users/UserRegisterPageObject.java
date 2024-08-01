package pageObjects.nopecomerce.users;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.nopecomerce.PageGenerator;
import pageUIs.nopCommerce.users.UserRegisterPageUI;

public class UserRegisterPageObject extends BasePage {
    private final WebDriver driver;
    public UserRegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public void clickToMaleRadio() {
        waitForElementClickable(driver, UserRegisterPageUI.GENDER_MALE_RADIO);
        checkToCheckboxRadio(driver, UserRegisterPageUI.GENDER_MALE_RADIO);
    }

    public void enterToFirstNameTextbox(String firstName) {
        waitForElementClickable(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX);
        sendkeyToElement(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX, firstName);

    }

    public void enterToLastNameTextbox(String lastName) {
        waitForElementClickable(driver, UserRegisterPageUI.LAST_NAME_TEXTBOX);
        sendkeyToElement(driver, UserRegisterPageUI.LAST_NAME_TEXTBOX, lastName);
    }

    public void selectDayDropdown(String day) {
        waitForElementClickable(driver, UserRegisterPageUI.DAY_DROPDOWN);
        selectItemInDropdown(driver, UserRegisterPageUI.DAY_DROPDOWN, day);
    }

    public void selectMonthDropdown(String month) {
        waitForElementClickable(driver, UserRegisterPageUI.MONTH_DROPDOWN);
        selectItemInDropdown(driver, UserRegisterPageUI.MONTH_DROPDOWN, month);
    }

    public void selectYearDropdown(String year) {
        waitForElementClickable(driver, UserRegisterPageUI.YEAR_DROPDOWN);
        selectItemInDropdown(driver, UserRegisterPageUI.YEAR_DROPDOWN, year);
    }

    public void enterToEmailTextbox(String email) {
        waitForElementClickable(driver, UserRegisterPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver, UserRegisterPageUI.EMAIL_TEXTBOX, email);
    }

    public void enterToCompanyNameTextbox(String companyName) {
        waitForElementClickable(driver, UserRegisterPageUI.COMPANY_NAME_TEXTBOX);
        sendkeyToElement(driver, UserRegisterPageUI.COMPANY_NAME_TEXTBOX, companyName);
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementClickable(driver, UserRegisterPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, UserRegisterPageUI.PASSWORD_TEXTBOX, password);
    }

    public void enterToConfirmPasswordTextbox(String confirmPassword) {
        waitForElementClickable(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendkeyToElement(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
    }

    public void clickToRegisterButton() {
        waitForElementClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);
    }

    public String getRegisterSuccessMessage() {
        waitForElementClickable(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
        return getElementText(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
    }

    public void clickToLogoutLink() {
        waitForElementClickable(driver, UserRegisterPageUI.LOGOUT_LINK);
        clickToElement(driver, UserRegisterPageUI.LOGOUT_LINK);
    }

    public UserLoginPageObject clickToLoginLink() {
        waitForElementClickable(driver, UserRegisterPageUI.LOGIN_LINK);
        clickToElement(driver, UserRegisterPageUI.LOGIN_LINK);
        return PageGenerator.getLoginPage(driver);

    }


}
