package pageObjects.jquery;

import commons.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.jquery.HomePageUI;

import java.util.ArrayList;
import java.util.List;

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

    public void clickToLoadDataButton() {
        waitForElementClickable(driver, HomePageUI.DYNAMIC_LOAD_DATA_BUTTON);
        clickToElement(driver, HomePageUI.DYNAMIC_LOAD_DATA_BUTTON);
    }

    public void enterToTextboxByIndex(String rowIndex, String columnName, String valueToSendkey) {
        int columnIndexNumber = getListElement(driver, HomePageUI.DYNAMIC_PRECEDING_SIBLING_COLUMN_NUMBER, columnName).size() + 1;
        String colunmIndex = String.valueOf(columnIndexNumber);
        sendkeyToElement(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_ROW_AND_COLUMN_INDEX,valueToSendkey, rowIndex, colunmIndex);

    }

    public void selectToDropdownByIndex(String rowIndex, String columnName, String valueToSelect) {
        int columnIndexNumber = getListElement(driver, HomePageUI.DYNAMIC_PRECEDING_SIBLING_COLUMN_NUMBER, columnName).size() + 1;
        String colunmIndex = String.valueOf(columnIndexNumber);
        selectItemInDropdown(driver, HomePageUI.DYNAMIC_DROPDOWN_BY_ROW_AND_COLUMN_INDEX,valueToSelect, rowIndex, colunmIndex);
    }

    public void checkToCheckboxByIndex(String rowIndex, String columnName, boolean checkOrUncheck) {
        int columnIndexNumber = getListElement(driver, HomePageUI.DYNAMIC_PRECEDING_SIBLING_COLUMN_NUMBER, columnName).size() + 1;
        String colunmIndex = String.valueOf(columnIndexNumber);
        if(checkOrUncheck){
            checkToCheckboxRadio(driver, HomePageUI.DYNAMIC_CHECKBOX_BY_ROW_AND_COLUMN_INDEX, rowIndex, colunmIndex);
        }else {
            uncheckToCheckboxRadio(driver, HomePageUI.DYNAMIC_CHECKBOX_BY_ROW_AND_COLUMN_INDEX, rowIndex, colunmIndex);
        }

    }

    public void clickToIconByIndex(String rowIndex, String iconName) {
        waitForElementClickable(driver, HomePageUI.DYNAMIC_ICON_BY_ROW_INDEX, rowIndex, iconName);
        clickToElement(driver, HomePageUI.DYNAMIC_ICON_BY_ROW_INDEX, rowIndex, iconName);
    }

    public List<String> getAllValueAtColumnName(String columnName) {
        int columnIndexNumber = getListElement(driver, HomePageUI.DYNAMIC_PRECEDING_SIBLING_COLUMN_NUMBER_2, columnName).size() + 1;
        String colunmIndex = String.valueOf(columnIndexNumber);
       List<WebElement> allvalue = getListElement(driver, HomePageUI.ALL_VALUE_BY_COLUMN_INDEX, colunmIndex);
       List<String> allTextValue = new ArrayList<>();
       for(WebElement element: allvalue){
           allTextValue.add(element.getText());
       }
       return allTextValue;

    }
}
