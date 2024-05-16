package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_14_Popup {

    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass() {

        if (osName.contains("Windows")) {
            System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
        }

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void TC_01_Fixed_Popup_In_DOM() {
        driver.get("https://ngoaingu24h.vn/");
        driver.findElement(By.cssSelector("button.login_")).click();
        By loginPopup = By.cssSelector("div[id='modal-login-v1'][style]>div");

        Assert.assertTrue(driver.findElement((loginPopup)).isDisplayed());

        driver.findElement(By.cssSelector("div[id='modal-login-v1'][style]>div input#account-input")).sendKeys("Testing");
        driver.findElement(By.cssSelector("div[id='modal-login-v1'][style]>div input#password-input")).sendKeys("Testing");
        driver.findElement(By.cssSelector("div[id='modal-login-v1'][style]>div button.btn-login-v1")).click();
        sleepSeconds(2);
        Assert.assertEquals(driver.findElement(By.cssSelector("div[id='modal-login-v1'][style]>div div.error-login-panel")).getText(),"Tài khoản không tồn tại!");
        driver.findElement(By.cssSelector("div[id='modal-login-v1'][style]>div button.close")).click();
        sleepSeconds(2);

        Assert.assertFalse(driver.findElement((loginPopup)).isDisplayed());

    }

    @Test
    public void TC_02_Fixed_Popup_In_DOM_02() {
        driver.get("https://ngoaingu24h.vn/");
        driver.findElement(By.cssSelector("button.signin_")).click();
        By registerPopup = By.cssSelector("div[id='modal-register-v1'][style]>div");

        Assert.assertTrue(driver.findElement((registerPopup)).isDisplayed());
        driver.findElement(By.cssSelector("div[id='modal-register-v1'][style]>div button.btn-register-v1")).click();
        sleepSeconds(2);
        Assert.assertEquals(driver.findElement(By.cssSelector("div[id='modal-register-v1'][style]>div div.error-login-panel")).getText(),"Tên tài khoản không hợp lệ");
        driver.findElement(By.cssSelector("div[id='modal-register-v1'][style]>div button.close")).click();
        sleepSeconds(2);
        Assert.assertFalse(driver.findElement((registerPopup)).isDisplayed());

    }

    @Test
    public void TC_03_Fixed_Popup_Not_In_DOM_03() {
        driver.get("https://tiki.vn/");
        driver.findElement(By.xpath("//span[text()='Tài khoản']")).click();
        By registerPopup = By.xpath("//div[contains(@class,'ReactModal__Content')]/div");
        Assert.assertTrue(driver.findElement(registerPopup).isDisplayed());
        driver.findElement(By.xpath("//button[text()='Tiếp Tục']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//span[@class='error-mess']")).getText(),"Số điện thoại không được để trống");
        driver.findElement(By.cssSelector("button.btn-close")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertEquals(driver.findElements(By.xpath("//div[contains(@class,'ReactModal__Content')]/div")).size(),0);
    }
    @Test
    public void TC_04_Fixed_Popup_Not_In_DOM_04() {
        driver.get("https://www.facebook.com/");
        driver.findElement(By.xpath("//a[text()='Create new account']")).click();
        By registerPopup = By.xpath("//div[text()='Sign Up']/parent::div/parent::div");
        Assert.assertTrue(driver.findElement(registerPopup).isDisplayed());
        sleepSeconds(2);

        driver.findElement(By.xpath("//div[text()='Sign Up']/parent::div/preceding-sibling::img")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertEquals(driver.findElements(By.xpath("//div[text()='Sign Up']/parent::div/parent::div")).size(),0);
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
