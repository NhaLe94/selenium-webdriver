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

public class Level_02_BasePage_III_Inheritance extends BasePage{

    WebDriver driver;
    String firstName , lastName , emailAddress , password, companyName, day,month , year ;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();

        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        emailAddress = "nhale" + getEmailAddress();
    }

    @Test
    public void User_01_Register() {
        waitForElementClickable(driver, "//a[@class='ico-register']");
        clickToElement(driver, "//a[@class='ico-register']");
        waitForElementClickable(driver, "//input[@id='gender-male']");
        clickToElement(driver, "//input[@id='gender-male']");
        
        sendkeyToElement(driver,"//input[@id='FirstName']", "Testing");
        sendkeyToElement(driver,"//input[@id='LastName']", "Selenium");
        selectItemInDropdown(driver, "//select[@name='DateOfBirthDay']", "10");
        selectItemInDropdown(driver, "//select[@name='DateOfBirthMonth']", "May");
        selectItemInDropdown(driver, "//select[@name='DateOfBirthYear']", "1995");
        sendkeyToElement(driver,"//input[@id='Email']", emailAddress);
        sendkeyToElement(driver,"//input[@id='Company']", "Building");
        sendkeyToElement(driver,"//input[@id='Password']", "123456");
        sendkeyToElement(driver,"//input[@id='ConfirmPassword']", "123456");
        waitForElementClickable(driver, "//button[@id='register-button']");
        clickToElement(driver, "//button[@id='register-button']");
        Assert.assertEquals(getElementText(driver, "//div[@class='result']"), "Your registration completed");

        waitForElementClickable(driver, "//a[@class='ico-logout']");
        clickToElement(driver, "//a[@class='ico-logout']");

    }

    @Test
    public void User_02_Login() {

        waitForElementClickable(driver, "//a[@class='ico-login']");
        clickToElement(driver, "//a[@class='ico-login']");
        sendkeyToElement(driver,"//input[@id='Email']", emailAddress);
        sendkeyToElement(driver,"//input[@id='Password']", "123456");
        waitForElementClickable(driver, "//button[contains(@class,'login-button')]");
        clickToElement(driver, "//button[contains(@class,'login-button')]");
        Assert.assertTrue(isElementDisplayed(driver, "//a[@class='ico-account' and text()='My account']"));

    }
    @Test
    public void User_03_MyAccount(){
        waitForElementClickable(driver, "//a[@class='ico-account']");
        clickToElement(driver, "//a[@class='ico-account']");
        Assert.assertTrue(isElementDisplayed(driver, "//input[@id='gender-male']"));
        Assert.assertEquals(getElementAttribute(driver, "//input[@id='FirstName']", "value"), "Testing");
        Assert.assertEquals(getElementAttribute(driver, "//input[@id='LastName']", "value"), "Selenium");
        Assert.assertEquals(getSelectItemInDropdown(driver, "//select[@name='DateOfBirthDay']"), "10");
        Assert.assertEquals(getSelectItemInDropdown(driver, "//select[@name='DateOfBirthMonth']"), "May");
        Assert.assertEquals(getSelectItemInDropdown(driver, "//select[@name='DateOfBirthYear']"), "1995");
        Assert.assertEquals(getElementAttribute(driver, "//input[@id='Company']", "value"), "Building");

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
