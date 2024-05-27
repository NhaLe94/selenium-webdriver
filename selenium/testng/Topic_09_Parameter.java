package testng;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;


public class Topic_09_Parameter {

    WebDriver driver;
    By emailTextbox = By.xpath("//*[@id='email']");
    By passwordTextbox = By.xpath("//*[@id='pass']");
    By loginButton = By.xpath("//*[@id='send2']");

    @Parameters({"browser", "version"})
    @BeforeClass
    public void beforeClass(String browserName, String browserVersion){

        if(browserName.equals("firefox")){
            driver = new FirefoxDriver();
        } else if(browserName.equals("chrome")){
            driver = new ChromeDriver();
        }else if(browserName.equals("edge")){
            driver = new EdgeDriver();
        }else {
            throw  new RuntimeException("Browser name is not valid");
        }
        System.out.println("Browser" + browserName + "with version" + browserVersion);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void test_01_Login(){
        driver.get("http://live.techpanda.org/index.php/customer/account/login/");
        driver.findElement(emailTextbox).sendKeys("selenium_11_01@gmail.com");
        driver.findElement(passwordTextbox).sendKeys("111111");
        System.out.println("Age" + "23");
        driver.findElement(loginButton).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='col-1']//p")).getText().contains("selenium_11_01@gmail.com"));

        driver.findElement(By.xpath("//header[@id='header']//span[text()='Account']")).click();
        driver.findElement(By.xpath("//a[text()='Log Out']")).click();


    }

    public Object [][] UserAndPassworData(){
        return new Object[][]{
                {"selenium_11_01@gmail.com", "111111", 20},
                {"selenium_11_01@gmail.com", "111111", 20},
                {"selenium_11_01@gmail.com", "111111", 20}
        };
    }

    @AfterClass
    public void after(){
        driver.quit();
    }
}
