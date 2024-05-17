package webdriver;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.util.concurrent.TimeUnit;

public class Topic_15_Popup_02 {

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
    public void TC_01_Random_Not_In_DOM () {
        driver.get("https://www.javacodegeeks.com/");
        sleepSeconds(20);
        By newsletterPopup = By.cssSelector("div.lepopup-popup-container>div:not([style^='display:none'])");
        // Nếu hiển thị thì nhảy vào close
        if (driver.findElements(newsletterPopup).size()>0 && driver.findElements(newsletterPopup).get(0).isDisplayed()){
            System.out.print("Popup hien thi");
            driver.findElement(By.cssSelector("div.lepopup-popup-container>div:not([style^='display:none']) div.lepopup-element-html-content>a")).click();
            sleepSeconds(3);
        }else{ System.out.print("Popup k hiển thị");}
        driver.findElement(By.cssSelector("input#search-input")).sendKeys("Agile");
        driver.findElement(By.cssSelector("button#search-submit")).click();
        sleepSeconds(3);
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Agile']")).isDisplayed());

    }

    @Test
    public void TC_02_Random_In_DOM() {
        driver.get("https://vnk.edu.vn/");
        sleepSeconds(25);
        By marketingPopup = By.cssSelector("div.tve-leads-conversion-object");
        if(driver.findElement(marketingPopup).isDisplayed()){
            driver.findElement(By.cssSelector("div.tve_ea_thrive_leads_form_close")).click();
            sleepSeconds(2);
            System.out.print("Popup hien thi");
        }
        driver.findElement(By.xpath("//button[text()='Danh sách khóa học']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div.title-content>h1")).getText(),"Lịch Khai Giảng Tháng 05");

    }

    @Test
    public void TC_03_Random_In_DOM_PartakeFoods() {
        driver.get("https://partakefoods.com/");
        sleepSeconds(10);
        By marketingPopup = By.xpath("//div[@data-testid='POPUP']");
        if (driver.findElement(marketingPopup).isDisplayed()){
            driver.findElement(By.cssSelector("button.klaviyo-close-form")).click();
            sleepSeconds(2);
            System.out.print("Popup hien thi");
        }
        driver.findElement(By.xpath("//a[text()='LEARN MORE']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("h1.product__title")).getText(),"Marvel Crunchy Super Hero Sprinkle Mini Cookie Snack Packs");
    }
    @Test
    public void TC_04_Random_BookStore(){
        driver.get("https://www.semicolonchi.com/");
        sleepSeconds(10);
        By discountPopup = By.cssSelector("div.sqs-slide-layer-content");
        if (driver.findElement(discountPopup).isDisplayed()){
            driver.findElement(By.cssSelector("a.sqs-popup-overlay-close")).click();
            sleepSeconds(2);
            System.out.print("Popup hiển thị");
        }
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
