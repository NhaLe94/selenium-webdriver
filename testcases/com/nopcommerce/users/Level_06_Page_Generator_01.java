package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.CustomerInfoPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class Level_06_Page_Generator_01 extends BaseTest {

    private WebDriver driver;
    private HomePageObject homePage;
    private LoginPageObject loginPage;
    private RegisterPageObject registerPage;
    private CustomerInfoPageObject customerInfoPage;
    private String firstName , lastName , emailAddress , password, companyName, day, month , year ;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserName(browserName);

        homePage = new HomePageObject(driver);
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
        homePage.clickToRegisterLink();
        registerPage = new RegisterPageObject(driver);
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
        loginPage = new LoginPageObject(driver);
    }

    @Test
    public void User_02_Login() {
        registerPage.clickToLoginLink();
        loginPage = new LoginPageObject(driver);
        loginPage.LoginToSystem(emailAddress, password);
        homePage = new HomePageObject(driver);
        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());


    }
    @Test
    public void User_03_MyAccount(){
        homePage.clickToMyAccountLink();
        customerInfoPage = new CustomerInfoPageObject(driver);
        Assert.assertTrue(customerInfoPage.isGenderMaleSelected());
        Assert.assertEquals(customerInfoPage.getFirstNameTextboxValue(),firstName);
        Assert.assertEquals(customerInfoPage.getLastNameTextboxValue(),lastName);
        Assert.assertEquals(customerInfoPage.getDayDropdownSelectedValue(),day);
        Assert.assertEquals(customerInfoPage.getMonthDropdownSelectedValue(),month);
        Assert.assertEquals(customerInfoPage.getYearDropdownSelectedValue(),year);
        Assert.assertEquals(customerInfoPage.getCompanyNameTextboxValue(),companyName);
        Assert.assertEquals(customerInfoPage.getEmailTextboxValue(),emailAddress);

    }


    @AfterClass
    public void afterClass() {

        driver.quit();
    }
}
