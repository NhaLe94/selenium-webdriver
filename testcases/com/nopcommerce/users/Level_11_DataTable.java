package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jquery.HomePageObject;
import pageObjects.jquery.PageGenerator;


public class Level_11_DataTable extends BaseTest {

    private WebDriver driver;
    private HomePageObject homepage;


    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {

      //  driver = getBrowserName(browserName);
        driver = getBrowserName(browserName, url);
        homepage = PageGenerator.getHomePage(driver);

    }

    @Test
    public void Table_01() {
        homepage.openPageNumber("5");
        Assert.assertTrue(homepage.isNumberActived("5"));
        homepage.openPageNumber("10");
        Assert.assertTrue(homepage.isNumberActived("10"));
        homepage.openPageNumber("8");
        Assert.assertTrue(homepage.isNumberActived("8"));

    }

    @Test
    public void Table_02() {

    }

    @AfterClass
    public void afterClass() {
       // driver.quit();
    }
}
