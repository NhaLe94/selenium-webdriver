package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_03_Assert {
    WebDriver driver;
    @Test
    public void test01(){
        String fullName = "Testing";
        Assert.assertEquals(fullName,"Testing");


    }
    private boolean isElementDisplayed(By locator){
        return driver.findElement(locator).isDisplayed();
    }
}
