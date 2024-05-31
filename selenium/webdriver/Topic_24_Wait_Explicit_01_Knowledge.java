package webdriver;

import org.openqa.selenium.Alert;
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

public class Topic_24_Wait_Explicit_01_Knowledge {

    WebDriver driver;
    WebDriverWait explicitWait;


    @BeforeClass
    public void beforeClass() {

        driver = new ChromeDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }

    @Test
    public void TC_01_Url() {
        //Cho cho 1 alert present trong html/dom truoc khi thao tac len
        Alert alert =  explicitWait.until(ExpectedConditions.alertIsPresent());
        // cho cho element k con o trong dom
        explicitWait.until(ExpectedConditions.stalenessOf(driver.findElement(By.cssSelector(""))));

        // cho cho element  co trong dom(k quan tam co tren UI k)
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("")));

        // cho cho 1 list element co trong dom
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("")));

        //
        explicitWait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(By.cssSelector(""), By.cssSelector("")));

        //
       // explicitWait.until(ExpectedConditions)




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
