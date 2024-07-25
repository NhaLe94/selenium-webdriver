package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.AddressPageUI;
import pageUIs.OrderPageUI;
import pageUIs.RewardPointPageUI;

public class RewardPointPageObject extends SideBarPageObject {
    private WebDriver driver;
    public RewardPointPageObject(WebDriver driver){
        super(driver);
        this.driver=driver;
    }


}
