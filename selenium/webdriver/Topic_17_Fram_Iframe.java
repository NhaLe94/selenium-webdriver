package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Topic_17_Fram_Iframe {

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }

    @Test
    public void TC_01_Example_With_Single_Iframe() {
        driver.get("https://demo.automationtesting.in/Frames.html");
        Assert.assertTrue(driver.findElement(By.cssSelector("li.active>a.analystic")).isDisplayed());
        WebElement formIframe = driver.findElement(By.cssSelector("div#Single>iframe"));

        Assert.assertTrue(formIframe.isDisplayed());
        driver.switchTo().frame(formIframe);
        Assert.assertEquals(driver.findElement(By.cssSelector("div.container>h5")).getText(),"iFrame Demo");
        driver.findElement(By.cssSelector("input[type='text']")).sendKeys("testing");
        sleepSeconds(2);
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//a[text()='Register']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div.container>h2")).getText(),"Register");


    }

    @Test
    public void TC_02_Example_With_Multiple_Iframe() {
        driver.get("https://demo.automationtesting.in/Frames.html");
        driver.findElement(By.xpath("//a[text()='Iframe with in an Iframe']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//li/child::a[text()='Iframe with in an Iframe']")).isDisplayed());
        sleepSeconds(2);
        WebElement iframeParent = driver.findElement(By.cssSelector("div#Multiple>iframe"));
        Assert.assertTrue(iframeParent.isDisplayed());
        driver.switchTo().frame(iframeParent);
        Assert.assertEquals(driver.findElement(By.cssSelector("div.iframe-container>h5")).getText(),"Nested iFrames");
        WebElement iframeChild = driver.findElement(By.cssSelector("div.iframes-page-container iframe"));
        Assert.assertTrue(iframeChild.isDisplayed());
        driver.switchTo().frame(iframeChild);

        Assert.assertEquals(driver.findElement(By.cssSelector("div.container>h5")).getText(),"iFrame Demo");
        driver.findElement(By.cssSelector("input[type='text']")).sendKeys("iframe child");sleepSeconds(2);

        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//a[text()='Register']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div.container>h2")).getText(),"Register");


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
