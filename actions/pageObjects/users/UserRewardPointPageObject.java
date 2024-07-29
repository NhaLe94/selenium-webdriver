package pageObjects.users;

import org.openqa.selenium.WebDriver;

public class UserRewardPointPageObject extends UserSideBarPageObject {
    private WebDriver driver;
    public UserRewardPointPageObject(WebDriver driver){
        super(driver);
        this.driver=driver;
    }


}
