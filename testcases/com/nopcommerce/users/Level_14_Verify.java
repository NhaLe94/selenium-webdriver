package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopecomerce.PageGenerator;
import pageObjects.nopecomerce.users.*;


public class Level_14_Verify extends BaseTest {

    private WebDriver driver;
    private UserHomePageObject homePage;
    private UserLoginPageObject loginPage;
    private UserRegisterPageObject registerPage;
    private UserCustomerInfoPageObject customerInfoPage;
    private UserAddressPageObject addressPage;
    private UserOrderPageObject orderPage;
    private UserRewardPointPageObject rewardPointPage;
    private String firstName , lastName , emailAddress , password, companyName, day, month , year ;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserName(browserName);

        homePage =  PageGenerator.getHomePage(driver);
        firstName = "Selenium";
        lastName = "Testing";
        emailAddress = "nhale" + generateRandomNumber() + "@gmail.de";
        password = "123456";
        companyName = "Building";
        day = "10";
        month = "May";
        year = "1993";
    }

    @Test
    public void User_01_Register() {
        registerPage = homePage.clickToRegisterLink();
        verifyEquals(registerPage.getRegisterPageTitle(), "Your registration completed ");
        registerPage.clickToMaleRadio();
        registerPage.enterToFirstNameTextbox(firstName);
        registerPage.enterToLastNameTextbox(lastName);
        registerPage.selectDayDropdown(day);
        registerPage.selectMonthDropdown(month);
        registerPage.selectYearDropdown(year);
        registerPage.enterToEmailTextbox(emailAddress);
        registerPage.enterToCompanyNameTextbox(companyName);
        registerPage.enterToPasswordTextbox(password);
        registerPage.enterToConfirmPasswordTextbox(password);
        registerPage.clickToRegisterButton();
        verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed.");
        //verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

        registerPage.clickToLogoutLink();
    }

    @Test
    public void User_02_Login() {
        loginPage = registerPage.clickToLoginLink();
        homePage= loginPage.LoginToSystem(emailAddress, password);
        verifyTrue(homePage.isMyAccountLinkDisplayed());
    }
    @Test
    public void User_03_MyAccount(){
        homePage.openCustomerInfo();
        customerInfoPage = new UserCustomerInfoPageObject(driver);
        verifyTrue(customerInfoPage.isGenderMaleSelected());
        verifyEquals(customerInfoPage.getFirstNameTextboxValue(),firstName);
        verifyEquals(customerInfoPage.getLastNameTextboxValue(),lastName);
        verifyEquals(customerInfoPage.getDayDropdownSelectedValue(),day);
        verifyEquals(customerInfoPage.getMonthDropdownSelectedValue(),month);
        verifyEquals(customerInfoPage.getYearDropdownSelectedValue(),year);
        verifyEquals(customerInfoPage.getCompanyNameTextboxValue(),companyName);
        verifyEquals(customerInfoPage.getEmailTextboxValue(),emailAddress);

    }


    @AfterClass
    public void afterClass() {
       // driver.quit();
    }
}
