package commons;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BasePage {

    public void openPageUrl(WebDriver driver, String url){
        driver.get(url);
    }
    public String getPageTitle(WebDriver driver){
        return driver.getTitle();
    }
    public String getPageUrl (WebDriver driver){
        return  driver.getCurrentUrl();
    }
    public void backToPage(WebDriver driver){
        driver.navigate().back();
    }
    public void forwardToPage(WebDriver driver){
        driver.navigate().forward();
    }
    public void refreshCurrentPage(WebDriver driver){
        driver.navigate().refresh();
    }
    public Alert waitAlertPresence(WebDriver driver){
       return new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.alertIsPresent());
    }
    public void acceptToAlert(WebDriver driver){
        // chi switch k wait
        //driver.switchTo().alert().accept();
        // wait cho xuat hien alert roi switch vao
        waitAlertPresence(driver).accept();
    }
    public void cancelToAlert(WebDriver driver){
       waitAlertPresence(driver).dismiss();
    }
    public String getAlertText(WebDriver driver){
        return waitAlertPresence(driver).getText();
    }
    public void senkyToAlert(WebDriver driver, String keysToSend){
        waitAlertPresence(driver).sendKeys(keysToSend);
    }
    public void switchToWindowByID(WebDriver driver, String parentID){
        Set<String> allID = driver.getWindowHandles();
        for(String id: allID){
            if(!id.equals(parentID)){
                driver.switchTo().window(id);
                break;
            }
        }
    }

    public void switchToWindowByTitle(WebDriver driver, String title){
        Set<String> allID = driver.getWindowHandles();
        for(String id: allID){
            driver.switchTo().window(id);
            String currentWin = driver.getTitle();
            if(currentWin.equals(title)){
                break;
            }
        }
    }
    public void closeAllWindowByID(WebDriver driver, String parentID){
        Set<String> allID = driver.getWindowHandles();
        for(String id: allID){
            if(!id.equals(parentID)){
                driver.switchTo().window(id);
                driver.close();
            }
        }
        driver.switchTo().window(parentID);
    }
    public WebElement getElement(WebDriver driver, String locator){
        return driver.findElement(By.xpath(locator));
    }
    public void clickToElement(WebDriver driver, String locator){
        getElement(driver,locator).click();
    }
    public void sendkeyToElement(WebDriver driver, String locator, String key){
        getElement(driver,locator).sendKeys(key);
    }
    public void selectItemInDropdown(WebDriver driver, String locator, String item){
        new Select(getElement(driver,locator)).selectByVisibleText(item);
    }
    public String getSelectItemInDropdown(WebDriver driver, String locator){
        return new Select(getElement(driver,locator)).getFirstSelectedOption().getText();
    }
    public boolean isDropdownMultiple(WebDriver driver, String locator){
        return new Select(getElement(driver,locator)).isMultiple();
    }
    public void selectItemInDropdown(WebDriver driver, String parentCLocator, String childItemCss, String iTemTextExpected) {
        getElement(driver,parentCLocator).click();
        sleepSeconds(3);
        List<WebElement> allItem = new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childItemCss)));
        for (WebElement item : allItem) {
            if (item.getText().trim().equals(iTemTextExpected)) {
                item.click();
                break;
            }
        }
    }

    public void sleepSeconds(long timeInsecond) {
        try {
            Thread.sleep(timeInsecond *1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
