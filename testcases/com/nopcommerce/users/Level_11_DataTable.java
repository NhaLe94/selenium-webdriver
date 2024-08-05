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

   // @Test
    public void Table_01() {
        homepage.openPageNumber("5");
        Assert.assertTrue(homepage.isNumberActived("5"));
        homepage.openPageNumber("10");
        Assert.assertTrue(homepage.isNumberActived("10"));
        homepage.openPageNumber("8");
        Assert.assertTrue(homepage.isNumberActived("8"));
        homepage.openPageNumber("1");
        Assert.assertTrue(homepage.isNumberActived("1"));

    }

 //   @Test
    public void Table_02_Search() {
     homepage.enterToTextboxByHeaderName("Country", "Argentina");
     homepage.sleepSeconds(2);
     Assert.assertTrue(homepage.isRowDataValueDisplayed("338282", "Argentina", "349238", "687522"));
     homepage.refreshCurrentPage(driver);
     homepage.enterToTextboxByHeaderName("Males", "803");
     homepage.sleepSeconds(2);
     Assert.assertTrue(homepage.isRowDataValueDisplayed("777", "Antigua and Barbuda", "803", "1580"));
     homepage.refreshCurrentPage(driver);
     homepage.enterToTextboxByHeaderName("Females", "384187");
     homepage.sleepSeconds(2);
     Assert.assertTrue(homepage.isRowDataValueDisplayed("384187", "Afghanistan", "407124", "791312"));
     homepage.refreshCurrentPage(driver);

    }
   // @Test
    public void Table_03_Edit() {
        homepage.enterToTextboxByHeaderName("Country", "Argentina");
        homepage.sleepSeconds(2);
        homepage.deleteRowByCountryName("Argentina");
        homepage.refreshCurrentPage(driver);

        homepage.enterToTextboxByHeaderName("Country", "Angola");
        homepage.sleepSeconds(2);
        homepage.editRowByCountryName("Angola");
    }
    @Test
    public void Table_04_Get_All_Value_Row_Or_Column() {
        homepage.getAllValueAtColumnName("Country");
        homepage.getAllValueAtColumnName("Females");


    }
   // @Test
    public void Table_04_Action_By_Index() {
        homepage.openPageUrl(driver, "https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
        homepage.clickToLoadDataButton();
        homepage.enterToTextboxByIndex("2", "Company", "ABZ Company");

        homepage.sleepSeconds(2);
        homepage.enterToTextboxByIndex("4", "Contact Person", "Michael");

        homepage.selectToDropdownByIndex("6","Country", "Hong Kong");
        homepage.checkToCheckboxByIndex("6","NPO?", true);
        homepage.checkToCheckboxByIndex("5","NPO?", false);
        homepage.clickToIconByIndex("8", "Move Up");
        homepage.clickToIconByIndex("6", "Remove");
        homepage.clickToIconByIndex("4", "Insert");


    }


    @AfterClass
    public void afterClass() {
       // driver.quit();
    }
}
