package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGenerator;
import pageObjects.users.*;

public class Level_10_Dynamic_Locator extends BaseTest {

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
        Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
        registerPage.clickToLogoutLink();
    }

    @Test
    public void User_02_Login() {
        loginPage = registerPage.clickToLoginLink();
        homePage= loginPage.LoginToSystem(emailAddress, password);
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
        Assert.assertEquals(customerInfoPage.getEmailTextboxValue(),emailAddress);

    }
    @Test
    public void User_04_Switch_Page(){
        addressPage =(UserAddressPageObject) customerInfoPage.openSidebarLinkByPageName("Addresses");
        rewardPointPage =(UserRewardPointPageObject) addressPage.openSidebarLinkByPageName("Reward points");
        orderPage =(UserOrderPageObject) rewardPointPage.openSidebarLinkByPageName("Orders");
        addressPage = (UserAddressPageObject) orderPage.openSidebarLinkByPageName("Addresses");
        customerInfoPage =(UserCustomerInfoPageObject) addressPage.openSidebarLinkByPageName("Customer info");
    }
    @AfterClass
    public void afterClass() {

        driver.quit();
    }
}
