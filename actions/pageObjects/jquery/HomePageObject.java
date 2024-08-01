package pageObjects.jquery;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.jquery.HomePageUI;

public class HomePageObject extends BasePage {
    WebDriver driver;
    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }


    public void openPageNumber(String pageNumber) {
        waitForElementClickable(driver, HomePageUI.DYNAMIC_PAGE_LINK, pageNumber);
        clickToElement(driver, HomePageUI.DYNAMIC_PAGE_LINK, pageNumber);
        sleepSeconds(3);
        //return PageGenerator.getHomePage(driver);
    }

    public boolean isNumberActived(String pageNumber) {
        waitForElementVisible(driver, HomePageUI.DYNAMIC_PAGE_LINK, pageNumber);
        return getElementAttribute(driver, HomePageUI.DYNAMIC_PAGE_LINK,"class", pageNumber).endsWith("active");
    }
}
