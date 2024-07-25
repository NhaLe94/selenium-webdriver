package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.OrderPageUI;
import pageUIs.RewardPointPageUI;

public class OrderPageObject extends SideBarPageObject {
    private WebDriver driver;
    public OrderPageObject(WebDriver driver){
        super(driver);
        this.driver=driver;
    }


}
