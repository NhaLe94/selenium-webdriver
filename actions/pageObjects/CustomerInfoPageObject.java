package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.CustomerInfoPageUI;

public class CustomerInfoPageObject extends BasePage {
    private final WebDriver driver;
    public CustomerInfoPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public boolean isGenderMaleSelected() {
        waitForElementSelected(driver, CustomerInfoPageUI.GENDER_MALE_RADIO);
        return isElementSelected(driver, CustomerInfoPageUI.GENDER_MALE_RADIO);
    }

    public String getFirstNameTextboxValue() {
        waitForElementVisible(driver, CustomerInfoPageUI.FIRST_NAME_TEXTBOX);
        return getElementAttribute(driver, CustomerInfoPageUI.FIRST_NAME_TEXTBOX, "value");
    }

    public String getLastNameTextboxValue() {
        waitForElementVisible(driver, CustomerInfoPageUI.LAST_NAME_TEXTBOX);
        return getElementAttribute(driver, CustomerInfoPageUI.LAST_NAME_TEXTBOX, "value");
    }

    public String getDayDropdownSelectedValue() {
        waitForElementClickable(driver, CustomerInfoPageUI.DAY_DROPDOWN);
        return getSelectItemInDropdown(driver, CustomerInfoPageUI.DAY_DROPDOWN);
    }

    public String getMonthDropdownSelectedValue() {
        waitForElementClickable(driver, CustomerInfoPageUI.MONTH_DROPDOWN);
        return getSelectItemInDropdown(driver, CustomerInfoPageUI.MONTH_DROPDOWN);
    }

    public String getYearDropdownSelectedValue() {
        waitForElementClickable(driver, CustomerInfoPageUI.YEAR_DROPDOWN);
        return getSelectItemInDropdown(driver, CustomerInfoPageUI.YEAR_DROPDOWN);
    }

    public String getEmailTextboxValue() {
        waitForElementVisible(driver, CustomerInfoPageUI.EMAIL_TEXTBOX);
        return getElementAttribute(driver, CustomerInfoPageUI.EMAIL_TEXTBOX, "value");
    }

    public String getCompanyNameTextboxValue() {
        waitForElementVisible(driver, CustomerInfoPageUI.COMPANY_NAME_TEXTBOX);
        return getElementAttribute(driver, CustomerInfoPageUI.COMPANY_NAME_TEXTBOX, "value");
    }
}
