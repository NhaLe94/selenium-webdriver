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
import java.util.List;

public class Topic_21_UploadFiles {

    WebDriver driver;
    String projectPath = System.getProperty("user.dir");

    String cat1 = "cat-01.jpg";
    String cat2 = "cat-02.jpg";
    String cat3 = "cat-03.jpg";
    String cat1FilePath = projectPath + "\\uploadFiles\\" + cat1;
    String cat2FilePath = projectPath + "\\uploadFiles\\" + cat2;
    String cat3FilePath = projectPath + "\\uploadFiles\\" + cat3;

    @BeforeClass
    public void beforeClass() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }

    @Test
    public void TC_01_Url() {
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");
       
//        WebElement addFileButton = driver.findElement(By.xpath("//input[@type='file']"));
//        addFileButton.sendKeys(cat1FilePath);
        By addFileButton = By.xpath("//input[@type='file']");
        driver.findElement(addFileButton).sendKeys(cat1FilePath);
        sleepSeconds(2);
        driver.findElement(addFileButton).sendKeys(cat2FilePath);
        sleepSeconds(2);
        driver.findElement(addFileButton).sendKeys(cat3FilePath);
        sleepSeconds(2);
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + cat1 + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + cat2 + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + cat3 + "']")).isDisplayed());
        List<WebElement> startButton = driver.findElements(By.cssSelector("td>button.start"));
        for(WebElement button : startButton){
            button.click();
            sleepSeconds(2);
        }
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='" + cat1 + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='" + cat2 + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='" + cat3 + "']")).isDisplayed());

    }

    @Test
    public void TC_02_Logo() {
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");

        By addFileButton = By.xpath("//input[@type='file']");
        driver.findElement(addFileButton).sendKeys(cat1FilePath + "\n" + cat2FilePath + "\n" + cat3FilePath);
        sleepSeconds(2);
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + cat1 + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + cat2 + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + cat3 + "']")).isDisplayed());
        List<WebElement> startButton = driver.findElements(By.cssSelector("td>button.start"));
        for(WebElement button : startButton){
            button.click();
            sleepSeconds(2);
        }
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='" + cat1 + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='" + cat2 + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='" + cat3 + "']")).isDisplayed());


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
