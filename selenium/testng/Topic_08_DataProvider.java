package testng;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;


public class Topic_08_DataProvider {

    WebDriver driver;
    By emailTextbox = By.xpath("//*[@id='email']");
    By passwordTextbox = By.xpath("//*[@id='pass']");
    By loginButton = By.xpath("//*[@id='send2']");

    @BeforeClass
    public void beforeClass(){

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test(dataProvider = "loginData")
    public void test_01_LoginToSystem(String username, String password, int age){
        driver.get("http://live.techpanda.org/index.php/customer/account/login/");
        driver.findElement(emailTextbox).sendKeys(username);
        driver.findElement(passwordTextbox).sendKeys(password);
        System.out.println("Age" + age);
        driver.findElement(loginButton).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='col-1']//p")).getText().contains(username));

        driver.findElement(By.xpath("//header[@id='header']//span[text()='Account']")).click();
        driver.findElement(By.xpath("//a[text()='Log Out']")).click();


    }
    @DataProvider(name="loginData")
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
        System.out.println("Post-condition for bellow testcases");
    }
}
