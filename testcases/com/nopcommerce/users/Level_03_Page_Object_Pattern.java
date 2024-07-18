package com.nopcommerce.users;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.CustomerInfoPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

import java.time.Duration;
import java.util.Random;

public class Level_03_Page_Object_Pattern extends BasePage{

    private WebDriver driver;
    private HomePageObject homePage;
    private LoginPageObject loginPage;
    private RegisterPageObject registerPage;
    private CustomerInfoPageObject customerInfoPage;


    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();

        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        homePage = new HomePageObject();
    }

    @Test
    public void User_01_Register() {
        homePage.clickToRegisterLink();
        registerPage = new RegisterPageObject();
        registerPage.clickToMaleRadio();
        registerPage.enterToFirstNameTextbox("");
        registerPage.enterToLastNameTextbox("");
        registerPage.selectDayDropdown("");
        registerPage.selectMonthDropdown("");
        registerPage.selectYearDropdown("");
        registerPage.enterToEmailTextbox("");
        registerPage.enterToCompanyNameTextbox("");
        registerPage.enterToPasswordTextbox("");
        registerPage.enterToConfirmPasswordTextbox("");
        registerPage.clickToRegisterButton();
        Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

    }

    @Test
    public void User_02_Login() {
        registerPage.clickToLogoutLink();
        registerPage.clickToLoginLink();
        loginPage = new LoginPageObject();
        loginPage.enterToEmailTextbox("");
        loginPage.enterToPasswordTextbox("");
        loginPage.clickToLoginButton();
        homePage = new HomePageObject();
        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());


    }
    @Test
    public void User_03_MyAccount(){
        homePage.clickToMyAccountLink();
        customerInfoPage = new CustomerInfoPageObject();
        Assert.assertTrue(customerInfoPage.isGenderMaleSelected());
        Assert.assertEquals(customerInfoPage.getFirstNameTextboxValue(),"");
        Assert.assertEquals(customerInfoPage.getLastNameTextboxValue(),"");
        Assert.assertEquals(customerInfoPage.getDayDropdownSelectedValue(),"");
        Assert.assertEquals(customerInfoPage.getMonthDropdownSelectedValue(),"");
        Assert.assertEquals(customerInfoPage.getYearDropdownSelectedValue(),"");
        Assert.assertEquals(customerInfoPage.getEmailTextboxValue(),"");

    }


    @AfterClass
    public void afterClass() {

        driver.quit();
    }
}
