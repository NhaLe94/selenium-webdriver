package pageObjects.jquery;

import commons.BasePage;
import org.openqa.selenium.Keys;
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

    public void enterToTextboxByHeaderName(String headerName, String valueToSendkey) {
        waitForElementVisible(driver, HomePageUI.DYNAMIC_TEXTBOX_HEADER_NAME, headerName);
        sendkeyToElement(driver, HomePageUI.DYNAMIC_TEXTBOX_HEADER_NAME, valueToSendkey,headerName);
        pressKeyToElement(driver, HomePageUI.DYNAMIC_TEXTBOX_HEADER_NAME, Keys.ENTER, headerName);
    }

    public boolean isRowDataValueDisplayed(String female, String country, String male, String total) {
        waitForElementVisible(driver, HomePageUI.DYNAMIC_DATA_ROW, female, country, male, total);
        return isElementDisplayed(driver, HomePageUI.DYNAMIC_DATA_ROW, female, country, male, total);
    }

    public void deleteRowByCountryName(String countryName) {
        waitForElementClickable(driver, HomePageUI.DYNAMIC_DELETE_BUTTON_BY_COUNTRY_NAME, countryName);
        clickToElement(driver, HomePageUI.DYNAMIC_DELETE_BUTTON_BY_COUNTRY_NAME, countryName);
        sleepSeconds(2);

    }

    public void editRowByCountryName(String countryName) {
        waitForElementClickable(driver, HomePageUI.DYNAMIC_EDIT_BUTTON_BY_COUNTRY_NAME, countryName);
        clickToElement(driver, HomePageUI.DYNAMIC_EDIT_BUTTON_BY_COUNTRY_NAME, countryName);
        sleepSeconds(2);

    }
}
