package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.nopecomerce.PageGenerator;
import pageObjects.nopecomerce.users.UserAddressPageObject;
import pageObjects.nopecomerce.users.UserCustomerInfoPageObject;
import pageObjects.nopecomerce.users.UserOrderPageObject;
import pageObjects.nopecomerce.users.UserRewardPointPageObject;
import pageUIs.nopCommerce.BasePageUI;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BasePage {
    public static BasePage getBasePage(){
        return new BasePage();
    }

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
        return driver.findElement(getByLocator(locator));
    }
    public WebElement getElement(WebDriver driver, String locator, String... restParameter){
        return driver.findElement(getByLocator(castParameter(locator, restParameter)));
    }
    protected List<WebElement> getListElement(WebDriver driver, String locator){
        return driver.findElements(getByLocator(locator));
    }
    protected List<WebElement> getListElement(WebDriver driver, String locator, String... restParameter){
        return driver.findElements(getByLocator(castParameter(locator, restParameter)));
    }

    public By getByXpath(String locator){
        return By.xpath(locator);
    }
    private String castParameter(String locator, String... restParameter){
        return String.format(locator, (Object[]) restParameter);
    }
    public By getByLocator(String prefixLocator){
        By by = null;
        if(prefixLocator.toLowerCase().startsWith("css")){
            by = By.cssSelector(prefixLocator.substring(4));
        }
        else if(prefixLocator.toLowerCase().startsWith("id")){
            by = By.id(prefixLocator.substring(3));
        }
        else if(prefixLocator.toLowerCase().startsWith("name")){
            by = By.name(prefixLocator.substring(5));
        }
        else if(prefixLocator.toLowerCase().startsWith("tagname")){
            by = By.tagName(prefixLocator.substring(8));
        }
        else if(prefixLocator.toLowerCase().startsWith("xpath")){
            by = By.xpath(prefixLocator.substring(6));
        }
        else if(prefixLocator.toLowerCase().startsWith("class") ){
            by = By.className(prefixLocator.substring(6));
        }
         else {
            throw  new RuntimeException("Locator type is not support");
        }
        return by;
    }
    public void clickToElement(WebDriver driver, String locator){
        getElement(driver,locator).click();
    }

    public void clickToElement(WebDriver driver, String locator, String... restParameter){
        getElement(driver,castParameter(locator, restParameter)).click();
    }
    public void sendkeyToElement(WebDriver driver, String locator, String key){
        getElement(driver,locator).sendKeys(key);
    }
    public void sendkeyToElement(WebDriver driver, String locator,String key, String... restParameter){
        getElement(driver,castParameter(locator, restParameter)).clear();
        getElement(driver,castParameter(locator, restParameter)).sendKeys(key);
    }

    public void selectItemInDropdown(WebDriver driver, String locator, String item){
        new Select(getElement(driver,locator)).selectByVisibleText(item);
    }
    public void selectItemInDropdown(WebDriver driver, String locator, String item, String... restParameter){
        new Select(getElement(driver,castParameter(locator, restParameter))).selectByVisibleText(item);
    }
    public String getSelectItemInDropdown(WebDriver driver, String locator){
        return new Select(getElement(driver,locator)).getFirstSelectedOption().getText();
    }
    public boolean isDropdownMultiple(WebDriver driver, String locator){
        return new Select(getElement(driver,locator)).isMultiple();
    }
    public void selectItemInCustomDropdown(WebDriver driver, String parentCLocator, String childItemCss, String iTemTextExpected) {
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
    public String getElementAttribute(WebDriver driver, String locator, String attributeName){
        return getElement(driver, locator).getAttribute(attributeName);
    }
    public String getElementAttribute(WebDriver driver, String locator, String attributeName, String restParameter){
        return getElement(driver, castParameter(locator, restParameter)).getAttribute(attributeName);
    }
    public String getElementText(WebDriver driver, String locator){
        return getElement(driver, locator).getText();
    }
    public String getElementText(WebDriver driver, String locator,  String... restParameter){
        return getElement(driver, castParameter(locator, restParameter)).getText();
    }
    public void getElementCssValue(WebDriver driver, String locator, String propertyName){
        getElement(driver, locator).getCssValue(propertyName);
    }
    public String getHexaColorFromRGBA( String rgbaValue){
        return Color.fromString(rgbaValue).asHex().toUpperCase();
    }
    public int getListElementNumber(WebDriver driver, String locator){
        return getListElement(driver, locator).size();
    }
    public void checkToCheckboxRadio(WebDriver driver, String locator){
        if(!getElement(driver, locator).isSelected()){
            getElement(driver, locator).click();
        }
    }
    public void checkToCheckboxRadio(WebDriver driver, String locator, String... restParameter){
        if(!getElement(driver, castParameter(locator, restParameter)).isSelected()){
            getElement(driver, castParameter(locator, restParameter)).click();
        }
    }
    public void uncheckToCheckboxRadio(WebDriver driver, String locator){
        if(getElement(driver, locator).isSelected()){
            getElement(driver, locator).click();
        }
    }
    public void uncheckToCheckboxRadio(WebDriver driver, String locator, String... restParameter){
        if(getElement(driver, castParameter(locator, restParameter)).isSelected()){
            getElement(driver, castParameter(locator, restParameter)).click();
        }
    }
    public boolean isElementDisplayed(WebDriver driver, String locator){
        return getElement(driver, locator).isDisplayed();
    }
    public boolean isElementDisplayed(WebDriver driver, String locator, String... restParameter){
        return getElement(driver, castParameter(locator, restParameter)).isDisplayed();
    }
    public boolean isElementEnabled(WebDriver driver, String locator){
        return getElement(driver, locator).isEnabled();
    }
    public boolean isElementSelected(WebDriver driver, String locator){
        return getElement(driver, locator).isSelected();
    }
    public boolean isElementSelected(WebDriver driver, String locator, String restParameter){
        return getElement(driver, castParameter(locator, restParameter)).isSelected();
    }
    public void switchToIframe(WebDriver driver, String locator){
        driver.switchTo().frame(getElement(driver, locator));
    }
    public void switchToDefault(WebDriver driver){
        driver.switchTo().defaultContent();
    }
    public void hoverToElement(WebDriver driver, String locator){
        new Actions(driver).moveToElement(getElement(driver, locator)).perform();
    }
    public void clickToElementByAction(WebDriver driver, String locator){
        new Actions(driver).click(getElement(driver, locator)).perform();
    }
    public void clickAndHoldToElement(WebDriver driver, String locator){
        new Actions(driver).clickAndHold(getElement(driver, locator)).perform();
    }
    public void releaseLeftMouse(WebDriver driver){
        new Actions(driver).release();
    }
    public void doubleClickToElement(WebDriver driver, String locator){
        new Actions(driver).doubleClick(getElement(driver, locator)).perform();
    }
    public void rightClickToElement(WebDriver driver, String locator){
        new Actions(driver).contextClick(getElement(driver, locator)).perform();
    }
    public void dragAndDropElement(WebDriver driver, String sourceLocator, String targetLocator){
        new Actions(driver).dragAndDrop(getElement(driver, sourceLocator), getElement(driver, targetLocator)).perform();
    }
    public void pressKeyToElement(WebDriver driver, String locator, Keys keys){
        new Actions(driver).sendKeys(getElement(driver, locator), keys).perform();
    }
    public void pressKeyToElement(WebDriver driver, String locator, Keys keys, String restParameter){
        new Actions(driver).sendKeys(getElement(driver, castParameter(locator, restParameter)), keys).perform();
    }
    public void scrollToElement(WebDriver driver, String locator){
        new Actions(driver).scrollToElement(getElement(driver, locator)).perform();
    }
    public void scrollToBottomPage(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void navigateToUrlByJS(WebDriver driver,String url) {
        ((JavascriptExecutor) driver).executeScript("window.location = '" + url + "'");
        sleepSeconds(3);
    }

    public void hightlightElement(WebDriver driver,String locator) {
        WebElement element = getElement(driver,locator);
        String originalStyle = element.getAttribute("style");
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
        sleepSeconds(2);
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }

    public void clickToElementByJS(WebDriver driver,String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getElement(driver,locator));
        sleepSeconds(3);
    }

    public void scrollToElementOnTop(WebDriver driver,String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getElement(driver,locator));
    }

    public void scrollToElementOnDown(WebDriver driver,String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", getElement(driver,locator));
    }

    public void setAttributeInDOM(WebDriver driver,String locator, String attributeName, String attributeValue) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('" + attributeName + "', '" + attributeValue +"');", getElement(driver,locator));
    }

    public void removeAttributeInDOM(WebDriver driver,String locator, String attributeRemove) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(driver,locator));
    }

    public void sendkeyToElementByJS(WebDriver driver,String locator, String value) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(driver,locator));
    }

    public String getAttributeInDOM(WebDriver driver,String locator, String attributeName) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].getAttribute('" + attributeName + "');", getElement(driver,locator));
    }

    public String getElementValidationMessage(WebDriver driver,String locator) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", getElement(driver,locator));
    }

    public boolean isImageLoaded(WebDriver driver,String locator) {
        return (boolean) ((JavascriptExecutor) driver).executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", getElement(driver,locator));

    }
    public void waitForElementPresence(WebDriver driver, String locator){
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.presenceOfElementLocated(getByXpath(locator)));
    }
    public void waitForElementInvisible(WebDriver driver, String locator){
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
    }
    public void waitForElementClickable(WebDriver driver, String locator){
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.elementToBeClickable(getByLocator(locator)));
    }
    public void waitForElementClickable(WebDriver driver, String locator, String... restParameter){
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.elementToBeClickable(getByLocator(castParameter(locator, restParameter))));
    }
    public void waitForElementVisible(WebDriver driver, String locator){
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
    }
    public void waitForElementVisible(WebDriver driver, String locator, String... restParameter){
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(castParameter(locator, restParameter))));
    }
    public void waitForElementSelected(WebDriver driver, String locator){
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.elementToBeSelected(getByLocator(locator)));
    }
    public void waitForElementSelected(WebDriver driver, String locator, String... restParameter){
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.elementToBeSelected(getByLocator(castParameter(locator, restParameter))));
    }
    public UserAddressPageObject openAddressPage(WebDriver driver) {
        waitForElementClickable(driver, BasePageUI.ADDRESS_LINK);
        clickToElement(driver, BasePageUI.ADDRESS_LINK);
        return PageGenerator.getAddressPage(driver);
    }
    public UserRewardPointPageObject openRewardPointPage(WebDriver driver) {
        waitForElementClickable(driver, BasePageUI.REWARD_POINT_LINK);
        clickToElement(driver, BasePageUI.REWARD_POINT_LINK);
        return PageGenerator.getRewardPoint(driver);
    }

    public UserCustomerInfoPageObject openCustomerInfoPage(WebDriver driver) {
        waitForElementClickable(driver,BasePageUI.CUSTOMER_INFO_LINK );
        clickToElement(driver,BasePageUI.CUSTOMER_INFO_LINK );
        return PageGenerator.getCustomerInfoPage(driver);
    }
    public UserOrderPageObject openOrderPage(WebDriver driver) {
        waitForElementClickable(driver, BasePageUI.ORDER_LINK);
        clickToElement(driver, BasePageUI.ORDER_LINK);
        return PageGenerator.getOrderPage(driver);
    }


    public void openAdminSite(WebDriver driver,String adminUrl) {
        openPageUrl(driver, adminUrl);
    }

    public void openUserSite(WebDriver driver,String userUrl) {
        openPageUrl(driver, userUrl);
    }
}
