package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopecomerce.PageGenerator;
import pageObjects.nopecomerce.admin.AdminDashboardPO;
import pageObjects.nopecomerce.admin.AdminLoginPO;
import pageObjects.nopecomerce.users.*;


public class Level_09_Switch_Site_Url extends BaseTest {
    private  String userUrl, adminUrl;

    private WebDriver driver;
    private UserHomePageObject homePage;
    private UserLoginPageObject userLoginPage;
    private UserRegisterPageObject registerPage;
    private UserCustomerInfoPageObject usercustomerInfoPage;
    private UserAddressPageObject useraddressPage;
    private UserOrderPageObject userorderPage;
    private UserRewardPointPageObject userrewardPointPage;
    private AdminLoginPO adminLogin;
    private AdminDashboardPO adminDashboard;
    private String firstName , lastName , emailAddress , password, companyName, day, month , year ;
    private String adminEmailAddress, adminPassword;

    @Parameters({"browser", "userUrl", "adminUrl"})
    @BeforeClass
    public void beforeClass(String browserName,String userUrl, String adminUrl) {
        this.userUrl = userUrl;
        this.adminUrl = adminUrl;
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
        adminEmailAddress = "admin@yourstore.com";
        adminPassword = "admin";
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
    public void Role_01_User_02_Login() {
        userLoginPage = registerPage.clickToLoginLink();
        homePage= userLoginPage.LoginToSystem(emailAddress, password);
        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

        homePage.openPageUrl(driver, this.adminUrl);
        adminLogin = PageGenerator.getAdminLoginPage(driver);
        //adminLogin.enterToEmailTextbox(adminEmailAddress);
        //adminLogin.enterToPasswordTextbox(adminPassword);
        adminDashboard = adminLogin.clickToLoginButton();

    }

    @Test
    public void Role_03_Admin_Site_To_Site(){
        adminDashboard.openPageUrl(driver, this.userUrl);
        homePage = PageGenerator.getHomePage(driver);
        usercustomerInfoPage = homePage.openCustomerInfo();

        Assert.assertTrue(usercustomerInfoPage.isGenderMaleSelected());
        Assert.assertEquals(usercustomerInfoPage.getFirstNameTextboxValue(),firstName);
        Assert.assertEquals(usercustomerInfoPage.getLastNameTextboxValue(),lastName);
        Assert.assertEquals(usercustomerInfoPage.getDayDropdownSelectedValue(),day);
        Assert.assertEquals(usercustomerInfoPage.getMonthDropdownSelectedValue(),month);
        Assert.assertEquals(usercustomerInfoPage.getYearDropdownSelectedValue(),year);
        Assert.assertEquals(usercustomerInfoPage.getCompanyNameTextboxValue(),companyName);
        Assert.assertEquals(usercustomerInfoPage.getEmailTextboxValue(),emailAddress);

    }
    @AfterClass
    public void afterClass() {

        driver.quit();
    }
}
