package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopecomerce.users.UserCustomerInfoPageObject;
import pageObjects.nopecomerce.users.UserHomePageObject;
import pageObjects.nopecomerce.users.UserLoginPageObject;
import pageObjects.nopecomerce.users.UserRegisterPageObject;

public class Level_04_Multiple_Browser extends BaseTest {

    private WebDriver driver;
    private UserHomePageObject homePage;
    private UserLoginPageObject loginPage;
    private UserRegisterPageObject registerPage;
    private UserCustomerInfoPageObject customerInfoPage;
    private String firstName , lastName , email , password, companyName, day, month , year ;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserName(browserName);

        homePage = new UserHomePageObject(driver);
        firstName = "Selenium";
        lastName = "Testing";
        email = "nhale" + generateRandomNumber() + "@gmail.de";
        password = "123456";
        companyName = "Building";
        day = "10";
        month = "May";
        year = "1993";
    }

    @Test
    public void User_01_Register() {
        homePage.clickToRegisterLink();
        registerPage = new UserRegisterPageObject(driver);
        registerPage.clickToMaleRadio();
        registerPage.enterToFirstNameTextbox(firstName);
        registerPage.enterToLastNameTextbox(lastName);
        registerPage.selectDayDropdown(day);
        registerPage.selectMonthDropdown(month);
        registerPage.selectYearDropdown(year);
        registerPage.enterToEmailTextbox(email);
        registerPage.enterToCompanyNameTextbox(companyName);
        registerPage.enterToPasswordTextbox(password);
        registerPage.enterToConfirmPasswordTextbox(password);
        registerPage.clickToRegisterButton();
        Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

    }

    @Test
    public void User_02_Login() {
        registerPage.clickToLogoutLink();
        registerPage.clickToLoginLink();
        loginPage = new UserLoginPageObject(driver);
        loginPage.enterToEmailTextbox(email);
        loginPage.enterToPasswordTextbox(password);
        loginPage.clickToLoginButton();
        homePage = new UserHomePageObject(driver);
        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());


    }
    @Test
    public void User_03_MyAccount(){
        homePage.openCustomerInfo();
        customerInfoPage = new UserCustomerInfoPageObject(driver);
        Assert.assertTrue(customerInfoPage.isGenderMaleSelected());
        Assert.assertEquals(customerInfoPage.getFirstNameTextboxValue(),firstName);
        Assert.assertEquals(customerInfoPage.getLastNameTextboxValue(),lastName);
        Assert.assertEquals(customerInfoPage.getDayDropdownSelectedValue(),day);
        Assert.assertEquals(customerInfoPage.getMonthDropdownSelectedValue(),month);
        Assert.assertEquals(customerInfoPage.getYearDropdownSelectedValue(),year);
        Assert.assertEquals(customerInfoPage.getCompanyNameTextboxValue(),companyName);
        Assert.assertEquals(customerInfoPage.getEmailTextboxValue(),email);

    }


    @AfterClass
    public void afterClass() {

        driver.quit();
    }
}
