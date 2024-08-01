package pageObjects.nopecomerce.users;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.nopecomerce.PageGenerator;
import pageUIs.nopCommerce.users.UserSideBarPageUI;

public class UserSideBarPageObject extends BasePage {
    WebDriver driver;

    public UserSideBarPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public UserAddressPageObject openAddressPage() {
        waitForElementClickable(driver, UserSideBarPageUI.ADDRESS_LINK);
        clickToElement(driver, UserSideBarPageUI.ADDRESS_LINK);
        return PageGenerator.getAddressPage(driver);
    }

    public UserRewardPointPageObject openRewardPointPage() {
        waitForElementClickable(driver, UserSideBarPageUI.REWARD_POINT_LINK);
        clickToElement(driver, UserSideBarPageUI.REWARD_POINT_LINK);
        return PageGenerator.getRewardPoint(driver);
    }

    public UserCustomerInfoPageObject openCustomerInfoPage() {
        waitForElementClickable(driver, UserSideBarPageUI.CUSTOMER_INFO_LINK);
        clickToElement(driver, UserSideBarPageUI.CUSTOMER_INFO_LINK);
        return PageGenerator.getCustomerInfoPage(driver);
    }

    public UserOrderPageObject openOrderPage() {
        waitForElementClickable(driver, UserSideBarPageUI.ORDER_LINK);
        clickToElement(driver, UserSideBarPageUI.ORDER_LINK);
        return PageGenerator.getOrderPage(driver);
    }

    public UserSideBarPageObject openSidebarLinkByPageName(String pageName) {
        waitForElementClickable(driver, UserSideBarPageUI.DYNAMIC_LINK_BY_PAGE_NAME, pageName);
        clickToElement(driver, UserSideBarPageUI.DYNAMIC_LINK_BY_PAGE_NAME, pageName);
        switch (pageName) {
            case "Addresses":
                return PageGenerator.getAddressPage(driver);
            case "Reward points":
                return PageGenerator.getRewardPoint(driver);
            case "Customer info":
                return PageGenerator.getCustomerInfoPage(driver);
            case "Orders":
                return PageGenerator.getOrderPage(driver);
            default:
                throw  new RuntimeException("Page name is not valid!");
        }
    }
    public void openSidebarLinkByPageNames(String pageName) {
        waitForElementClickable(driver, UserSideBarPageUI.DYNAMIC_LINK_BY_PAGE_NAME, pageName);
        clickToElement(driver, UserSideBarPageUI.DYNAMIC_LINK_BY_PAGE_NAME, pageName);
    }
}
