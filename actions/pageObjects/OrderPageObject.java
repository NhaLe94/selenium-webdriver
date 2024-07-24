package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.OrderPageUI;
import pageUIs.RewardPointPageUI;

public class OrderPageObject extends BasePage {
    private WebDriver driver;
    public OrderPageObject(WebDriver driver){
        this.driver=driver;
    }


}
