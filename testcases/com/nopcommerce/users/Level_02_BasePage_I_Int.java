package com.nopcommerce.users;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Level_02_BasePage_I_Int {
    BasePage basePage;
    WebDriver driver;
    String firstName , lastName , emailAddress , password, companyName, day,month , year ;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        basePage = new BasePage();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        emailAddress = "nhale" + getEmailAddress();
    }

    @Test
    public void User_01_Register() {
        basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
        basePage.clickToElement(driver, "//a[@class='ico-register']");
        basePage.waitForElementClickable(driver, "//input[@id='gender-male']");
        basePage.clickToElement(driver, "//input[@id='gender-male']");
        
        basePage.sendkeyToElement(driver,"//input[@id='FirstName']", "Testing");
        basePage.sendkeyToElement(driver,"//input[@id='LastName']", "Selenium");
        basePage.selectItemInDropdown(driver, "//select[@name='DateOfBirthDay']", "10");
        basePage.selectItemInDropdown(driver, "//select[@name='DateOfBirthMonth']", "May");
        basePage.selectItemInDropdown(driver, "//select[@name='DateOfBirthYear']", "1995");
        basePage.sendkeyToElement(driver,"//input[@id='Email']", emailAddress);
        basePage.sendkeyToElement(driver,"//input[@id='Company']", "Building");
        basePage.sendkeyToElement(driver,"//input[@id='Password']", "123456");
        basePage.sendkeyToElement(driver,"//input[@id='ConfirmPassword']", "123456");
        basePage.waitForElementClickable(driver, "//button[@id='register-button']");
        basePage.clickToElement(driver, "//button[@id='register-button']");
        Assert.assertEquals(basePage.getElementText(driver, "//div[@class='result']"), "Your registration completed");
        basePage.waitForElementClickable(driver, "//a[@class='ico-logout']");
        basePage.clickToElement(driver, "//a[@class='ico-logout']");

    }

    @Test
    public void User_02_Login() {
        basePage.waitForElementClickable(driver, "//a[@class='ico-login']");
        basePage.clickToElement(driver, "//a[@class='ico-login']");
        basePage.sendkeyToElement(driver,"//input[@id='Email']", emailAddress);
        basePage.sendkeyToElement(driver,"//input[@id='Password']", "123456");
        basePage.waitForElementClickable(driver, "//button[contains(@class,'login-button')]");
        basePage.clickToElement(driver, "//button[contains(@class,'login-button')]");
        Assert.assertTrue(basePage.isElementDisplayed(driver, "//a[@class='ico-account' and text()='My account']"));

    }
    @Test
    public void User_03_MyAccount(){
        basePage.waitForElementClickable(driver, "//a[@class='ico-account']");
        basePage.clickToElement(driver, "//a[@class='ico-account']");
        Assert.assertTrue(basePage.isElementDisplayed(driver, "//input[@id='gender-male']"));
        Assert.assertEquals(basePage.getElementAttribute(driver, "//input[@id='FirstName']", "value"), "Testing");
        Assert.assertEquals(basePage.getElementAttribute(driver, "//input[@id='LastName']", "value"), "Selenium");
        Assert.assertEquals(basePage.getSelectItemInDropdown(driver, "//select[@name='DateOfBirthDay']"), "10");
        Assert.assertEquals(basePage.getSelectItemInDropdown(driver, "//select[@name='DateOfBirthMonth']"), "May");
        Assert.assertEquals(basePage.getSelectItemInDropdown(driver, "//select[@name='DateOfBirthYear']"), "1995");
        Assert.assertEquals(basePage.getElementAttribute(driver, "//input[@id='Company']", "value"), "Building");

    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }
    public String getEmailAddress(){
        Random rand = new Random();
        return "automation" + rand.nextInt(99999) + "@gmail.net";

    }
}
