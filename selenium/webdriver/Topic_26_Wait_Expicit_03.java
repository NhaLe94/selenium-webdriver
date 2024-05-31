package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class Topic_26_Wait_Expicit_03 {

    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    WebDriverWait explicitWait;
    String hcmName = "cat-01.jpg";
    String dnName = "cat-02.jpg";
    String hnName = "cat-03.jpg";

    String hcmFilePath = projectPath + File.separator + "uploadFiles" + File.separator +hcmName;
    String dnFilePath = projectPath + File.separator + "uploadFiles" + File.separator +dnName;
    String hnFilePath = projectPath + File.separator + "uploadFiles" + File.separator +hnName;


    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().window().maximize();

    }
    @Test
    public void TC_01_AjaxLoading() {
        driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
        By selectDateBy = By.cssSelector("span#ctl00_ContentPlaceholder1_Label1");
        Assert.assertEquals(driver.findElement(selectDateBy).getText(),"No Selected Dates to display.");
        driver.findElement(By.xpath("//a[text()='10']")).click();
        // cho cho loading icon bien mat
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[id*='RadCalendar1']>div.raDiv")));
        Assert.assertEquals(driver.findElement(selectDateBy).getText(),"Friday, May 10, 2024");

    }

    @Test
    public void TC_02_Upload_File(){
        driver.get("https://gofile.io/welcome");
        // wait+ verify spinner loading biến mất
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.spinner-border"))));
        // wait + click
        explicitWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("a.ajaxLink>button")))).click();
        //Wait wait+ verify spinner loading biến mất
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.spinner-border"))));

        driver.findElement(By.cssSelector("input[type='file']")).sendKeys(hcmFilePath + "\n" + dnFilePath +"\n" + hnFilePath );

        //Wait wait+ verify spinner loading biến mất
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.spinner-border"))));

        // Wait progress bar bien mat
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("div.progress")))));

        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.mainUploadSuccessLink a.ajaxLink"))).click();
        // Wait + verify button play co tai tung hinh dc upload
        Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + hcmName + "']/ancestor::div[contains(@class,'text-md-start')]//following-sibling::div//span[text()='Play']"))).isDisplayed());
        Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + dnName + "']/ancestor::div[contains(@class,'text-md-start')]//following-sibling::div//span[text()='Play']"))).isDisplayed());
        Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + hnName + "']/ancestor::div[contains(@class,'text-md-start')]//following-sibling::div//span[text()='Play']"))).isDisplayed());


    }



    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public void sleepSeconds(long timeInsecond) {
        try {
            Thread.sleep(timeInsecond *1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
