package pageFactorys;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageUIs.HomePageUI;

public class HomePageFactory extends  BasePage {
    private WebDriver driver;
    public HomePageFactory(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(className = "ico-register")
    private WebElement registerLink;

    @FindBy(className = "ico-account")
    private WebElement myAccountLink;


    public void clickToRegisterLink() {
        waitForElementClickable(driver, registerLink);
        clickToElement(registerLink);
    }

    public boolean isMyAccountLinkDisplayed() {
        waitForElementClickable(driver, myAccountLink);
        return isElementDisplayed(myAccountLink);
    }

    public void clickToMyAccountLink() {
        waitForElementClickable(driver,myAccountLink);
        clickToElement(myAccountLink);
    }
}
