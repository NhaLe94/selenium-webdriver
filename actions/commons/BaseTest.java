package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.Reporter;

import java.time.Duration;
import java.util.Random;

public class BaseTest {
    private WebDriver driver;

    protected WebDriver getBrowserName(String browserName){
        switch (browserName){
            case "edg":
                driver = new EdgeDriver();
                break;
            case "chrome":
                driver = new ChromeDriver();
                break;
            default:
                throw new RuntimeException("Browser name is not valid.");
        }
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        driver.manage().window().maximize();
        return driver;
    }
    protected WebDriver getBrowserName(String browserName, String url){
        switch (browserName){
            case "edg":
                driver = new EdgeDriver();
                break;
            case "chrome":
                driver = new ChromeDriver();
                break;
            default:
                throw new RuntimeException("Browser name is not valid.");
        }
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }
    protected int generateRandomNumber(){
        return new Random().nextInt(99999);

    }
//    protected void assertTrue(boolean condition) {
//        Assert.assertTrue(verifyTrue(condition));
//
//    }
    protected boolean verifyTrue(boolean condition){
        boolean status = true;
        try{
            Assert.assertTrue(condition);

        } catch (Throwable  e){

            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return status;


    }
    protected boolean verifyFalse(boolean condition){
        boolean status = true;
        try{
            Assert.assertFalse(condition);

        } catch (Throwable  e){

             VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return status;
    }
    protected boolean verifyEquals(Object actual, Object expected){
        boolean status = true;
        try{
            Assert.assertEquals(actual, expected);

        } catch (Throwable  e){

            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return status;

    }
}
