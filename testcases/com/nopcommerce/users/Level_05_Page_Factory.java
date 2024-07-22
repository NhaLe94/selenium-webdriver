package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageFactorys.CustomerInfoPageFactory;
import pageFactorys.HomePageFactory;
import pageFactorys.LoginPageFactory;
import pageFactorys.RegisterPageFactory;


import java.time.Duration;

public class Level_05_Page_Factory extends BaseTest {

    private WebDriver driver;
    private HomePageFactory homePage;
    private LoginPageFactory loginPage;
    private RegisterPageFactory registerPage;
    private CustomerInfoPageFactory customerInfoPage;
    private String firstName , lastName , email , password, companyName, day, month , year ;


    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();

        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        homePage = new HomePageFactory(driver);
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
        registerPage = new RegisterPageFactory(driver);
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
        loginPage = new LoginPageFactory(driver);
        loginPage.enterToEmailTextbox(email);
        loginPage.enterToPasswordTextbox(password);
        loginPage.clickToLoginButton();
        homePage = new HomePageFactory(driver);
        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());


    }
    @Test
    public void User_03_MyAccount(){
        homePage.clickToMyAccountLink();
        customerInfoPage = new CustomerInfoPageFactory(driver);
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
