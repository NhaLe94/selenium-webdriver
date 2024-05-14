package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_13_Actions {

    WebDriver driver;
    Actions actions;
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
        actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }
    @Test
    public void TC_01_Hover_Tooltip() {
        driver.get("https://automationfc.github.io/jquery-tooltip/");

        WebElement ageText = driver.findElement(By.cssSelector("input#age"));
        actions.moveToElement(ageText).perform();
        sleepSeconds(3);
        Assert.assertEquals(driver.findElement(By.cssSelector("div.ui-tooltip-content")).getText(),"We ask for your age only for statistical purposes.");
    }
    @Test
    public void TC_02_Hover_Tooltip_FormStone(){
        driver.get("https://formstone.it/components/tooltip/");
        WebElement leftText = driver.findElement(By.xpath("//div[text()='Left']"));
        actions.moveToElement(leftText).perform();
        sleepSeconds(2);
        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Left Tooltip']")).isDisplayed());
    }

    @Test
    public void TC_03_Hover_Tooltip_Telerik(){
        driver.get("https://demos.telerik.com/kendo-ui/tooltip/index");
        sleepSeconds(3);

        WebElement imgText = driver.findElement(By.cssSelector("span#moscow"));
        actions.moveToElement(imgText).perform();
        sleepSeconds(2);
        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Moscow - 16,200,000']")).isDisplayed());
    }

    @Test
    public void TC_04_Hover_Menu_Fahasa() {
        driver.get("https://www.fahasa.com/");

        actions.moveToElement(driver.findElement(By.cssSelector("span.icon_menu"))).perform();
        sleepSeconds(2);

        actions.moveToElement(driver.findElement(By.xpath("//a[@title='Bách Hóa Online - Lưu Niệm']"))).perform();
        sleepSeconds(2);

        driver.findElement(By.xpath("//div[contains(@class,'fhs_menu_content')]//a[text()='Thiết Bị Số - Phụ Kiện Số']")).click();
        sleepSeconds(2);

        Assert.assertEquals(driver.findElement(By.cssSelector("ol.breadcrumb strong")).getText(),"THIẾT BỊ SỐ - PHỤ KIỆN SỐ");
    }

    @Test
    public void TC_05_ClickAndHold() {
        driver.get("https://automationfc.github.io/jquery-selectable/");
        List<WebElement> allNumbers = driver.findElements(By.cssSelector("li.ui-state-default"));
        Assert.assertEquals(allNumbers.size(), 20);

    }

    @Test
    public void TC_06_DoubleClick() {
        driver.get("https://automationfc.github.io/basic-form/");
        actions.doubleClick(driver.findElement(By.xpath("//button[text()='Double click me']"))).perform();
        sleepSeconds(1);
        Assert.assertEquals(driver.findElement(By.cssSelector("p#demo")).getText(),"Hello Automation Guys!");

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
