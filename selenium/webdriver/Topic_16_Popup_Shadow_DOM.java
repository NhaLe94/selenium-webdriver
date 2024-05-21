package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_16_Popup_Shadow_DOM {

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
    public void TC_01_Shadow() {
        driver.get("https://automationfc.github.io/shadow-dom/");
        sleepSeconds(2);
        WebElement shadowHostElement = driver.findElement(By.cssSelector("div#shadow_host"));
        SearchContext shadowRootContent = shadowHostElement.getShadowRoot();
        String someText = shadowRootContent.findElement(By.cssSelector("span#shadow_content>span")).getText();
        System.out.print(someText);
        Assert.assertEquals(someText, "some text");

        WebElement checkboxShadow = shadowRootContent.findElement(By.cssSelector("input[type='checkbox']"));
        Assert.assertFalse(checkboxShadow.isSelected());
        List<WebElement> allInput = shadowRootContent.findElements(By.cssSelector("input"));
        System.out.println(allInput.size());

        WebElement nestedShadowHostElement =shadowRootContent.findElement(By.cssSelector("div#nested_shadow_host"));
        SearchContext nestedShadowRootContent = nestedShadowHostElement.getShadowRoot();

        String nestedText = nestedShadowRootContent.findElement(By.cssSelector("div#nested_shadow_content>div")).getText();
        Assert.assertEquals(nestedText, "nested text");

    }

    @Test
    public void TC_02_Logo() {


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
