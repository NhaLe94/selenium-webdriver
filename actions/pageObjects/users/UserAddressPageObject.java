package pageObjects.users;

import org.openqa.selenium.WebDriver;

public class UserAddressPageObject extends UserSideBarPageObject {
    private WebDriver driver;
    public UserAddressPageObject(WebDriver driver){
        super(driver);
        this.driver=driver;
    }


}
