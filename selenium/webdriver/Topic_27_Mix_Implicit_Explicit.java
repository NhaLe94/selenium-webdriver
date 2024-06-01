package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;



public class Topic_27_Mix_Implicit_Explicit {

    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Only_Implicit_Found() {
        driver.get("https://www.facebook.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.cssSelector("input#email"));

    }

    @Test
    public void TC_02_Only_Implicit_Not_Found() {
        driver.get("https://www.facebook.com/");
        // khi vao k tim thay element
        //polling moi nua giay tim lai mot lan
        //khi het timout se danh fail tcs va throw exception NoSuchElement
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.cssSelector("input#email1"));

    }

    @Test
    public void TC_03_Only_Explicit_Found() {
        driver.get("https://www.facebook.com/");
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#email")));

    }

    @Test
    public void TC_04_Only_Explicit_Not_Found() {
        driver.get("https://www.facebook.com/");
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        // khi vao k tim thay element
        //polling moi nua giay tim lai mot lan
        //khi het timout se danh fail tcs va throw exception Timeout
        //TimeoutException: Expected condition failed: waiting for visibility of element located by By.cssSelector: input#email1
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#email1")));

    }

    @Test
    public void TC_05_Only_Explicit_Not_Found() {
        driver.get("https://www.facebook.com/");
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        // khi vao k tim thay element
        //polling moi nua giay tim lai mot lan
        //khi het timout se danh fail tcs va throw exception Timeout
        //TimeoutException: Expected condition failed: waiting for visibility of element located by By.cssSelector: input#email1
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#email1")));

    }
    @Test
    public void TC_06_Mix(){
        driver.get("https://www.facebook.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));

        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#email1")));

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
