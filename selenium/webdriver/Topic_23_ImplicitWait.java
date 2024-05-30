package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Topic_23_ImplicitWait {

    WebDriver driver;


    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));

        driver.manage().window().maximize();

    }

    @Test
    public void TC_01_Equal_5_Second() {
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://automationfc.github.io/dynamic-loading/");
        driver.findElement(By.cssSelector("div#start>button")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(),"Hello World!");

    }
    @Test
    public void TC_02_Less_Than_5_Second() {
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://automationfc.github.io/dynamic-loading/");
        driver.findElement(By.cssSelector("div#start>button")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(),"Hello World!");

    }

    @Test
    public void TC_03_Greater_Than_5_Second() {
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://automationfc.github.io/dynamic-loading/");
        driver.findElement(By.cssSelector("div#start>button")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(),"Hello World!");

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
