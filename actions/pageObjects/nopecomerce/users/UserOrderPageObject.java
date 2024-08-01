package pageObjects.nopecomerce.users;

import org.openqa.selenium.WebDriver;

public class UserOrderPageObject extends UserSideBarPageObject {
    private WebDriver driver;
    public UserOrderPageObject(WebDriver driver){
        super(driver);
        this.driver=driver;
    }


}
