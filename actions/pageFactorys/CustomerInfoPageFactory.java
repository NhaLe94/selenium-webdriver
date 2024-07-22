package pageFactorys;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageUIs.CustomerInfoPageUI;

public class CustomerInfoPageFactory extends BasePage{
    private WebDriver driver;

    public CustomerInfoPageFactory(WebDriver driver) {
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

    public boolean isGenderMaleSelected() {
        waitForElementVisible(driver, genderMaleRadio);
        return isElementSelected(genderMaleRadio);
    }

    public String getFirstNameTextboxValue() {
        waitForElementVisible(driver, firstNameTextbox);
        return getElementAttribute(firstNameTextbox, "value");
    }

    public String getLastNameTextboxValue() {
        waitForElementVisible(driver, lastNameTextbox);
        return getElementAttribute(lastNameTextbox, "value");
    }

    public String getDayDropdownSelectedValue() {
        waitForElementClickable(driver, dayDropdown);
        return getSelectItemInDropdown(dayDropdown);
    }

    public String getMonthDropdownSelectedValue() {
        waitForElementClickable(driver, monthDropdown);
        return getSelectItemInDropdown(monthDropdown);
    }

    public String getYearDropdownSelectedValue() {
        waitForElementClickable(driver, yearDropdown);
        return getSelectItemInDropdown(yearDropdown);
    }

    public String getEmailTextboxValue() {
        waitForElementVisible(driver, emailTextbox);
        return getElementAttribute(emailTextbox, "value");
    }

    public String getCompanyNameTextboxValue() {
        waitForElementVisible(driver, companyNameTextbox);
        return getElementAttribute(companyNameTextbox, "value");
    }
}
