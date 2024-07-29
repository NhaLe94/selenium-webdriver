package pageObjects;

import org.openqa.selenium.WebDriver;
import pageObjects.admin.AdminDashboardPO;
import pageObjects.admin.AdminLoginPO;
import pageObjects.users.*;

public class PageGenerator {
    public static UserHomePageObject getHomePage(WebDriver driver){
        return new UserHomePageObject(driver);
    }
    public static UserLoginPageObject getLoginPage(WebDriver driver){
        return new UserLoginPageObject(driver);
    }
    public static UserRegisterPageObject getRegisterPage(WebDriver driver){
        return new UserRegisterPageObject(driver);
    }
    public static UserCustomerInfoPageObject getCustomerInfoPage(WebDriver driver){
        return new UserCustomerInfoPageObject(driver);
    }
    public static UserAddressPageObject getAddressPage(WebDriver driver){
        return new UserAddressPageObject(driver);
    }
    public static UserOrderPageObject getOrderPage(WebDriver driver){
        return new UserOrderPageObject(driver);
    }
    public static UserRewardPointPageObject getRewardPoint(WebDriver driver){
        return new UserRewardPointPageObject(driver);
    }
    public static AdminLoginPO getAdminLoginPage(WebDriver driver) {
        return new AdminLoginPO(driver);
    }
    public static AdminDashboardPO getAdminDashboardPage(WebDriver driver){
        return new AdminDashboardPO(driver);
    }
}
