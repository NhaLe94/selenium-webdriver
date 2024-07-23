package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage {
    private final WebDriver driver;
    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public void enterToEmailTextbox(String emailAddress) {
        waitForElementClickable(driver, LoginPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, emailAddress);
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementClickable(driver, LoginPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public void clickToLoginButton() {
        waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
        PageGenerator.getLoginPage(driver);
    }
    public HomePageObject LoginToSystem(String emailAddress, String password ){
        enterToEmailTextbox(emailAddress);
        enterToPasswordTextbox(password);
        clickToLoginButton();
        return  PageGenerator.getHomePage(driver);

    }
}
