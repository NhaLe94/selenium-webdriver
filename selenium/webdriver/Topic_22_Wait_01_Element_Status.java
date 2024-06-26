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

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Topic_22_Wait_01_Element_Status {

    WebDriver driver;
    WebDriverWait explicitWait;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");
    By reconfirmEmailTextbox = By.xpath("//input[@name='reg_email_confirmation__']");

    @BeforeClass
    public void beforeClass() {

        if (osName.contains("Windows")) {
            System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
        }

        driver = new ChromeDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }

    @Test
    public void TC_01_Visible() {
        driver.get("https://www.facebook.com/");
        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
        sleepSeconds(3);

        driver.findElement(By.cssSelector("input[name='reg_email__']")).sendKeys("nha@gmail.com");
        sleepSeconds(3);

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(reconfirmEmailTextbox));
        Assert.assertTrue(driver.findElement(reconfirmEmailTextbox).isDisplayed());

    }

    @Test
    public void TC_02_Invisible_In_DOM() {
        driver.get("https://www.facebook.com/");
        // dk 2 element k xuat hien tren UI va van co trong html
        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
        sleepSeconds(3);
        driver.findElement(By.cssSelector("input[name='reg_email__']")).sendKeys("nha@gmail.com");
        driver.findElement(By.cssSelector("input[name='reg_email__")).clear();
        sleepSeconds(3);
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(reconfirmEmailTextbox));
        Assert.assertFalse(driver.findElement(reconfirmEmailTextbox).isDisplayed());

    }

    @Test
    public void TC_03_Invisible_Not_In_DOM() {
        driver.get("https://www.facebook.com/");
        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
        sleepSeconds(3);
        driver.findElement(By.xpath("//div[text()='Sign Up']/parent::div/preceding-sibling::img")).click();
        sleepSeconds(3);
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(reconfirmEmailTextbox));
       // Assert.assertFalse(driver.findElement(reconfirmEmailTextbox).isDisplayed());
    }
    @Test
    public void TC_04_Presence(){
        driver.get("https://www.facebook.com/");
        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
        sleepSeconds(2);
        driver.findElement(By.cssSelector("input[name='reg_email__']")).sendKeys("nha@gmail.com");
        sleepSeconds(2);
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(reconfirmEmailTextbox));
        driver.findElement(By.cssSelector("input[name='reg_email__")).clear();
        sleepSeconds(2);

        explicitWait.until(ExpectedConditions.presenceOfElementLocated(reconfirmEmailTextbox));


    }
    @Test
    public void TC_05_Staleness(){
        driver.get("https://www.facebook.com/");
        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
        sleepSeconds(2);
        WebElement reconfirmEmail = driver.findElement(reconfirmEmailTextbox);
        driver.findElement(By.xpath("//div[text()='Sign Up']/parent::div/preceding-sibling::img")).click();
        sleepSeconds(3);
        explicitWait.until(ExpectedConditions.stalenessOf(reconfirmEmail));

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
