package pageObjects.nopecomerce.users;

import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.users.UserCustomerInfoPageUI;

public class UserCustomerInfoPageObject extends UserSideBarPageObject {
    private final WebDriver driver;
    public UserCustomerInfoPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    public boolean isGenderMaleSelected() {
        waitForElementSelected(driver, UserCustomerInfoPageUI.GENDER_MALE_RADIO);
        return isElementSelected(driver, UserCustomerInfoPageUI.GENDER_MALE_RADIO);
    }

    public String getFirstNameTextboxValue() {
        waitForElementVisible(driver, UserCustomerInfoPageUI.FIRST_NAME_TEXTBOX);
        return getElementAttribute(driver, UserCustomerInfoPageUI.FIRST_NAME_TEXTBOX, "value");
    }

    public String getLastNameTextboxValue() {
        waitForElementVisible(driver, UserCustomerInfoPageUI.LAST_NAME_TEXTBOX);
        return getElementAttribute(driver, UserCustomerInfoPageUI.LAST_NAME_TEXTBOX, "value");
    }

    public String getDayDropdownSelectedValue() {
        waitForElementClickable(driver, UserCustomerInfoPageUI.DAY_DROPDOWN);
        return getSelectItemInDropdown(driver, UserCustomerInfoPageUI.DAY_DROPDOWN);
    }

    public String getMonthDropdownSelectedValue() {
        waitForElementClickable(driver, UserCustomerInfoPageUI.MONTH_DROPDOWN);
        return getSelectItemInDropdown(driver, UserCustomerInfoPageUI.MONTH_DROPDOWN);
    }

    public String getYearDropdownSelectedValue() {
        waitForElementClickable(driver, UserCustomerInfoPageUI.YEAR_DROPDOWN);
        return getSelectItemInDropdown(driver, UserCustomerInfoPageUI.YEAR_DROPDOWN);
    }

    public String getEmailTextboxValue() {
        waitForElementVisible(driver, UserCustomerInfoPageUI.EMAIL_TEXTBOX);
        return getElementAttribute(driver, UserCustomerInfoPageUI.EMAIL_TEXTBOX, "value");
    }

    public String getCompanyNameTextboxValue() {
        waitForElementVisible(driver, UserCustomerInfoPageUI.COMPANY_NAME_TEXTBOX);
        return getElementAttribute(driver, UserCustomerInfoPageUI.COMPANY_NAME_TEXTBOX, "value");
    }



}
