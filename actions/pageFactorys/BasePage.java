package pageFactorys;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    public void clickToElement(WebElement element){
        element.click();
    }
    public void sendkeyToElement(WebElement element, String key){
        element.clear();
        element.sendKeys(key);
    }
    public void selectItemInDropdown(WebElement element, String item){
        new Select(element).selectByVisibleText(item);
    }
    public String getSelectItemInDropdown(WebElement element){
        return new Select(element).getFirstSelectedOption().getText();
    }
    public String getElementAttribute(WebElement element, String attributeName){
        return element.getAttribute(attributeName);
    }
    public String getElementText(WebElement element){
        return element.getText();
    }
    public void checkToCheckboxRadio(WebElement element){
        if(!element.isSelected()){
            element.click();
        }
    }
    public boolean isElementDisplayed(WebElement element){
        return element.isDisplayed();
    }
    public boolean isElementSelected(WebElement element){
        return element.isSelected();
    }
    public void clickToElementByAction(WebDriver driver,WebElement element){
        new Actions(driver).click(element).perform();
    }
    public void waitForElementClickable(WebDriver driver, WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(element));
    }
    public void waitForElementVisible(WebDriver driver, WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(element));
    }
    public void waitForElementSelected(WebDriver driver,WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeSelected(element));
    }
}
